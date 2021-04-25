package me.hammer86gn.djartest;

import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.api.object.Guild;
import me.hammer86gn.djar.impl.DJARImpl;
import me.hammer86gn.djar.impl.object.GuildImpl;

public class Main {

    private static DJAR djar = new DJARImpl();

    public static void main(String[] args) {
        djar.build(Hidden.TOKEN);
    }
}
