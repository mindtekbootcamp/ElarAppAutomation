package utilities;

import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public static Response getAPICall(String token,String id){
        Response getResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Cookie",token)
                .and().log().all()
                .when().get("/drivers/"+id);
        getResponse.then().log().all();
        return getResponse;
    }

    public static Response getAPICall(String id){
        Response getResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().log().all()
                .when().get("/drivers/"+id);
        getResponse.then().log().all();
        return getResponse;
    }

    public static Response postAPICall(String token,String body){
        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Content-type","application/json")
                .and().header("Cookie",token)
                .and().body(body)
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),200);
        return postResponse;
    }

}
