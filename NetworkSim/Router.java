package NetworkSim;

import NetworkSim.Route;

public class Router extends Host{
    private Route[] routing_table;

    public Router(String name, int ipv4_addr) {
        super(name, ipv4_addr);
    }

    public void route(Packet p) {
        for (Route route : routing_table) {
            ;
        }
    }

}
