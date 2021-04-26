package me.hammer86gn.djar.api.object;

import me.hammer86gn.djar.api.DJAR;

import java.net.URL;

public interface Guild {

    long getGuildID();

    String getGuildName();

    long getGuildOwnerID();

    String getGuildIcon();

    URL getGuildIconURL();

    DJAR getDJAR();

}
