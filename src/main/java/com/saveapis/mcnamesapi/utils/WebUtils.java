package com.saveapis.mcnamesapi.utils;

import com.saveapis.mcnamesapi.types.RestPaths;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.logging.Level;

public class WebUtils {
    public static <T> @Nullable T get(@NotNull String url, @NotNull Class<T> clazz) {
        try {
            ClientResource clientResource = createClient(url);
            String requestResult = clientResource.get(MediaType.APPLICATION_JSON).getText();
            clientResource.release();
            return JsonUtils.toObject(requestResult, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> @Nullable T get(@NotNull RestPaths type, @Nullable String path, @NotNull Class<T> clazz) {
        String url = getBaseUrl() + "/" + type.getPath() + "/" + (path != null ? path + "/" : "");
        return get(url, clazz);
    }

    public static <T> @Nullable T get(@NotNull RestPaths type, @NotNull Class<T> clazz) {
        return get(type, null, clazz);
    }

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


    public static String getBaseUrl() {
        return System.getProperty("MC-NamesBaseUrl", "https://api.saveapis.com/mc-namesapi");
    }

    public static void setBaseUrl(String baseUrl) {
        System.setProperty("MC-NamesBaseUrl", baseUrl);
    }

    private static @NotNull ClientResource createClient(@NotNull String url) {

        // Disable Logging Message
        Context context = new Context();
        context.getLogger().setLevel(Level.WARNING);
        return new ClientResource(context, url);
    }
}
