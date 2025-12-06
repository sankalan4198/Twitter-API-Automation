package tests;

import clients.PostTweetClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostTweetTests {

    private PostTweetClient postTweetClient;

    @BeforeClass
    public void setUp()
    {
        postTweetClient=new PostTweetClient();
    }

    @Test
    public void postTweet()
    {
        Response response= postTweetClient.postTweet();

        String responseCode= String.valueOf(response.getStatusCode());
        System.out.println(responseCode);

        Assert.assertEquals(responseCode,"401","Incorrect Response code");

        System.out.println(response.getBody().prettyPrint());

    }
}

