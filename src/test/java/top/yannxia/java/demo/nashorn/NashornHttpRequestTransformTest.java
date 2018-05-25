package top.yannxia.java.demo.nashorn;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class NashornHttpRequestTransformTest {

    private NashornHttpRequestTransform nashornHttpRequestTransform;

    @Test
    public void transform() {
        Map<String, String> headers = new HashMap<>();
        headers.put("1", "1");
        headers.put("2", "2");

        Map<String, String> queryParams = new HashMap<>();
        headers.put("1", "1");
        headers.put("2", "2");

        Map<String, Object> bodyParams = new HashMap<>();
        headers.put("1", "1");
        headers.put("2", "2");

        HttpRequest test = new HttpRequest();
        test.setHeaders(headers);
        test.setQueryBodyMap(bodyParams);
        test.setQueryParams(queryParams);

        try {
            nashornHttpRequestTransform = new NashornHttpRequestTransform(readFile("example-build-empty-httprequest.js", Charset.forName("UTF-8")));
            HttpRequest newHr = nashornHttpRequestTransform.transform(test);
            System.out.println("example-build-empty-httprequest.js ......................");
            System.out.println(newHr);
            System.out.println("\n\n\n");

            nashornHttpRequestTransform = new NashornHttpRequestTransform(readFile("example-transform-header-without-body.js", Charset.forName("UTF-8")));
            newHr = nashornHttpRequestTransform.transform(test);
            System.out.println("example-transform-header-without-body.js ......................");
            System.out.println(newHr);


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static String readFile(String file, Charset encoding)
            throws IOException, URISyntaxException {
        byte[] encoded = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(file).toURI()));
        return new String(encoded, encoding);
    }
}