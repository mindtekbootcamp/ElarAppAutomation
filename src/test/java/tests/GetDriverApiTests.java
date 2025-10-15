package tests;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.APIUtils;
import utilities.ApiTestBase;
import utilities.ConfigReader;
import static io.restassured.RestAssured.given;

public class GetDriverApiTests extends ApiTestBase {

    @Test(groups = {"smoke","regression"})
    public void GetDriverApiTest(){
        String id=postResponse.body().jsonPath().getString("id");
        Response getResponse= APIUtils.getAPICall(token,id);
        Assert.assertEquals(getResponse.getStatusCode(), 200);
        Assert.assertEquals(getResponse.body().jsonPath().getString("id"), id);

    }

    @Test(groups = {"regression"})
    public void getDriverApiWithoutTokenTest(){
        String id=postResponse.body().jsonPath().getString("id");
        Response getResponse=APIUtils.getAPICall(id);
        Assert.assertEquals(getResponse.getStatusCode(), 401);
        Assert.assertEquals(getResponse.body().jsonPath().getString("message"), "Unauthorized");

    }

    @Test(groups = {"smoke","regression"})
    public void GetDriverWithIdThatDoesntExist(){
        Response getResponse=APIUtils.getAPICall(token,"5000");
        Assert.assertEquals(getResponse.getStatusCode(), 404);
        Assert.assertEquals(getResponse.body().jsonPath().getString("detail"), "Item not found");

    }

}
