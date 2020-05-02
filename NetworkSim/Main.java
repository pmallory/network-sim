package NetworkSim;

public class Main {

    public static final IPv4Address IP_A = new IPv4Address("10.0.0.1");
    public static final IPv4Address IP_B = new IPv4Address("10.0.0.2");

    public static void main(String[] args) {


        Computer a = new Computer("a", IP_A);
        Computer b = new Computer("b", IP_B);

        a.addRoute(new Route(IP_B, new IPv4Address("255.255.255.255"), IP_B));
        a.addLink(b); //TODO maybe links should be bidirectional

        b.addRoute(new Route(IP_A, new IPv4Address("255.255.255.255"), IP_A));
        b.addLink(a);

        Packet p = new Packet(IP_A, IP_B, 80, "Hello world!");

        a.send(p);
    }
}
