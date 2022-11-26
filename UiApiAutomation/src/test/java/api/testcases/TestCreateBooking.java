package api.testcases;

import api.pojo.Booking;
import api.pojo.BookingDates;
import api.requestBuilder.RequestBuilder;
import api.util.ApiUtil;
import api.util.DataStore;
import api.util.RandomUtil;
import frameworkconstants.FrameWorkConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static frameworkconstants.FrameWorkConstants.WRITERESPONSETOJSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCreateBooking {

    private static Booking booking;
    private static BookingDates bookingDates;
    private RequestBuilder requestBuilder;

    @Test
    public void createBookingByPoJo() {

        bookingDates = new BookingDates();
        bookingDates.setCheckin(RandomUtil.getFromDate());
        bookingDates.setCheckout(RandomUtil.getDateToday());
        booking = Booking.builder()
                .setFirstname(RandomUtil.getFirstName())
                .setLastname(RandomUtil.getLastName())
                .setTotalprice(RandomUtil.getNumber())
                .setAdditionalneeds(RandomUtil.getFood())
                .setDepositpaid(RandomUtil.getBooleanValueTrue())
                .setBookingdates(bookingDates)
                .build();
        Response response = RequestBuilder.bulidRequestForPostCall()
                .body(booking)
                .post("/booking");
        response.prettyPrint();
        JsonPath getJsonValue = response.jsonPath();
        int bookingid = getJsonValue.get("bookingid");
        System.out.println(bookingid);
        DataStore.setValue("bookingid", bookingid);
        System.out.println(DataStore.getValue("bookingid"));
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

    @Test
    public void createBookingByReadingJsonFile() {
        String data = ApiUtil.readJsonFileGetAsString(FrameWorkConstants.BASEFILEPATHINPUTJSON)
                .replace("fname", RandomUtil.getFirstName())
                .replace("lname", RandomUtil.getLastName());
        Response response = RequestBuilder.bulidRequestForPostCall()
                .body(data)
                .post("/booking");
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
        response.prettyPrint();

    }
}

