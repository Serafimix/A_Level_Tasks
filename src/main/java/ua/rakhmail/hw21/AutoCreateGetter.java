package ua.rakhmail.hw21;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
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
                System.out.println(" methor " + clazz + method);
                Object sad = clazz.newInstance();
                if (sad instanceof Box) {
                    Box box = new Box();
                    box.printFields();
                }
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
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
                   changeFieldWithMultiplier(clas);
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
            Object box = clas.newInstance();
            if (box instanceof Box) {
                box = new Box();
                Field sizeField = clas.getDeclaredField("size");
                double doubleSize = sizeField.getDouble(box);
                System.out.println("Before change " + clas + " size = " + doubleSize);
                sizeField.setAccessible(true);
                sizeField.setDouble(box, doubleSize * 2);
                double newSize = sizeField.getDouble(box);
                System.out.println("After change " + clas + " size = " + newSize);
            }
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
