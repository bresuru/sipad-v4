package sipad.sena.controladores;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transaction;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@ViewScoped
public class mailController implements Serializable {

    @EJB
    private LoginFacadeLocal loginFacadeLocal;
    private Login login;

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;

    private Correo correo;

    @PostConstruct
    private void init() {
        login = new Login();
        correo = new Correo();
        usuario = new Usuario();
    }

    //GETTHER Y SETTHERS
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    //METODOS:
    //Metodo de envio correo
    private void correo() {

        String user = "sipadjavamail@gmail.com";
        String pass = "sipad2019";
        String host = "smtp.gmail.com";

        try {

            //Creo la variable properties
            Properties p = new Properties();

            //Establesco la conexion
            p.setProperty("mail.smtp.host", host);
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.stmp.starttls.required", "false");

            p.setProperty("mail.smtp.user", user);
            p.setProperty("mail.smtp.password", pass);
            p.setProperty("mail.smtp.auth", "true");

            //Creo la session
            Session s = Session.getDefaultInstance(p);

            //estilos para correos
            BodyPart estilos = new MimeBodyPart();
            estilos.setContent(correo.getTexto(), "text/html");

            // BodyPart adjunto = new MimeBodyPart();
            //adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/MAGG/Documents/Imagenes/imagenes/bocaneiros.png.png")));
            //adjunto.setFileName(".png");
            //creeo el multipart
            Multipart multi = new MimeMultipart();
            multi.addBodyPart(estilos);
            // multi.addBodyPart(adjunto);

            //Creo la variable mime
            MimeMessage mm = new MimeMessage(s);

            //Ingreso el correo al que se va enviar
            mm.setFrom(new InternetAddress(correo.getPara()));
            mm.setRecipient(Message.RecipientType.TO, new InternetAddress(correo.getPara()));

            //Asunto del correo
            mm.setSubject(correo.getAsunto());
            //Texto del mensaje
            mm.setContent(multi, "text/html; charset=utf-8;");

            //Creo la variable transport
            Transport tp = s.getTransport("smtp");

            //Creo la conexion
            tp.connect(host, user, pass);

            //Envio el correo
            tp.sendMessage(mm, mm.getAllRecipients());

            //Cierro la conexion
            tp.close();

        } catch (MessagingException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Se e" + e.getMessage()));
            e.printStackTrace();
        }

    }

    //Metodo de envio correo Measivo
    private void correoMasivo(List<Usuario> lista) {

        String user = "sipadjavamail@gmail.com";
        String pass = "sipad2019";
        String host = "smtp.gmail.com";

        try {

            //Creo la variable properties
            Properties p = new Properties();

            //Establesco la conexion
            p.setProperty("mail.smtp.host", host);
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.stmp.starttls.required", "false");

            p.setProperty("mail.smtp.user", user);
            p.setProperty("mail.smtp.password", pass);
            p.setProperty("mail.smtp.auth", "true");

            //Creo la session
            Session s = Session.getDefaultInstance(p);

            //estilos para correos
            BodyPart estilos = new MimeBodyPart();
            estilos.setContent(correo.getTexto(), "text/html");

            //BodyPart adjunto = new MimeBodyPart();
            //adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/MAGG/Documents/Imagenes/imagenes/bocaneiros.png.png")));
            //adjunto.setFileName(".png");
            //creeo el multipart
            Multipart multi = new MimeMultipart();
            multi.addBodyPart(estilos);
            //multi.addBodyPart(adjunto);

            //Creo la variable mime
            MimeMessage mm = new MimeMessage(s);

            //Ingreso el correo al que se va enviar
            mm.setFrom(new InternetAddress(user));

            for (Usuario usuario1 : lista) {
                if (usuario1.getEps() != null) {
                    if (!usuario1.getEps().equals("")) {
                        mm.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario1.getEps()));
                    }
                }
            }

            //Asunto del correo
            mm.setSubject(correo.getAsunto());
            //Texto del mensaje
            mm.setContent(multi, "text/html; charset=utf-8;");

            //Creo la variable transport
            Transport tp = s.getTransport("smtp");

            //Creo la conexion
            tp.connect(host, user, pass);

            //Envio el correo
            tp.sendMessage(mm, mm.getAllRecipients());

