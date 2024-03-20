package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processsors;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.headers.ExtensionHeader;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExtensionHeaderSettingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String fileName = exchange.getMessage().getHeader(Exchange.FILE_NAME, String.class);
        String[] splittedFileName = fileName.split("\\.");
        String fileExtension = splittedFileName[splittedFileName.length - 1];
        if(fileExtension.equalsIgnoreCase("txt") || fileExtension.equalsIgnoreCase("csv") && splittedFileName.length != 1) {
            exchange.getMessage().setHeader(ExtensionHeader.FILE_EXTENSION_HEADER, ExtensionHeader.valueOf(fileExtension.toUpperCase()));
        }
        else {
            exchange.getMessage().setHeader(ExtensionHeader.FILE_EXTENSION_HEADER, ExtensionHeader.valueOf("OTHER"));
        }
    }
}