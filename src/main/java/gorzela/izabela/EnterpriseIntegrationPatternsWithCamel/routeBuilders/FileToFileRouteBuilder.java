package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.routeBuilders;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
                .choice()
                .when(header("CamelFileName").endsWith(".csv")).to("file:sampleDirectory/toForCsv")
                .when(header("CamelFileName").endsWith(".md")).to("file:sampleDirectory/toForMd")
                .when(header("CamelFileName").endsWith(".xml")).to("file:sampleDirectory/toForXml")
                .otherwise().to("file:sampleDirectory/toForOther")
                .end();
    }
}