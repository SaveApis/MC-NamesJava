import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.utils.AsyncUtils;

import java.util.concurrent.ExecutionException;

public class TestAsyncUtils {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListenableFuture<Integer> result = AsyncUtils.getAsync(param -> 2 * 2 /*, (Object)null*/);
        System.out.println("============== Pre ================");
        while (!result.isDone())
            System.out.println("Waiting.....");
        System.out.println("===================================");
        System.out.println("============ Result ============");
        System.out.println(result.get());
        System.out.println("================================");
    }
}
