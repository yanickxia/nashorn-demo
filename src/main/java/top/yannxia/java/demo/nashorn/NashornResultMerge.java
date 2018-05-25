package top.yannxia.java.demo.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class NashornResultMerge implements ResultMerge {

    private ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
    private String script;

    public NashornResultMerge(String script) {
        this.script = script;
    }

    @Override
    public Map merge(Map<String, Map> datas) {
        try {
            nashorn.eval(script);
            Invocable invocable = (Invocable) nashorn;
            return (Map) invocable.invokeFunction("merge", datas);
        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
