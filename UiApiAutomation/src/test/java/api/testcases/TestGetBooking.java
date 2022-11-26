package api.testcases;

import api.requestBuilder.RequestBuilder;
import api.util.ApiUtil;
import api.util.DataStore;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static frameworkconstants.FrameWorkConstants.WRITERESPONSETOJSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestGetBooking {
    private RequestBuilder requestBuilder;

    @Test
    public void getBookingByPoJo() {

        Response response = RequestBuilder.bulidRequestForGetCall()
                .get("/booking/" + DataStore.getValue("bookingid"));

        response.prettyPrint();
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