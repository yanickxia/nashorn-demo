package top.yannxia.java.demo.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornHttpRequestTransform implements HttpRequestTransform {

    private ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
    private String script;

    public NashornHttpRequestTransform(String script) {
        this.script = script;
    }

    @Override
    public HttpRequest transform(HttpRequest httpRequest) {
        try {
            nashorn.eval(script);
            Invocable invocable = (Invocable) nashorn;
            return (HttpRequest) invocable.invokeFunction("transform", httpRequest);
        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
