import java.io.*;
import java.util.*;

public class LineParser {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("입력 파일을 읽는 중 오류 발생: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
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
            System.out.println("출력 파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
