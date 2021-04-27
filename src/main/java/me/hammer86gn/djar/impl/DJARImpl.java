package me.hammer86gn.djar.impl;

import me.hammer86gn.djar.api.request.websocket.DiscordSocketClient;
import me.hammer86gn.djar.impl.cache.GuildCache;
import okhttp3.OkHttpClient;

import java.net.URI;
import java.net.URISyntaxException;

public class DJARImpl implements me.hammer86gn.djar.api.DJAR {
    private static DJARImpl instance;
    private DiscordSocketClient dsc;
    private static String token;
    private OkHttpClient client = new OkHttpClient();

    public DJARImpl() {
        instance = this;
        new GuildCache();
    }

    @Override
    public void build(String token) {
        DJARImpl.token = token;
        try {
           dsc = new DiscordSocketClient(new URI("wss://gateway.discord.gg/?v=8&encoding=json"),token,instance);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        dsc.connect();
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public OkHttpClient getOkHTTP() {
        return client;
    }

    public static DJARImpl getInstance() {
        return instance;
    }
}
