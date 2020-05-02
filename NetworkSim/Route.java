package NetworkSim;

public class Route {
    public IPv4Address destination;
    public IPv4Address netmask;
    public IPv4Address nexthop;

    public Route(IPv4Address destination, IPv4Address netmask, IPv4Address nexthop) {
        this.destination = destination;
        this.netmask = netmask;
        this.nexthop = nexthop;
    }
}
