package me.hammer86gn.djartest;

import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.api.request.http.HammerHttpClient;
import me.hammer86gn.djar.api.request.http.RequestHeader;
import me.hammer86gn.djar.api.request.http.discord.DiscordHttpClient;
import me.hammer86gn.djar.impl.DJARImpl;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Main {
    private static DJAR djar = new DJARImpl();

    public static void main(String[] args) {
        djar.build(Hidden.TOKEN);
    }
}
