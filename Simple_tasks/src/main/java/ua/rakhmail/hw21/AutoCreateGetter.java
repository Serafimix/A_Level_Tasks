package ua.rakhmail.hw21;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class AutoCreateGetter {
    public static void getMethodWithInit(Map<String, Class<?>> map) {
        for (String str : map.keySet()) {
            Class<?> clazz = map.get(str);
            try {
                Method method = clazz.getMethod("printFields");
                if (method.isAnnotationPresent(Init.class))
                    System.out.println(" method " + clazz + method);
                Object sad = new Object();
                method.invoke(sad);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, Class<?>> getMap() {
        Map<String, Class<?>> classMap = new HashMap<>();
        String packageName = Main.class.getPackage().getName();
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert resources != null;
        Iterable<URL> urls = resources::asIterator;
        List<File> dirs = new ArrayList<>();

        for (URL url : urls) {
            try {
                dirs.add(new File(url.toURI().getPath()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        List<Class<?>> classes = dirs.stream()
                .flatMap((File d) -> findClasses(d, packageName).stream())
                .collect(Collectors.toList());

        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(AutoCreate.class)) {
//                changeFieldWithMultiplier(cls);
                classMap.put(cls.getSimpleName(), cls);
            }
        }
        return classMap;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) {
        if (!directory.exists()) {
            return Collections.emptyList();
        }
        List<Class<?>> classes = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files == null) {
            return Collections.emptyList();
        }
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    Class<?> clas = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                    classes.add(clas);
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return classes;
    }

    private static void changeFieldWithMultiplier(Class<?> clas) {
        try {
            Object box = new Object();
            Field[] fields = clas.getDeclaredFields();
            for (var sizeField : fields) {
                if (sizeField.isAnnotationPresent(Multiplier.class) && (sizeField.get(box) instanceof Number)) {
                    System.out.println("Before change " + clas + " size = " + sizeField.get(box));
                    sizeField.setAccessible(true);
                    sizeField.set(box, (((Number) sizeField.get(box)).doubleValue()) * 2);
                    System.out.println("After change " + clas + " size = " + sizeField.get(box));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
