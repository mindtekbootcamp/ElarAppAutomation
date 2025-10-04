package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiTestBase;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class PostDriverApiPositiveTest extends ApiTestBase {

    @Test(groups = {"smoke","regression"})
    public void createDriverPositiveTest(){

        String full_Name = "Keanu Reeves";
        String is_staff = "false";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept", "application/json")
                .and().header("Content-type", "application/json")
                .and().header("Cookie", token)
                .and().body("{\n" +
                        "  \"full_name\": \""+full_Name+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": "+is_staff+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-11\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(), 200);
        Assert.assertEquals(postResponse.body().jsonPath().getString("full_name"), full_Name);
        Assert.assertEquals(postResponse.body().jsonPath().getString("is_staff"), is_staff);

    }

    @Test(groups = {"regression"})
    public void createDriverApiWithMoreThan50CharsNameTest(){

        String full_Name = "qhwejkflgjnfjodkpalsfkmgjeriofwkmldgjoerklmfdfdsaafafafdsfsdaafdsfadsfadsfadsfghfdghdfghdfghdgfhfhgfdghj";
        String is_staff = "false";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Accept", "application/json")
                .and().header("Content-type", "application/json")
                .and().header("Cookie",token)
                        .and().body("{\n" +
                        "  \"full_name\": \""+full_Name+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": "+is_staff+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-11\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(), 422);
        Assert.assertEquals(postResponse.body().jsonPath().getString("detail[0].msg"), "String should have at most 50 characters");

    }

    @Test(groups = {"regression"})
    public void validatePostApiCallWith1Character(){

        String fullName = "b";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Content-type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                        .and().body("{\n" +
                        "  \"full_name\": \"b\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": false,\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-04\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),200);
        Assert.assertEquals(postResponse.body().jsonPath().getString("full_name"), fullName);
    }

    @Test(groups = {"regression"})
    public void createDriverWithFullNameSpecialCharacters(){

        String specialCharactersName = "!@#$%^&*()_+";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Content-type","application/json")
                .and().header("Accept","application/json")
                .and().header("Cookie", token)
                .and().body("{\n" +
                        "  \"full_name\": \""+specialCharactersName+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": false,\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-04\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),422);
        Assert.assertEquals(postResponse.body().jsonPath().getString("detail[0].msg"), "Name cannot be created with special characters");


    }

    @Test(groups = {"smoke","regression"})
    public void validateIsStaffCheckBoxIsUnmarkedByDefault(){

        String isStaff = "false";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Content-type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                        .and().body("{\n" +
                        "  \"full_name\": \"Denzel Washington\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\":"+isStaff+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-04\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .and().log().all()
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(), 200);
        Assert.assertEquals(postResponse.body().jsonPath().getString("is_staff"), isStaff);
    }

    @Test(groups = {"smoke","regression"})
    public void validateIsStaffIsMarked(){

        String isStaffMarked = "true";

        Response postResponse = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api/v3")
                .and().header("Content-type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .and().body("{\n" +
                        "  \"full_name\": \"Denzel Washington\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": "+isStaffMarked+",\n" +
                        "  \"is_local\": false,\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \"2025-10-04\",\n" +
                        "  \"medical_certification_exp\": \"2025-10-04\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .when().post("/drivers");

        postResponse.then().log().all();
        Assert.assertEquals(postResponse.getStatusCode(),200);
        Assert.assertEquals(postResponse.body().jsonPath().getString("is_staff"), isStaffMarked);
    }

}
