import com.saveapis.mcnamesapi.types.RestPaths;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;

public class TestWebRequest {
    public static void main(String[] args) {
        // Method to change the BaseURL to access the REST-API
        // WebUtils.setBaseUrl("yourPathToTheBaseUrlOfTheRestApi");

        Object object = WebUtils.get(RestPaths.TRANSLATION, Object.class);
        System.out.println(JsonUtils.toJson(object));
    }
}
