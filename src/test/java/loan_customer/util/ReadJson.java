package loan_customer.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {

    private static final String HOST = "src/test/resources/";

    public static String execute(final String path) throws IOException {

        return String.join(" ",
                Files.readAllLines(
                        Paths.get(HOST + path),
                        StandardCharsets.UTF_8));
    }
}
