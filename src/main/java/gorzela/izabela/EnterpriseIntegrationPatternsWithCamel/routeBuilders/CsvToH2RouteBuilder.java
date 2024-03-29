package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.routeBuilders;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.entities.Fruit;
import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processor.SimplePrintingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CsvToH2RouteBuilder extends RouteBuilder {

    @Autowired
    private SimplePrintingProcessor simplePrintingProcessor;

    @Autowired
    private BindyCsvDataFormat bindyCsvDataFormat;
    @Override
    public void configure() throws Exception {

        bindyCsvDataFormat.setClassType(Fruit.class);

        from("file:sampleDirectory/from")
                .unmarshal(bindyCsvDataFormat)
                .split(body())
                .process(simplePrintingProcessor)
                .to("jpa:t2");
    }
}