package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processsors;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.headers.ExtensionHeader;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExtensionHeaderPrintingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ExtensionHeader extensionHeader = exchange.getMessage().getHeader(ExtensionHeader.FILE_EXTENSION_HEADER, ExtensionHeader.class);
        if(extensionHeader == null) {
            System.out.println("File Extension Header is not set");
        }
        else {
            System.out.println("File Extension Header: " + extensionHeader);
        }
    }
}