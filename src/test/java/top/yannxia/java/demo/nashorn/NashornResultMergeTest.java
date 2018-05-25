package top.yannxia.java.demo.nashorn;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NashornResultMergeTest {

    private NashornResultMerge nashornResultMerge;

    @Test
    public void merge() {

        Map<String, String> a = new HashMap<>();
        a.put("1", "this is a 1");
        a.put("2", "this is a 2");

        Map<String, String> b = new HashMap<>();
        b.put("1", "this is b 1");
        b.put("2", "this is b 2");

        Map<String, Map> datas = new HashMap<>();
        datas.put("a", a);
        datas.put("b", b);


        try {
            nashornResultMerge = new NashornResultMerge(NashornHttpRequestTransformTest.readFile("example-merge-data.js", Charset.forName("UTF-8")));
            Map newHr = nashornResultMerge.merge(datas);
            System.out.println("example-merge-data.js ......................");
            System.out.println("from_a_1 is " + newHr.get("from_a_1"));
            System.out.println("from_b_2 is " + newHr.get("from_b_2"));
            System.out.println("\n\n\n");


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}