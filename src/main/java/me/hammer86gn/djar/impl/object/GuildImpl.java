package me.hammer86gn.djar.impl.object;

import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.api.object.Guild;
import me.hammer86gn.djar.impl.cache.GuildCache;

public class GuildImpl implements Guild {

    private final DJAR djar;
    private final long id;

    public GuildImpl(DJAR djar, long id) {
        this.djar = djar;
        this.id = id;
    }

    @Override
    public long getGuildID() {
        return id;
    }

    public static Guild getGuildByID(long id) {
        for (Guild guild : GuildCache.getInstance().getAll()) {
            if (guild.getGuildID() == id) {
                return guild;
            }
        }
        return null;
    }

    @Override
    public DJAR getDJAR() {
        return djar;
    }
}
