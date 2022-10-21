import com.saveapis.mcnamesapi.api.models.ReadonlyAgreement;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.services.AgreementService;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TestAgreement {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");

         ApiResult<ReadonlyAgreement> readonlyAgreementApiResult =
                AgreementService.hasAgreement(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.GERMAN).get();

        System.out.println("================== PRE ==================");
        System.out.println("Error:\t\t\t\t" + readonlyAgreementApiResult.error());
        System.out.println("Message:\t\t\t" + readonlyAgreementApiResult.message());
        System.out.println("Result - UUID:\t\t" + readonlyAgreementApiResult.result().uuid());
        System.out.println("Result - Agreed:\t" + readonlyAgreementApiResult.result().agreeValue());
        System.out.println();
        System.out.println();

        readonlyAgreementApiResult = AgreementService.toggleAgreement(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.GERMAN).get();

        System.out.println("================== POST ==================");
        System.out.println("Error:\t\t\t\t" + readonlyAgreementApiResult.error());
        System.out.println("Message:\t\t\t" + readonlyAgreementApiResult.message());
        System.out.println("Result - UUID:\t\t" + readonlyAgreementApiResult.result().uuid());
        System.out.println("Result - Agreed:\t" + readonlyAgreementApiResult.result().agreeValue());
        System.exit(0);
    }
}
