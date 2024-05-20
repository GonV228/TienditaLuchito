
package Procesos;
//clases
import VistaLogin.Recuperar_1Correo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//librerias
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaMail {
    //vistas
    Recuperar_1Correo VistaCorreo;
    //traer codigo
    private String codigoAleatorio;
    //inicializar
    private static String emailFrom="bodeguitaluchito@gmail.com";
    private static String passwordFrom="xete nlkg pzkj vxnq";
    private String emailTo;//dirección de correo
    private String subject;//asunto
    private String contenido;//contenido
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    
    public JavaMail(String codigo, String correodestino){
        this.codigoAleatorio=codigo;
        this.emailTo=correodestino;
        mProperties=new Properties();
        System.out.println("estoy en el constructor");
        createEmail();
        sendEmail();
    }
    
    private void createEmail(){
        System.out.println("estoy en createEmail");
        //emailTo = emailTo;
        subject = "Código de recuperación para iniciar sesión en la Bodeguita de Luchito";
        contenido = ("Código de verificación: "+codigoAleatorio);
        
        //Simple mail tranfer protocol
        mProperties.put("mail.smtp.host","smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        //mSession = Session.getDefaultInstance(mProperties);
        mSession = Session.getInstance(mProperties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, passwordFrom);
            }
        });
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(contenido, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendEmail(){
        System.out.println("Estoy en sendEmail");
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom,passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getAllRecipients());
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
