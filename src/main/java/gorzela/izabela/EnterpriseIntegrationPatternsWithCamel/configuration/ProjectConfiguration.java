package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.configuration;

import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfiguration {

    @Bean
    BindyCsvDataFormat BindyCsvDataFormatBean() {

        return new BindyCsvDataFormat();
    }
}