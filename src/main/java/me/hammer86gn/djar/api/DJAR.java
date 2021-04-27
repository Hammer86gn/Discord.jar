package me.hammer86gn.djar.api;

import okhttp3.OkHttpClient;

public interface DJAR {

    void build(String token);

    String getToken();

    OkHttpClient getOkHTTP();

}
