package clients;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

/*Utilisation of BaseClient
*****Sets vase URI from config****
*****Adds Authorization header via bearer token***
*****Sets default content type****
 */
public class BaseClient {

    protected RequestSpecification requestSpec;
    protected RequestSpecification postRequestSpec;

    public BaseClient() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();

        requestSpec = RestAssured
                .given()
                .header("Authorization", "Bearer " + ConfigManager.getBearerToken())
                .header("Content-Type", "application/json");

        postRequestSpec=RestAssured
                .given()
                .formParam("oauth_consumer_key","ElqbWZKiOSwfJx1UJOjbvyzqQ")
                .formParam("oauth_nonce","r7T6QVVilWD")
                .formParam("oauth_signature","2Ed4uv9T%2BLDP2ASawDXcKB7gIX8%3D")
                .formParam("oauth_signature_method","HMAC-SHA1")
                .formParam("oauth_timestamp","1764844421")
                .formParam("oauth_token","1996185617122934784-XvPNKfiS5ulBhnM1lqkofBMmrrOUoz")
                .formParam("oauth_version","1.0")
                .header("Content-Type", "application/json");
    }
}
