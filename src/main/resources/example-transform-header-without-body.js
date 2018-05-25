function transform(httpRequest) {
    var newHttpRequestClazz = Java.type('top.yannxia.java.demo.nashorn.HttpRequest');
    var newHttpRequest = new newHttpRequestClazz();

    newHttpRequest.headers = httpRequest.headers;
    newHttpRequest.headers['1'] = 'this is not orgin';
    newHttpRequest.headers['2'] = newHttpRequest.headers['2'] + 1;

    return newHttpRequest
}