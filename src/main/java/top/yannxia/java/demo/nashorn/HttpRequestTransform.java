package top.yannxia.java.demo.nashorn;

@FunctionalInterface
public interface HttpRequestTransform {

    HttpRequest transform(HttpRequest httpRequest);
}
