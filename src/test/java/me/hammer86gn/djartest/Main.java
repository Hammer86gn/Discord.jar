package me.hammer86gn.djartest;

import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.impl.DJARImpl;
import me.hammer86gn.djar.utils.Util;


public class Main {
    private static DJAR djar = new DJARImpl();
    public  static int TEST_VALUE;

    public static void main(String[] args) {
        System.out.println(Util.createBotInvite("801283853200654406",8589934591L));
        TEST_VALUE = 0;

        djar.build(Hidden.TOKEN);
    }
}
