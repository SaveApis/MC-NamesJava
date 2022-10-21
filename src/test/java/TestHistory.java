import com.saveapis.mcnamesapi.api.models.ReadonlyHistory;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.services.HistoryService;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.utils.WebUtils;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TestHistory {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebUtils.setBaseUrl("http://localhost:5002");
        ApiResult<ReadonlyCollection<ReadonlyHistory>> historyList = HistoryService.byUuid(UUID.fromString("9f1666a3-8769-4641-a5e5-87d523fda9ab"), Languages.GERMAN).get();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (ReadonlyHistory history : historyList.result().toList()) {
            System.out.println("Name:\t" + history.name());
            System.out.println("From:\t" + dateFormat.format(history.from()));
            System.out.println("To:\t\t" + dateFormat.format(history.to()));
        }
        System.exit(0);
    }
}
