package api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Address {
    private String city;
    private String country;
}
