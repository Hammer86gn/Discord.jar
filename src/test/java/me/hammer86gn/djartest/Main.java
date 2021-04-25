package me.hammer86gn.djartest;

import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.impl.DJARImpl;

public class Main {

    private static DJAR djar = new DJARImpl();

    public static void main(String[] args) {
        djar.build(Hidden.TOKEN);
    }
}
