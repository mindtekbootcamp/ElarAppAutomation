package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {

    // REUSABLE METHODS

        /**
         * Reads a CSV file and stores its content as a list of maps.
         * The first row is treated as the header, and each subsequent row is a map where
         * the keys are the header values.
         *
         * @param fileName The name of the CSV file to read (without the path).
         * @return A List of Maps, where each Map represents a row of data.
         */
        public static List<Map<String, String>> readCsvToListOfMaps(String fileName) {
            // Build the file path
            String filePath = "C:\\Users\\Jensen\\IdeaProjects\\ElarAppAutomation\\src\\test\\resources\\testdata\\" + fileName + ".csv";
            List<Map<String, String>> records = new ArrayList<>();
            String line;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                // Read the header line
                String headerLine = br.readLine();
                if (headerLine == null) {
                    return records; // Return an empty list if the file is empty
                }
                String[] headers = headerLine.split(",");

                // Read the rest of the lines
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Map<String, String> rowMap = new HashMap<>();

                    // Map each value to its corresponding header
                    for (int i = 0; i < headers.length; i++) {
                        // Handle potential index out of bounds for malformed CSVs
                        if (i < values.length) {
                            rowMap.put(headers[i], values[i]);
                        } else {
                            rowMap.put(headers[i], ""); // Assign an empty string for missing values
                        }
                    }
                    records.add(rowMap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return records;
        }

}
