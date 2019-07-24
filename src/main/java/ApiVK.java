
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApiVK {
    //https://oauth.vk.com/blank.html#access_token=a24bcbf15c78fd1961c6977e9e10aea40d172161c558b2f622923d3c8aa01cc31c8419f0d831eb83f2178&expires_in=86400&user_id=552470481&state=123456
    //https://api.vk.com/method/wall.post?owner_id=552470481&access_token=a24bcbf15c78fd1961c6977e9e10aea40d172161c558b2f622923d3c8aa01cc31c8419f0d831eb83f2178&v=5.92&message=test message111
    //{"response":{"post_id":55}}
    //https://api.vk.com/method/wall.delete?owner_id=552470481&access_token=a24bcbf15c78fd1961c6977e9e10aea40d172161c558b2f622923d3c8aa01cc31c8419f0d831eb83f2178&v=5.92&post_id=55

    private URIBuilder builder;

    public URIBuilder createBasicUrl(String methodName) throws IOException, URISyntaxException {
        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        builder = new URIBuilder(urlName);
        builder.setParameter("access_token", "a24bcbf15c78fd1961c6977e9e10aea40d172161c558b2f622923d3c8aa01cc31c8419f0d831eb83f2178")
                .setParameter("owner_id", "552470481")
                .setParameter("v", "5.92");
        return builder;
    }

    public URIBuilder createGetByIdUrl(String methodName, String postId) throws URISyntaxException {
        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        String posts = String.format("8045198_%s", postId);
        builder = new URIBuilder(urlName);
        builder.setParameter("access_token", "a24bcbf15c78fd1961c6977e9e10aea40d172161c558b2f622923d3c8aa01cc31c8419f0d831eb83f2178")
                .setParameter("posts", posts)
                .setParameter("v", "5.92");
        return builder;
    }

    public URIBuilder createPost(String parameter, String value) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl("post");
        builder.setParameter(parameter, value);
        return builder;
    }

    public URIBuilder editPost(String parameter, String value, String postId) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl("edit");
        builder.setParameter(parameter, value);
        builder.setParameter("post_id", postId);
        return builder;
    }

    public URIBuilder deletePost(String postId) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl("delete");
        builder.setParameter("post_id", postId);
        return builder;
    }
    public HttpResponse execute(URIBuilder builder) throws IOException, URISyntaxException {
        HttpGet request = new HttpGet( builder.build() );
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute( request );
    }

}
