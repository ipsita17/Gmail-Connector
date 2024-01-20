package jar;

import com.boomi.connector.api.*;
import com.boomi.connector.util.BaseBrowser;
import com.boomi.util.CollectionUtil;

import java.util.Collection;
import java.util.Set;

public class GmailBrowser extends BaseBrowser {
    private static final String OBJECT_TYPE = "Gmail";
    private static final Set<FieldSpecField> FILTERS = CollectionUtil.asImmutableSet(
            new FieldSpecField().withName("fromFolder").withType("folder").withFilterable(true),
            new FieldSpecField().withName("fromAddress").withType("address").withFilterable(true),
            new FieldSpecField().withName("subject").withType("subject").withFilterable(true),
            new FieldSpecField().withName("receivedDate").withType("dateTime").withFilterable(true),
            new FieldSpecField().withName("read").withType("boolean").withFilterable(true));


    protected GmailBrowser(BrowseContext context)
    {
        super(context);
    }

    @Override
    public ObjectTypes getObjectTypes()
    {
        return new ObjectTypes().withTypes(new ObjectType().withId(OBJECT_TYPE).withLabel(OBJECT_TYPE));
    }

    @Override
    public ObjectDefinitions getObjectDefinitions(String s, Collection<ObjectDefinitionRole> collection) {
        if (getContext().getOperationType() == OperationType.DELETE) {
            ObjectDefinition definition = new ObjectDefinition().withInputType(ContentType.XML).withOutputType(ContentType.NONE);
            return new ObjectDefinitions().withDefinitions(definition);
        }
        if (getContext().getOperationType() == OperationType.QUERY) {
            ObjectDefinition definition = new ObjectDefinition().withInputType(ContentType.NONE).withOutputType(ContentType.BINARY).withFieldSpecFields(FILTERS);
            return new ObjectDefinitions().withDefinitions(definition);
        }
        throw new UnsupportedOperationException();

    }
}

