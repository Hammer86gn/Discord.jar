package me.hammer86gn.djar.api.request.rest;

public class BuiltRestRoute {

    private final RestRoute route;
    private final String builtRoute;

    public BuiltRestRoute(RestRoute route, String builtRoute) {
        this.route = route;
        this.builtRoute = builtRoute;
    }

    public RestRoute getRoute() {
        return route;
    }

    public String getBuiltRoute() {
        return builtRoute;
    }

    @Override
    public int hashCode() {
        return (builtRoute + route.getType()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BuiltRestRoute) {
            return false;
        }
        BuiltRestRoute builtRestRoute = (BuiltRestRoute) obj;
        return route.equals(builtRestRoute.getRoute()) && builtRoute.equals(builtRestRoute.getBuiltRoute());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new BuiltRestRoute(this.getRoute(),this.builtRoute);
    }

    @Override
    public String toString() {
        return "BuiltRestRoute{" +
                "route=" + route +
                ", builtRoute='" + builtRoute + '\'' +
                '}';
    }
}
