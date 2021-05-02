package me.hammer86gn.djar.api.request.rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.utils.IDJAR;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class RestRequest implements IDJAR {

    private final BuiltRestRoute route;
    private final DJAR djar;
    private OkHttpClient client;
    private Request request;
    private RequestBody body;

    public RestRequest(BuiltRestRoute route, DJAR djar) {
        this.route = route;
        this.djar = djar;
        this.client = new OkHttpClient();
    }

    public void createRequest(@Nullable String[] keys, @Nullable String[] values) {
        Builder request = new Request.Builder().url(route.getBuiltRoute()).addHeader("Authorization","Bot " + djar.getToken());
        if (keys.length != values.length) {
            throw new IllegalArgumentException("All Keys must have a value");
        }
        for (String key : keys) {
            for (String value : values) {
                request.addHeader(key,value);
            }
        }
        this.request = request.build();
    }

    public void createRequest(String keys,String values) {
        Builder request = new Request.Builder().url(route.getBuiltRoute()).addHeader("Authorization","Bot " + djar.getToken());
        request.addHeader(keys, values);
        this.request = request.build();
    }

    public void createRequest() {
        Builder request = new Request.Builder().url(route.getBuiltRoute()).addHeader("Authorization","Bot " + djar.getToken());
        this.request = request.build();
    }

    public void createRequestWithBody(String json) {
        RequestBody body = RequestBody.create(json,DJAR.JSON);
        Builder request = new Request.Builder().url(route.getBuiltRoute()).addHeader("Authorization","Bot " + djar.getToken());
        switch (route.getRoute().getType()) {
            case POST:
                request.post(body);
                break;
            case PATCH:
                request.patch(body);
                System.out.println("Hi");
                break;
            case PUT:
                request.put(body);
                break;
            case DELETE:
                request.delete(body);
                break;
        }


        this.body = body;
        this.request = request.build();
        System.out.println(json);
    }

    public Response request() {
        Call call = client.newCall(this.request);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JsonObject responseToJson(Response response) throws IOException {
        return JsonParser.parseString(response.body().string()).getAsJsonObject();
    }

    @Override
    public DJAR getDJAR() {
        return djar;
    }
}
