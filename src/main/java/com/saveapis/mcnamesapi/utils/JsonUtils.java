package com.saveapis.mcnamesapi.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setPrettyPrinting().create();

    public static <T> String toJson(T valueToJson) {
        return gson.toJson(valueToJson);
    }

    public static String format(String originJson) {
        Object object = gson.fromJson(originJson, Object.class);
        return gson.toJson(object);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
