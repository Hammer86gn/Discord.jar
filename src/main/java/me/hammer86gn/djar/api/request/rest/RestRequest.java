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

    public RestRequest(BuiltRestRoute route, DJAR djar) {
        this.route = route;
        this.djar = djar;
        this.client = djar.getOkHTTP();
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

    public void createRequest() {
        Builder request = new Request.Builder().url(route.getBuiltRoute()).addHeader("Authorization","Bot " + djar.getToken());
        this.request = request.build();
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
