package clients;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TweetClient extends BaseClient{

    private static final Logger logger= LoggerFactory.getLogger(TweetClient.class);
    private static final String TWEET_BY_ID_ENDPOINT="/tweets/";

    public TweetClient()
    {
        super();
    }

    public Response getTweetById(String tweetID)
    {
        String endpoint=TWEET_BY_ID_ENDPOINT+ tweetID;

        logger.info("Calling GET {}", endpoint);

        Response response= requestSpec
                .when()
                .get(endpoint)
                .then()
                .extract().response();

        return response;
    }



}

