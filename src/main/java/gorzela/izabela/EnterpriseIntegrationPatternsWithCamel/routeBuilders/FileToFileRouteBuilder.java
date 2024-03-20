package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.routeBuilders;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processsors.ExtensionHeaderPrintingProcessor;
import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processsors.ExtensionHeaderSettingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private ExtensionHeaderPrintingProcessor extensionHeaderPrintingProcessor;

    @Autowired
    private ExtensionHeaderSettingProcessor extensionHeaderSettingProcessor;
    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
                .process(extensionHeaderPrintingProcessor)
                .process(extensionHeaderSettingProcessor)
                .process(extensionHeaderPrintingProcessor)
                .to("file:sampleDirectory/to");
    }
}