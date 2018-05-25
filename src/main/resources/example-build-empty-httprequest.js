function transform(httpRequest) {
    var newHttpRequestClazz = Java.type('top.yannxia.java.demo.nashorn.HttpRequest');
    return new newHttpRequestClazz();
}