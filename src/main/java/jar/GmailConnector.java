package jar;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;

public class GmailConnector extends BaseConnector {
    @Override
    public Browser createBrowser(BrowseContext context)
    {
        return new GmailBrowser(context);
    }

    public Operation createGetOperation(OperationContext context)
    {

        return new SendOperation(new GmailConnection(context) );
    }

}
