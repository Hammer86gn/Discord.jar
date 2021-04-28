package me.hammer86gn.djar.api;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public interface DJAR {

    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    void build(String token);

    String getToken();

    OkHttpClient getOkHTTP();

}
