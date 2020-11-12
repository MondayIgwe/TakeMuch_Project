package rest;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import java.net.URI;
import java.net.URISyntaxException;

public class Rest_Assured_NO_CUCUMBER {

    Response response, response1;

    @BeforeClass
    public static void setUp() {
        // Specify the base URL to the RESTful web service
        baseURI = Rest_Interface.BASEURI;
    }

    @Test
    public void GetWeatherDetails() throws URISyntaxException {
        /**
         * REQUEST SPEC
         */
        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = given().auth().none().contentType("APPLICATION/JSON");
        RequestSpecification b = httpRequest.urlEncodingEnabled(true);
        System.out.println("url Encoding Enabled: " + b);


        /**
         * RESPONSE SPEC
         * Make a request to the server by specifying the method Type and the method URL.
         * This will return the Response from the server. Store the response in a variable.
         */
        response = httpRequest.request(Method.GET, Rest_Interface.PARAM);
        response1 = httpRequest.get(new URI(Rest_Interface.COOKIES));
        String contentType = response1.getHeader("Content-Type");

        /**
         * Now let us print the body of the message to see what response
         * we have received from the server
         */

        String responseBody = response.getBody().asString();
        System.out.println("*************************************");
        String responseBody1 = response1.getBody().asString();

        Headers headers = response.getHeaders();
        System.out.println("Response Body is =>  " + responseBody
                + "\n" + "get Content Type: " + contentType + ":: \n status Line: " + response.getStatusLine()
                + "\n Cookies:" + response.getDetailedCookies() + "\n Headers: \n" + headers +
                "\nSTATUS CODE: " + response1.getStatusCode() + "=======\n" + response1.getHeaders());

        System.out.println();
        System.out.println("*************HEADERS***********************");
        for (Header myHeader : headers) {
            System.out.println("My headers: " + myHeader);
        }
        /*
            Validate nodes using JSON and XML PATH
         */
        JsonPath j = response1.jsonPath();
        System.out.println("get the JSONPATH=========================== "+j.get("cookies"));

//        XmlPath xmlPath = response.xmlPath();
//        System.out.println("get the XMLPATH=========================== "+xmlPath.get());

        //Assert StatusCode
        Assert.assertEquals("Validate Status Code: ", response.getStatusCode(), 200);
        Assert.assertEquals("Validate Status Code1: ", response1.getStatusCode(), 200);
        Assert.assertEquals("Validate Header: ", contentType, "application/json");
        org.testng.Assert.assertEquals(responseBody1.contains("cookies"), true, "Response Body contains COOKIES");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
    }
}
