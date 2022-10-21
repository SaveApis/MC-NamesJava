import com.saveapis.mcnamesapi.api.models.ReadonlyName;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.services.NameService;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TestNames {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");
        ApiResult<ReadonlyName> result = NameService.byUuid(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.GERMAN).get();
        System.out.println("Error:\t\t\t" + result.error());
        System.out.println("Message:\t\t" + result.message());
        System.out.println("Result - Name:\t" + result.result().name());
        System.out.println("Result - UUID:\t" + result.result().uuid());
        System.out.println("Result - Since:\t" + result.result().since());
        System.exit(0);
    }
}
