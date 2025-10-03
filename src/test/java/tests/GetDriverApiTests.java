package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetDriverApiTests {

    @Test
    public void getDriverApiPositiveTest(){
        Response getResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1OTQ0MjgyNH0.QIbs5wHpEEAnlkfb-qetCpG07CAowbrpUyoPQYUvRog; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTk0NDI4MjR9.2K4yVKQU9OYj9eSj7Pa57HEjangSLZNQQ9BDPNYGxyM")
                .and().log().all()
                .when().get("/drivers/2812");

        getResponse.then().log().all();



    }

}
