package ua.rakhmail.hw15.Task03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapClass {
    public static Map<String, Integer> listToMap(List<String> list) {
        if (list == null){
            return null;
        }
        Map<String, Integer> map = new HashMap<>(list.size());
        for (var string : list) {
            if (string != null) {
                String liters = string.replaceAll("[^a-zA-Zа-яА-Я]+", "");
                map.put(string, liters.length());
            }
        }
        return map;
    }
}
