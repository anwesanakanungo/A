package api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Booking2 {
    public String firstname;
    public String lastname;
    public int totalprice;
    public Boolean depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;
}