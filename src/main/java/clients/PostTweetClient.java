package clients;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTweetClient extends BaseClient{

    private static final Logger logger= LoggerFactory.getLogger(PostTweetClient.class);
    private static final String TWEET_POST= "/tweets/";

    public PostTweetClient(){
        super();
    }

    public Response postTweet()
    {
        String endpoint=TWEET_POST;

        logger.info("Calling POST {}",endpoint);

        Response response= postRequestSpec
                .when()
                .post(endpoint)
                .then()
                .extract().response();

        return response;
    }

}
