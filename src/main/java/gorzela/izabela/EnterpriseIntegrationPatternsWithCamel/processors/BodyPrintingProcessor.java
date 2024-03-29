package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class BodyPrintingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getMessage().getBody().toString());
    }
}