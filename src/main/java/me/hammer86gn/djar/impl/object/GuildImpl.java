package me.hammer86gn.djar.impl.object;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.djar.api.DJAR;
import me.hammer86gn.djar.api.object.Guild;
import me.hammer86gn.djar.api.request.rest.RestRequest;
import me.hammer86gn.djar.api.request.rest.RestRoute;
import me.hammer86gn.djar.impl.cache.GuildCache;
import okhttp3.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URISyntaxException;

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

    @Override
    public String getGuildIDAsString() {
        return Long.toString(id);
    }

    @Override
    public String getGuildName() {
        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_INFO.build(Long.toString(id)),getDJAR());
        restRequest.createRequest();
        try {
            JsonObject returned = restRequest.responseToJson(restRequest.request());
            return returned.get("name").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getGuildOwnerID() {
        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_INFO.build(Long.toString(id)),getDJAR());
        restRequest.createRequest();
        try {
            JsonObject returned = restRequest.responseToJson(restRequest.request());
            return returned.get("owner_id").getAsLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getGuildIcon() {
        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_INFO.build(Long.toString(id)),getDJAR());
        restRequest.createRequest();
        try {
            JsonObject returned = restRequest.responseToJson(restRequest.request());
            return returned.get("icon").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getGuildIconURL() {
        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_INFO.build(Long.toString(id)),getDJAR());
        restRequest.createRequest();
        try {
            JsonObject returned = restRequest.responseToJson(restRequest.request());
            return new URL(returned.get("icon").getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getGuildRegion() {
        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_INFO.build(Long.toString(id)),getDJAR());
        restRequest.createRequest();
        try {
            JsonObject returned = restRequest.responseToJson(restRequest.request());
            return returned.get("region").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeGuildName(String name) {

        if (name.length() > 100 || name.length() < 2)
            throw new IllegalArgumentException("Guild Names must be between 2 and 100 characters");

        RestRequest restRequest = new RestRequest(RestRoute.GUILD.GUILD_MODIFY.build(Long.toString(id)),getDJAR());
        JsonObject requestJson = new JsonObject();
        requestJson.addProperty("name",name);
        restRequest.createRequestWithBody(requestJson.toString());
        try {
            Response res = restRequest.request();
            JsonObject responseObject = restRequest.responseToJson(res);
            System.out.println(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Gets a {@link Guild} from a given id
     *
     * @param id The id of the <b>Guild</b> you want to get <i>The guild must be cached</i>
     * @return {@link Guild}
     */
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
