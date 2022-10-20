package com.saveapis.mcnamesapi.utils;

import com.saveapis.mcnamesapi.api.types.RestPaths;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WebUtils {

    private static final RestTemplate client = new RestTemplate();

    public static <T> @Nullable T get(@NotNull String url, @NotNull Class<T> clazz) {
        ResponseEntity<T> response = client.getForEntity(url, clazz);
        if (response.getStatusCode() != HttpStatus.OK)
            return null;

        return response.getBody();
    }

    public static <T> @Nullable T get(@NotNull RestPaths type, @Nullable String path, @NotNull Class<T> clazz) {
        String url = getBaseUrl() + "/" + type.getPath() + (path != null ? "/" + path : "");
        return get(url, clazz);
    }

    public static <T> @Nullable T get(@NotNull RestPaths type, @NotNull Class<T> clazz) {
        return get(type, null, clazz);
    }

    public static <T> @Nullable T post(@NotNull String url, @NotNull Class<T> clazz) {
        HttpEntity<String> entity = new HttpEntity<>("");
        ResponseEntity<T> response = client.postForEntity(url, entity, clazz);
        if (response.getStatusCode() != HttpStatus.OK)
            return null;
        return response.getBody();
    }

    public static <T> @Nullable T post(@NotNull RestPaths type, @Nullable String path, @NotNull Class<T> clazz) {
        String url = getBaseUrl() + "/" + type.getPath() + (path != null ? "/" + path : "");
        return post(url, clazz);
    }

    public static <T> @Nullable T post(@NotNull RestPaths type, @NotNull Class<T> clazz) {
        return post(type, null, clazz);
    }

    public static String getBaseUrl() {
        return System.getProperty("MC-NamesBaseUrl", "https://api.saveapis.com/mc-namesapi");
    }

    public static void setBaseUrl(String baseUrl) {
        System.setProperty("MC-NamesBaseUrl", baseUrl);
    }
}
