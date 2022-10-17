import com.saveapis.mcnamesapi.utils.JsonUtils;
import models.TestModel;

public class TestJsonUtils {
    public static void main(String[] args) {
        TestModel model = new TestModel();
        String result = JsonUtils.toJson(model);
        System.out.println(result);
        System.out.println();
        TestModel genModel = JsonUtils.toObject(result, TestModel.class);
        System.exit(0);
    }
}
