package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.routeBuilders;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.entities.Fruit;
import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.filters.FruitFilter;
import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processors.BodyPrintingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private BodyPrintingProcessor bodyPrintingProcessor;
    @Override
    public void configure() throws Exception {

        from("file:sampleDirectory/from")
                .unmarshal()
                .json(JsonLibrary.Jackson, Fruit[].class)
                .split().body()
                .filter().method(FruitFilter.class,"isAllowedId")
                .process(bodyPrintingProcessor).stop();
    }
}