package xyz.terrific.utils;


import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPUtils {

    public static String get(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> req = httpClient.send(
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                        .build()
                , HttpResponse.BodyHandlers.ofString()
        );
        // System.out.println(req);
        return StringEscapeUtils.unescapeHtml4(req.body());
    }

    public static String post(String url, String data) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        return httpClient.send(
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .POST(HttpRequest.BodyPublishers.ofString(data))
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                        .build()
                , HttpResponse.BodyHandlers.ofString()
        ).body();
    }



    public static String getXpath(String data, String tag, String xpath_class, String xpath_value) {
        Pattern pattern = Pattern.compile("(<.*" + tag + ".*" + xpath_class + ".*" + xpath_value + ".*>)(.*)(<.*/.*>)");
        Matcher matcher = pattern.matcher(data);

        boolean matchFound = matcher.find();
        if (matchFound) {
            return matcher.group(2);
        } else {
            return "Not found";
        }
    }

    public static String getXpathLike(String data, String xpath) {
        Pattern pattern = Pattern.compile(xpath);
        Matcher matcher = pattern.matcher(data);

        boolean matchFound = matcher.find();
        if (matchFound) {
            return matcher.group(2);
        } else {
            return "Not found";
        }
    }

}
