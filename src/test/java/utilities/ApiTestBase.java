package utilities;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class ApiTestBase {
    protected String token = ConfigReader.getProperty("ElarAPIToken");
    protected Response postResponse;

    @BeforeClass
    public void createDriver(){
        String full_name="Patel Harsh";
        String is_staff="false";

        String body="{\n" +
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
                "}";
        postResponse = APIUtils.postAPICall(token,body);
    }
}
