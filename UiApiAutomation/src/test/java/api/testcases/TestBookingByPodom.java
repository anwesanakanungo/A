package api.testcases;

import api.pojo.Booking;
import api.pojo.BookingDates;
import api.requestBuilder.RequestBuilder;
import api.util.ApiUtil;
import api.util.DataStore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static frameworkconstants.FrameWorkConstants.WRITERESPONSETOJSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestBookingByPodom {
    private static Booking booking;
    private static BookingDates bookingDates;
    private RequestBuilder requestBuilder;

    @Test
    public void createBookingByPodom() {
        PodamFactory factory = new PodamFactoryImpl();
       Booking booking= factory.manufacturePojo(Booking.class);
        Response response = RequestBuilder.bulidRequestForPostCall()
                .body(booking)
                .post("/booking");
        response.prettyPrint();
        JsonPath getJsonValue = response.jsonPath();
        int bookingid = getJsonValue.get("bookingid");
        System.out.println(bookingid);
        DataStore.setValue("bookingid", bookingid);
        //Verify the response code in 200
        assertThat(response.statusCode())
                .isEqualTo(200);
        //Verify response body
        assertThat(response.getBody().asString())
                .isNotEmpty()
                .contains("firstname")
                .contains("lastname");
//Write the response in file
        ApiUtil.storeJsonResponse(WRITERESPONSETOJSON, response);
    }
}