package tests;

import clients.TweetClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigManager;

public class GetTweetTests {

    private TweetClient tweetClient;

    @BeforeClass
    public void setUp()
    {
        tweetClient=new TweetClient();
    }


    @Test
    public void getTweetById()
    {
        Response response= tweetClient.getTweetById(ConfigManager.get("tweetID"));

        String id= response.jsonPath().getString("data.id");
        String text=response.jsonPath().getString("data.text");

        System.out.println("The tweet text is: "+text);

        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(id,"1996509658564239570","Tweet ID doesn't match");
        Assert.assertEquals(text,"Test Tweet", "Tweet  doesn't matches");

    }
}
