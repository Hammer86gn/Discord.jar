package me.hammer86gn.djar.api.request.http.discord;

import me.hammer86gn.djar.api.request.http.HammerHttpClient;
import me.hammer86gn.djar.api.request.http.RequestHeader;

import java.net.URI;
import java.net.URISyntaxException;

public class DiscordHttpClient extends HammerHttpClient {
    public DiscordHttpClient(String request) throws URISyntaxException {
        super(new URI("https://discord.com/api/v8/" + request));
    }

    public void buildRequest(String token) {
        super.buildRequest(new RequestHeader("Authorization","Bot " + token));
    }
}
