package api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
@Data
@Builder(setterPrefix = "set")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class User {
    private String name;
    private String area;
    private String author;
    private int id;
    private ArrayList<String> topics;
    private Address address;
}
