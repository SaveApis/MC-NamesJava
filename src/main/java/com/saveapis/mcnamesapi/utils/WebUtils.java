package com.saveapis.mcnamesapi.utils;

import com.saveapis.mcnamesapi.types.RestPaths;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
        String url = getBaseUrl() + "/" + type.getPath() + "/" + (path != null ? path + "/" : "");
        return get(url, clazz);
    }

    public static <T> @Nullable T get(@NotNull RestPaths type, @NotNull Class<T> clazz) {
        return get(type, null, clazz);
    }

    /*
    public static <T> @Nullable T post(@NotNull RestPaths type, @Nullable String path, @NotNull Class<T> clazz) {
        try {
            String url = getBaseUrl() + "/" + type.getPath() + "/" + (path != null ? path + "/" : "");
            ClientResource clientResource = createClient(url);
            String postResult = clientResource.post(null).getText();
            clientResource.release();
            return JsonUtils.toObject(postResult, clazz);
        } catch (IOException e) {
            return null;
        }
    }
    */

    public static String getBaseUrl() {
        return System.getProperty("MC-NamesBaseUrl", "https://api.saveapis.com/mc-namesapi");
    }

    public static void setBaseUrl(String baseUrl) {
        System.setProperty("MC-NamesBaseUrl", baseUrl);
    }
}
