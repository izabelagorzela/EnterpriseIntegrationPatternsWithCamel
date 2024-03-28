package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SimplePrintingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println(exchange.getMessage().getBody().toString());
    }
}