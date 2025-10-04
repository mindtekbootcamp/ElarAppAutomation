package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiTestBase;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class GetDriverApiTests extends ApiTestBase {

    @Test(groups = {"smoke","regression"})
    public void GetDriverApiTest(){
        String id="2468";
        Response getResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Cookie",token)
                .and().log().all()
                .when().get("/drivers/"+id);

        getResponse.then().log().all();
        Assert.assertEquals(getResponse.getStatusCode(), 200);
        Assert.assertEquals(getResponse.body().jsonPath().getString("id"), id);

    }

    @Test(groups = {"regression"})
    public void getDriverApiWithoutTokenTest(){
        Response getReponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept", "application/json")
                .and().log().all()
                .when().get("/drivers");

        getReponse.then().log().all();
        Assert.assertEquals(getReponse.getStatusCode(), 401);
        Assert.assertEquals(getReponse.body().jsonPath().getString("message"), "Unauthorized");

    }

    @Test(groups = {"smoke","regression"})
    public void GetDriverWithIdThatDoesntExist(){
        Response getResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .when().get("/drivers/5000");

        getResponse.then().log().all();
        Assert.assertEquals(getResponse.getStatusCode(), 404);
        Assert.assertEquals(getResponse.body().jsonPath().getString("detail"), "Item not found");

    }

}
