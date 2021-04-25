package me.hammer86gn.djar.api.request.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;


public abstract class HammerHttpClient {
    private final URI uri;
    private final HttpClient client;

    private HttpUriRequest request;

    public HammerHttpClient(URI uri) {
        this.uri = uri;
        client = HttpClients.custom().build();
    }

    public void buildRequest(RequestHeader header) {
        request = RequestBuilder.get().setUri(uri).setHeader(header.toApacheHeader()).build();
    }

    @Deprecated
    public void connect() throws IOException {
        client.execute(request);
    }

    public String response() {
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
