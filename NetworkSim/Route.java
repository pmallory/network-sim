package NetworkSim;

public class Route {
    private int destination;
    private int netmask;
    private int nexthop;

    public Route(int destination, int netmask, int nexthop) {
        this.destination = destination;
        this.netmask = netmask;
        this.nexthop = nexthop;
    }
}
