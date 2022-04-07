package com.mystore.apis;

import com.mystore.utils.connectors.RestAssuredConnector;
import com.mystore.utils.general.ConfigUtils;
import com.mystore.utils.general.ConfigUtils.ConfigKeys;
import com.mystore.utils.general.GenerateRandomDataUtils;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Create Order POST API call positive
 */

public class API_CreateOrderPositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(API_CreateOrderPositiveTest.class);
    public static final String ID = GenerateRandomDataUtils.generateRandomNumber(1);
    public static final String PET_ID = GenerateRandomDataUtils.generateRandomNumber(1);
    public static final String QUANTITY = "12";
    public static final String SHIP_DATE = "2022-04-06T21:49:54.297Z";
    public static final String STATUS = "Placed";
    public static final String COMPLETE = "true";

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String requestBody;
    private String requestUri;

    @BeforeTest
    public void setupData() {
        PostOrderCreateModel requestMessageBody = new PostOrderCreateModel();
        requestMessageBody.setId(ID);
        requestMessageBody.setPetId(PET_ID);
        requestMessageBody.setQuantity(QUANTITY);
        requestMessageBody.setShipDate(SHIP_DATE);
        requestMessageBody.setStatus(STATUS);
        requestMessageBody.setComplete(Boolean.valueOf(COMPLETE));
        requestBody = requestMessageBody.toString();
        requestUri = ConfigUtils.getProperty(ConfigKeys.BASE_URL.toString()) + ConfigUtils.getProperty(ConfigKeys.END_URL_ORDER.toString());
    }

    @Test
    public void createPostOrderTest() {
        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("accept", " application/json");
        requestHeaders.put("Content-Type", "application/json");
        Response someResponse = connector.postRequest(requestUri, requestHeaders, requestBody);
        logger.info("requestUri" + requestUri + "" + "requestBody: " + requestBody);
        logger.info("Response: " + someResponse.getBody().asString());
        assertEquals(someResponse.getStatusCode(), 200);
    }
}
