package test.floor.plan.flooplan.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileReaderConsole {

    public List<String> getStringFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new IOException("No such File", e);
        }
    }
}
