import java.io.*;
import java.util.*;

public class LineParser {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        List<String> lines = new ArrayList<>();

        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
            return;
        }

        
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8"))) {
            for (int i = 0; i < lines.size(); i++) {
                String quoted = "\"" + lines.get(i) + "\"";
                if (i < lines.size() - 1) {
                    quoted += ",";
                }
                writer.write(quoted);
                writer.newLine();
            }
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
