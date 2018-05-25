package top.yannxia.java.demo.nashorn;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private Map<String, Object> queryBodyMap = new HashMap<>();

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, Object> getQueryBodyMap() {
        return queryBodyMap;
    }

    public void setQueryBodyMap(Map<String, Object> queryBodyMap) {
        this.queryBodyMap = queryBodyMap;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "headers=" + headers +
                ", queryParams=" + queryParams +
                ", queryBodyMap=" + queryBodyMap +
                '}';
    }
}
