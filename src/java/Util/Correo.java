
package Util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Correo{

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	public static void EnviarCorreo(String contra,String correo) {
		final String usuario = "**********";//Correo del profe 
		final String contraseña = "*********"; //Contra del profe
		final String destino = correo; 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Puerto
		props.put("mail.smtp.auth", "true"); //authentication
		props.put("mail.smtp.starttls.enable", "true"); // STARTTLS
		
                
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contraseña);
			}
		};
		Session session = Session.getInstance(props, auth);
		try{
                
		EmailUtil.sendEmail(session, destino,"Cambio de contraseña VehiShop", "Tu nueva contraseña es: "+contra);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
		
	}

	
}