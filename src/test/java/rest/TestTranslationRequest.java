package rest;

import com.saveapis.mcnamesapi.api.services.TranslationService;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class TestTranslationRequest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");
        System.out.println(Objects.requireNonNull(TranslationService.All().get().get(0)).displayName());
    }
}
