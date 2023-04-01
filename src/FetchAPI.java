import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchAPI {
    public String fetch(String url) {
        try {
            URI uri = URI.create(url);

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            return body;

        } catch (IOException | InterruptedException ex) {

            throw new RuntimeException(ex);
        }
    }
}
