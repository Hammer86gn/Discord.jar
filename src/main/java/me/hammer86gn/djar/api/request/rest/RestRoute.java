package me.hammer86gn.djar.api.request.rest;

import me.hammer86gn.djar.utils.Util;

public class RestRoute {

    private final RestType type;
    private final String route;
    private final int version = 8;
    private final String baseURL = "https://discord.com/api/v" + version + "/";
    private int paramCount;

    public RestRoute(RestType type, String route) {
        this.type = type;
        this.route = baseURL + route;
        this.paramCount = Util.countCharOccurrences('{',route);
        if (paramCount != Util.countCharOccurrences('}',route)) {
            throw new IllegalArgumentException("Route parameters must contain a \'{\' to start and a \'}\' to end. route: " + route);
        }
    }

    public String getRoute() {
        return route;
    }

    public RestType getType() {
        return type;
    }

    public int getParamCount() {
        return paramCount;
    }

    public BuiltRestRoute build(String... parameters) {
        if (parameters.length != this.paramCount) {
            throw new IllegalArgumentException("Must replace all parameters");
        } else {
            StringBuilder sb = new StringBuilder(route);
            for (int i = 0; i < paramCount; i++) {
                int start = sb.indexOf("{");
                int end = sb.indexOf("}");
                String name = sb.substring(start+1,end);

                sb.replace(start,end+1,parameters[i]);


            }
            return new BuiltRestRoute(this, sb.toString());
        }
    }

    public static class GUILD {

        /*
        All GET requests for the guilds/ ROUTE
         */

        public static final RestRoute GUILD_INFO = new RestRoute(RestType.GET, "guilds/{guild_id}");
        public static final RestRoute GUILD_CHANNELS = new RestRoute(RestType.GET,"guilds/{guild_id}/channels");
        public static final RestRoute GUILD_GET_MEMBER = new RestRoute(RestType.GET,"guilds/{guild_id}/members/{user_id}");
        public static final RestRoute GUILD_MEMBERS = new RestRoute(RestType.GET, "guilds/{guild_id}/members");
        public static final RestRoute GUILD_SEARCH_MEMBERS = new RestRoute(RestType.GET,"guilds/{guild_id}/members/search"); //NOTE: this requires a special parameter found here https://discord.com/developers/docs/resources/guild#search-guild-members
        public static final RestRoute GUILD_BANS = new RestRoute(RestType.GET,"guilds/{guild_id}/bans");
        public static final RestRoute GUILD_GET_BAN = new RestRoute(RestType.GET, "guilds/{guild_id}/bans/{user_id}");
        public static final RestRoute GUILD_ROLES = new RestRoute(RestType.GET,"guilds/{guild_id}/roles");
        public static final RestRoute GUILD_PRUNES = new RestRoute(RestType.GET,"guilds/{guild_id}/prune");
        public static final RestRoute GUILD_REGIONS = new RestRoute(RestType.GET, "guilds/{guild_id}/regions");
        public static final RestRoute GUILD_INVITES = new RestRoute(RestType.GET, "guilds/{guild_id}/invites");
        public static final RestRoute GUILD_INTEGRATIONS = new RestRoute(RestType.GET,"guilds/{guild_id}/integrations");
        public static final RestRoute GUILD_WIDGET = new RestRoute(RestType.GET,"guilds/{guild_id}/widget.json");
        public static final RestRoute GUILD_VANITY_URL = new RestRoute(RestType.GET,"guilds/{guild_id}/vanity-url");
        public static final RestRoute GUILD_WIDGET_IMG = new RestRoute(RestType.GET,"guilds/{guild_id}/widget.png");
        public static final RestRoute GUILD_WELCOME_SCREEN = new RestRoute(RestType.GET,"guilds/{guild_id}/welcome-screen");
    }

}
