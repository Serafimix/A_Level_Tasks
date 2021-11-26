package ua.rakhmail.hw21;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Class<?>> map = AutoCreateGetter.getMap();
        for (String str : map.keySet()) {
            System.out.println("   " + str + "       " + map.get(str));
        }
        AutoCreateGetter.getMethodWithInit(map);
    }
}
