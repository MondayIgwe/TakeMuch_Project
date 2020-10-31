package rest;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

public class RestFactory implements ResponseHandler {
    static CloseableHttpClient httpclient;
    static HttpResponse httpResponse;
    static ResponseHandler<String> responseHandler = new RestFactory();


    public void get(String uri) throws URISyntaxException, IOException {
        httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(new URI(uri));

        try {
            httpResponse = httpclient.execute(httpGet);
            Scanner scanner = new Scanner(httpResponse.getEntity().getContent());
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());

            }
        }finally {
            System.out.println("************========================************************");
            System.out.println("************========================************************");
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            System.out.println(statusCode);

            String res = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            JSONObject jsonObject = new JSONObject(res);
            System.out.println(jsonObject);

            Header[] header = closeableHttpResponse.getAllHeaders();
            HashMap<String,String> allHeaders = new HashMap<>();

            for (Header head:header){
                allHeaders.put(head.getName(),head.getValue());
            }
            System.out.println(allHeaders);
        }
    }

    public  void post() throws URISyntaxException, IOException {
        httpclient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(new URI("http://www.tutorialspoint.com/"));
            httpResponse = httpclient.execute(post);

            Scanner sc = new Scanner(httpResponse.getEntity().getContent());
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
            CloseableHttpResponse response = httpclient.execute(post);
            try{

            }finally {
                response.close();
            }
        }finally {
            httpclient.close();
        }
    }

    @Override
    public Object handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        return null;
    }
}
