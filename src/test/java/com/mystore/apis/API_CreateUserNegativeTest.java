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
 * Create User POST API call negative
 */

public class API_CreateUserNegativeTest {
    protected static final Logger logger = LoggerFactory.getLogger(API_CreateUserNegativeTest.class);

    public static final String ID = GenerateRandomDataUtils.generateRandomNumber(1);
    public static final String USERNAME = GenerateRandomDataUtils.generateRandomString(4);
    public static final String FIRSTNAME = GenerateRandomDataUtils.generateRandomString(4);
    public static final String LASTNAME = GenerateRandomDataUtils.generateRandomString(4);
    public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(4);
    public static final String EMAIL = "Auto"+ GenerateRandomDataUtils.generateEmail(12);
    public static final String PHONE = "0734568901";
    public static final String USER_STATUS = "0";

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String requestBody;
    private String requestUri;

    @BeforeTest
    public void setupData() {
        PostUserCreateModel requestMessageBody = new PostUserCreateModel();
        requestMessageBody.setId(ID);
        requestMessageBody.setUsername(USERNAME);
        requestMessageBody.setFirstName(FIRSTNAME);
        requestMessageBody.setLastName(LASTNAME);
        requestMessageBody.setEmail(EMAIL);
        requestMessageBody.setPassword(PASSWORD);
        requestMessageBody.setPhone(PHONE);
        requestMessageBody.setUserStatus(USER_STATUS);
        requestBody = requestMessageBody.toString();
        requestUri = ConfigUtils.getProperty(ConfigKeys.BASE_URL.toString()) + ConfigUtils.getProperty(ConfigKeys.END_URL_USER.toString());
    }

    @Test
    public void createPostUserTest() {
        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("accept", " application/json");
        requestHeaders.put("Content-Type", "application/json");
        Response someResponse = connector.postRequest(requestUri, requestHeaders, requestBody);
        logger.info("requestUri" + requestUri + "" + "requestBody: " + requestBody);
        logger.info("Response: " + someResponse.getBody().asString());
        assertEquals(someResponse.getStatusCode(), 400);
    }
}
