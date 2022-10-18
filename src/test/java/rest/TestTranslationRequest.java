package rest;

import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.services.TranslationService;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.concurrent.ExecutionException;

public class TestTranslationRequest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");
        ReadonlyCollection<ReadonlyTranslationInfo> infos = TranslationService.All().get();
        for (ReadonlyTranslationInfo info : infos.toList()) {
            System.out.println(info.displayName());
        }
    }
}
