package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostDriverApiTest {

    @Test
    public void createDriverApiPositiveTest(){
        String full_name="Patel Harsh";
        String is_staff="false";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Content-type","application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1OTQ0MjgyNH0.QIbs5wHpEEAnlkfb-qetCpG07CAowbrpUyoPQYUvRog; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTk0NDI4MjR9.2K4yVKQU9OYj9eSj7Pa57HEjangSLZNQQ9BDPNYGxyM")
                .and().body("{\n" +
                        "  \"full_name\": \""+full_name+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": "+is_staff+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-29\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-29\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),200);
        Assert.assertEquals(postResponse.body().jsonPath().getString("full_name"), full_name);
        Assert.assertEquals(postResponse.body().jsonPath().getString("is_staff"), is_staff);
    }

    @Test
    public void createDriverApiWithMoreThan50CharsNameTest(){
        String full_name="fwuniuvwivneriuiuvnuvnijsdbfkjdansfkjnfhouiefniuenfuiwenbviuweviuwdebviuwdbnf";
        String is_staff="false";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept","application/json")
                .and().header("Content-type","application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IkFjY2VzcyIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc1OTQ0MjgyNH0.QIbs5wHpEEAnlkfb-qetCpG07CAowbrpUyoPQYUvRog; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzdHVkZW50QG1pbmR0ZWsiLCJoZWFkZXIiOnsidHlwZSI6IlJlZnJlc2giLCJhbGciOiJIUzI1NiJ9LCJleHAiOjE3NTk0NDI4MjR9.2K4yVKQU9OYj9eSj7Pa57HEjangSLZNQQ9BDPNYGxyM")
                .and().body("{\n" +
                        "  \"full_name\": \""+full_name+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": "+is_staff+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-29\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-29\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");
        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),422);
        Assert.assertEquals(postResponse.body().jsonPath().getString("detail[0].msg"), "String should have at most 50 characters");
    }

}
