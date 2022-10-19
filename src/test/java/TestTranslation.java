import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslation;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationContent;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.services.TranslationService;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestTranslation {
    private static List<ReadonlyTranslationInfo> infos = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");
        ApiResult<ReadonlyCollection<ReadonlyTranslationInfo>> infos = TranslationService.all().get();
        TestTranslation.infos = infos.result().toList();
        printTranslationInfos();
        printTranslations();
        printDefaultTranslation();
        System.exit(0);
    }

    public static void printTranslationInfos() {
        for (ReadonlyTranslationInfo info : infos) {
            System.out.println(info.identifier());
            System.out.println(info.displayName());
            System.out.println();
        }
    }

    public static void printTranslations() throws ExecutionException, InterruptedException {
        for (ReadonlyTranslationInfo info : infos)
            printSpecificTranslations(info.identifier());
    }

    public static void printSpecificTranslations(String identifier) throws ExecutionException, InterruptedException {
        ApiResult<ReadonlyTranslation> translation = TranslationService.byIdentifier(identifier).get();

        System.out.println("==================== Translation ====================");
        System.out.println("========== Info ==========");
        System.out.println(" - Name: " + translation.result().info().displayName());
        System.out.println(" - Identifier: " + translation.result().info().identifier());
        System.out.println("==========================");
        System.out.println("========== Content ==========");
        for (ReadonlyTranslationContent content : translation.result().content().toList()) {
            System.out.println("===== " + content.key() + " =====");
            System.out.println(" - Description: " + content.description());
            System.out.println(" - Translation: " + content.translation());
            System.out.println("======" + "=".repeat(content.key().length()) + "======");
        }
        System.out.println("=============================");
        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void printDefaultTranslation() {
    }
}
