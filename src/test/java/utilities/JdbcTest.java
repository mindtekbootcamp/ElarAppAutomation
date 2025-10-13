package utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        JdbcUtils.connectToDB(ConfigReader.getProperty("HRDBURL"),
                ConfigReader.getProperty("HRDBUsername"),
                ConfigReader.getProperty("HRDBPassword"));

        List<Map<String, Object>> data=JdbcUtils.executeQuery("select * from employees where employee_id=89");

        System.out.println(data);

    }

}
