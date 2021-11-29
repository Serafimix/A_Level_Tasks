package ua.rakhmail.hw34.servlet.utils;

import lombok.Getter;

import java.util.*;

@Getter
public class ListInfo {
    private final int MAX_SIZE = 5;

    private final Map<String, String> userInfo = new LinkedHashMap<>();

    public synchronized void addUsers(String s1, String s2) {
        userInfo.put(s1, s2);
        Set<String> list = userInfo.keySet();
        if (userInfo.size() > MAX_SIZE) {
            userInfo.remove(list.stream().findFirst().get());
        }
    }
}
