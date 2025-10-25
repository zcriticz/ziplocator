package io.github.zcriticz.ziplocator.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

}