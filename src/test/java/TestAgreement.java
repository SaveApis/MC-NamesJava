import com.saveapis.mcnamesapi.api.models.ReadonlyAgreement;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.services.AgreementService;
import com.saveapis.mcnamesapi.types.Languages;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TestAgreement {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");

        ApiResult<ReadonlyAgreement> readonlyAgreementApiResult =
                AgreementService.hasAgreement(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.DEUTSCH).get();

        System.out.println("================== PRE ==================");
        System.out.println(readonlyAgreementApiResult.error());
        System.out.println(readonlyAgreementApiResult.message());
        System.out.println(readonlyAgreementApiResult.result().uuid());
        System.out.println(readonlyAgreementApiResult.result().agreeValue());
        System.out.println();
        System.out.println();

        readonlyAgreementApiResult = AgreementService.toggleAgreement(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.DEUTSCH).get();

        System.out.println("================== POST ==================");
        System.out.println(readonlyAgreementApiResult.error());
        System.out.println(readonlyAgreementApiResult.message());
        System.out.println(readonlyAgreementApiResult.result().uuid());
        System.out.println(readonlyAgreementApiResult.result().agreeValue());
    }
}
