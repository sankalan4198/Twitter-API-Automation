package clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigManager;


/*
UserClient.java is just a wrapper that helps the test talk to Twitter API.
It contains no assertions,only HTTP calls
Test Layer → calls → UserClient → sends request → returns Twitter API response
 */
public class UserClient extends BaseClient{

    private static final Logger logger= LoggerFactory.getLogger(UserClient.class);
    private static final String USER_ENDPOINT="/users/by/username/";

    //Calls BaseClient constructor → which sets up RestAssured (authorization, base URL, etc.)
    public UserClient()
    {
        super();
    }

    public Response getMyProfile()
    {
        String userName= ConfigManager.getUserName();
        String endpoint=USER_ENDPOINT+userName;

        logger.info("Calling GET {}", endpoint);

        Response response=requestSpec.when().get(endpoint).then().extract().response();

        logger.info("Status code: {}", response.getStatusCode());
        logger.info("Response body:\n{}", response.getBody().asPrettyString());

        return response;


    }


}

