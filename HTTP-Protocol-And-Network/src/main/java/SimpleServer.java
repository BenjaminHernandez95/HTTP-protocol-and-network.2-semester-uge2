import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleServer {

    private String getFile(String ressource) {
        ressource = reformatRessource(ressource); // remove leading / and add .html if not present

        String response = "";
        Path path = Path.of(ressource);

        try {
            // Get the URI of the resource using getResource
            URI resourceUri = RequestFileServer.class.getClassLoader().getResource(ressource).toURI();
            // Use Paths.get with the URI to create a Path
            Path resourcePath = Paths.get(resourceUri);

            // Read the content of the resource using Files.readString
            response = Files.readString(resourcePath);

//            String content = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("File not found");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    private String reformatRessource(String ressource) {
        return;
    }
}

