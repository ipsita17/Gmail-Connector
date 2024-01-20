package jar;

import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnection;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class GmailConnection extends BaseConnection {
    public GmailConnection(OperationContext context)
    {
        super(context);
    }

//    final String username = "ipsita.panda@accionlabs.com";
//    final String password = "";
//    String hostname = "smtp.gmail.com";
//    String portNo = "587";
    public Session getSession()
    {
    final String username = "ipsita.panda@accionlabs.com";
    final String password = "";
    String hostname = "smtp.gmail.com";
    String portNo = "587";

    Properties prop = new Properties();
    prop.put("mail.smtp.username", username);
    prop.put("mail.smtp.password", password);
    prop.put("mail.smtp.host", hostname);
    prop.put("mail.smtp.port", portNo);
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.debug", "true");
    prop.put("mail.smtp.socketFactory.port", "587");

    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.starttls.required", "true");
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");


    Session mailSession = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

    return mailSession;
}


}
