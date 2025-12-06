package tests;

import clients.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserProfileTests {

    private UserClient userClient;

    @BeforeClass
    public void setUp()
    {
        userClient= new UserClient();
    }

    @Test
    public void getProfileSuccess(){
        Response response= userClient.getMyProfile();

        System.out.println(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200,"Status code should be 200");

        //Extract field from Json and verify
        String id=response.jsonPath().getString("data.id");
        System.out.println("The user id is: "+id);
        Assert.assertNotNull(id,"User id should not be null");
    }
}
