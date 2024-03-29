package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.filters;

import gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.entities.Fruit;
import org.apache.camel.Exchange;

public class FruitFilter {

    public boolean isAllowedId(Exchange exchange) {

        return exchange.getMessage().getBody(Fruit.class).getId() != 1;
    }
}