package jar;

import com.boomi.connector.api.GetRequest;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.util.BaseGetOperation;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendOperation extends BaseGetOperation {
    public SendOperation(GmailConnection context) {
        super(context);
    }

    @Override
    protected void executeGet(GetRequest getRequest, OperationResponse operationResponse) {

        try
        {
            String username="ipsita.panda@accionlabs.com";
            String password="#ipsita@2000";
            String portNo ="587";
            String hostname="smtp.gmail.com";

            InternetAddress addressFrom = new InternetAddress(username);
            Session mailSession = null;
            MimeMessage message = new MimeMessage(mailSession);
            message.setSender(addressFrom);
            message.setSubject("Test Mail- Ipsita2");
            message.setContent("testing mailing program", "text/plain");
            final InternetAddress[] recipientAddresses = InternetAddress.parse("ballolliusha@gmail.com");
            message.setRecipients(MimeMessage.RecipientType.TO, recipientAddresses);
            final Transport transport = mailSession.getTransport("smtp");
            transport.connect(hostname, Integer.parseInt(portNo), username, password);
            transport.sendMessage(message, recipientAddresses);
            transport.close();

        }

        catch(Exception e)

        {
            System.out.println("error");
        }

    }
}
