package api.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingDates {
    public String checkin;
    public String checkout;
}
