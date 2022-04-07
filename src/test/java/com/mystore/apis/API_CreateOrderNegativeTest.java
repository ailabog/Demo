package com.mystore.apis;

import com.mystore.utils.connectors.RestAssuredConnector;
import com.mystore.utils.general.ConfigUtils;
import com.mystore.utils.general.ConfigUtils.ConfigKeys;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Create Order POST API call negative
 */

public class API_CreateOrderNegativeTest {
    protected static final Logger logger = LoggerFactory.getLogger(API_CreateOrderNegativeTest.class);

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String requestBody;
    private String requestUri;

    @BeforeTest
    public void setupData() {
        PostOrderCreateModel requestMessageBody = new PostOrderCreateModel();
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
        assertEquals(someResponse.getStatusCode(), 400);
    }

    @Test
    public void createPostOrderMissingHeaderTest() {
        Map<String, String> requestHeaders = new HashMap<String, String>();
        Response someResponse = connector.postRequest(requestUri, requestHeaders, requestBody);
        logger.info("requestUri" + requestUri + "" + "requestBody: " + requestBody);
        logger.info("Response: " + someResponse.getBody().asString());
        assertEquals(someResponse.getStatusCode(), 415);
    }
}
