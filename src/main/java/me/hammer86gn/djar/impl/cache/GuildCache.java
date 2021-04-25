package me.hammer86gn.djar.impl.cache;

import me.hammer86gn.djar.api.object.Guild;

import java.util.ArrayList;
import java.util.List;

public class GuildCache {
    private static GuildCache instance;
    private List<Guild> cachedGuilds = new ArrayList<>();

    public GuildCache() {
        instance = this;
    }

    public void cacheGuild(Guild guild) {
        cachedGuilds.add(guild);
    }

    public void removeCache(Guild guild) {
        cachedGuilds.remove(guild);
    }

    public List<Guild> getAll() {
        return cachedGuilds;
    }

    public int getCaches() {
        return cachedGuilds.size();
    }

    public static GuildCache getInstance() {
        return instance == null ? new GuildCache() : instance;
    }
}
