package gorzela.izabela.EnterpriseIntegrationPatternsWithCamel.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@CsvRecord(separator = ",", skipFirstLine = true)
@ToString
@Entity
public class Fruit {

    @Id
    @DataField(pos = 1)
    private Integer id;

    @DataField(pos = 2)
    private String name;

    @DataField(pos = 3)
    private String color;

    @DataField(pos = 4)
    private Double price;
}