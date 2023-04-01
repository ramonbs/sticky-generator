import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        var generator = new ImageGenerator();
        var body = new FetchAPI();
        String fetch = body.fetch("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");

        var jsonParser = new JsonParser();

        List<Map<String, String>> listOfContent = jsonParser.parse(fetch);

        // System.out.println(listMovies.size());
        // System.out.println(listMovies.get(0));

        for (Map<String, String> content : listOfContent) {
            String urlImage = content.get("image");

            InputStream inputStream = new URL(urlImage)
                    .openStream();

            String filmName = content.get("title");
            String nameArchive = filmName + ".png";

            generator.creator(inputStream, nameArchive);

            System.out.println(content.get("title"));
            System.out.println(content.get("image"));
            System.out.println(content.get("imDbRating"));
            System.out.println();
        }
    }
}