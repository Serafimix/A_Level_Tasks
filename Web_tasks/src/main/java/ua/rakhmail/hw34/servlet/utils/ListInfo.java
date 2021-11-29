package ua.rakhmail.hw34.servlet.utils;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class ListInfo {
    private final Map<String, String> userInfo = new LinkedHashMap<>(5);

}