            //Cierro la conexion
            tp.close();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Se ha enviado el correo exitosamente"));

        } catch (MessagingException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Error al enviar el correo"));
            e.printStackTrace();
        }

    }

    //Metodo de recuperacion de contraseña
    public void recupararContraseña() {
        //creo las variable que voy usar
        Usuario user = null;
        Login l = null;
        int pass;
        String nueva = "";

        //Busco al usuario
        user = usuarioFacadeLocal.find(usuario.getDocumento());

        //verifico que el usuario exista 
        if (user != null) {

            if (user.getEps().equals(correo.getPara())) {
                //Busco el login del usurio
                l = loginFacadeLocal.find(user.getIdLogin().getIdLogin());

                //Se crea la nueva contraseña de recuperacion
                pass = (int) (Math.random() * 34520 + 23);
                nueva = "s" + pass + "bn";

                //Edito la nueva contraseña
                l.setContrasena(nueva);

                //Guardo la nueva contraseña en la base de datos
                loginFacadeLocal.edit(l);

                //Modifico el asunto del correo
                correo.setAsunto("Recuperacion de contraseña");

                //Modidico el texto del correo
                String mensaje;
                mensaje = "Se ha modificado la contraseña de su usuario " + l.getUsuario() + " Su nuevo contraseña para poder ingresar es: " + nueva;
                mensaje = estiloCorreo(mensaje);
                correo.setTexto(mensaje);

                //Envio el correo al usuario
                this.correo();

                //Mensaje hacia el usuario
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "Se envio la contraseña a su correo"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "El correo no concuerda con el registrado en el sistema"));
            }

        } else {
            //Mensaje hacia el usuario
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso: ", "El usuario no esta registrado en el sistema"));
        }
    }

    //correo enviar a todos
    public void enviarCorreoT() {

        List<Usuario> lista = null;

        try {

            lista = usuarioFacadeLocal.findAll();

            correo.setTexto(estiloCorreo(correo.getTexto()));

            correoMasivo(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //correo enviar a profesores
    public void enviarCorreoP() {

        List<Usuario> lista = null;

        try {

            lista = usuarioFacadeLocal.fintTipoUser(2, 1);

            correo.setTexto(estiloCorreo(correo.getTexto()));

            correoMasivo(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //correo enviar a estudiantes
    public void enviarCorreoE() {

        List<Usuario> lista = null;

        try {

            lista = usuarioFacadeLocal.fintTipoUser(1, 1);

            correo.setTexto(estiloCorreo(correo.getTexto()));

            correoMasivo(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //correo enviar a supervisores
    public void enviarCorreoS() {

        List<Usuario> lista = null;

        try {

            lista = usuarioFacadeLocal.fintTipoUser(3, 1);

            correo.setTexto(estiloCorreo(correo.getTexto()));
            
            correoMasivo(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //estilos de correo pricinpal
    public String estiloCorreo(String mensaje) {

        String men = null;

        String head;
        String body;
        String html;

        String header;
        String footer;
        String main;

        String container;
        String imgUrl = "https://arrayanesfutbol.com/wp-content/uploads/2019/03/bocaneiros.png.png";

        try {

            //El head del html
            head = "<head>"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>"
                    + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">"
                    + "</head>";

            //Cuerpo del mensaja body:
            //encabezado
            header = "<header style=\"background-color: rgb(15,121,111); padding: 10px; width: 100%; color: white; text-align: center; \" class=\"container bg-danger p-3\">"
                    + "<img style=\"width: 100px;\" src=" + imgUrl + ">"
                    + "<h2>"
                    + "Club Deportivo Bocaneiros"
                    + "</h2>"
                    + "</header>";
            //Mensaje principal
            main = "<div style=\"background-color: rgb(250,250,250); width: 100%; padding: 10px;\">"
                    + "<h4>"
                    + mensaje
                    + "</h4>"
                    + "</div>";

            //pie de pagina/footer.
            footer = "<footer style=\"background-color: rgb(15,121,111); padding: 10px; width: 100%; color: white; text-align: center;\">"
                    + "<h5>"
                    + "@ClubDeportivoBocaneiros"
                    + "<br/>"
                    + "#ClubDeportivoBocaneiros"
                    + "</h5>"
                    + "</footer>";

            //los guardo en el body
            container = "<div style=\"margin: auto; width: 70%\">" + header + main + footer + "</div>";
            body = "<body style=\"background: rgb(220,220,220); padding: 5px;\">"
                    + container
                    + "</body>";

            //Armar el mensaje:
            html = "<!DOCTYPE html><html>" + head + body + "</html>";

            //Guardo todo en el mensaje
            men = html;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return men;

    }

}
