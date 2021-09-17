package ua.rakhmail.hw15.Task03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapClass {
    public static Map<String, Integer> listToMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (var string : list) {
            map.put(string, string.length());
        }
        return map;
    }
}
