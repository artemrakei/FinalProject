import cucumber.api.java.en.Given;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApiVkTest {
    private String postID;
    private ApiVK apiVK;
    public ApiVkTest() {
        apiVK = new ApiVK();
    }

    @Test
    public void postMessageTest() throws IOException, URISyntaxException {
        ApiVK apiVK = new ApiVK();
        URIBuilder builder = apiVK.createPost("message", "test");
        String execute = EntityUtils.toString(apiVK.execute(builder).getEntity());
        String expectedExecute = "\"post_id\":";
        postID =  execute.replaceAll("[^\\d]", "");
        Assert.assertEquals(execute.substring(13, 23), expectedExecute);
    }



    @Test
    public void editMessageTest() throws IOException, URISyntaxException {
        ApiVK apiVK = new ApiVK();
        URIBuilder builder = apiVK.editPost("message", "testtt",postID);
        String execute = EntityUtils.toString(apiVK.execute(builder).getEntity());
        String expectedExecute = "\"post_id\":";

    }
//
//    @Test()
//    public void deleteMessageTest() throws IOException, URISyntaxException, ParseException {
//        ApiVK.VkMetods vkMetods = new ApiVK.VkMetods();
//        int maxIdMessage = Integer.parseInt(vkMetods.getMaxIdInMessageList());
//        URIBuilder builder = vkMetods.createDeleteUrl(vkMetods.getMaxIdInMessageList());
//        String execute = EntityUtils.toString(vkMetods.execute(builder).getEntity());
//        System.out.println(execute);
//        String expectedExecute = "{\"response\":1}";
//        Assert.assertEquals(execute, expectedExecute);
//        Assert.assertFalse(vkMetods.checkIdInMessageList(maxIdMessage));
//    }

}

