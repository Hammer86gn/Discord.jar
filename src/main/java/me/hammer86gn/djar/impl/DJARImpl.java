package me.hammer86gn.djar.impl;

import me.hammer86gn.djar.api.request.websocket.DiscordSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

public class DJARImpl implements me.hammer86gn.djar.api.DJAR {
    private static DJARImpl instance;
    private DiscordSocketClient dsc;

    public DJARImpl() {
        instance = this;
    }

    @Override
    public void build(String token) {
        try {
           dsc = new DiscordSocketClient(new URI("wss://gateway.discord.gg/?v=8&encoding=json"),token);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        dsc.connect();
    }

    public static DJARImpl getInstance() {
        return instance;
    }
}
