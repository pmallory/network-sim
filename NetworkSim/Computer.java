package NetworkSim;

import java.util.ArrayList;
import java.util.List;

class Computer {
	public String name;
	public IPv4Address ipv4_addr;
	public List<Route> routingTable;
	public List<Computer> links;

	public Computer(String name, IPv4Address ipv4_addr) {
		routingTable = new ArrayList<Route>();
		links = new ArrayList<Computer>();

		this.name = name;
		this.ipv4_addr = ipv4_addr;
	}

	@Override
	public String toString() {
		return "Host{" +
				"name='" + name + '\'' +
				", ipv4_addr=" + ipv4_addr +
				'}';
	}

	public void addRoute(Route r) {
		routingTable.add(r);
	}

	public void addLink(Computer c) {
		this.links.add(c);
	}

	private void receive(Packet p) {
		System.out.println("Packet received by: " + this  + "\n\t" + p);
	}

	public void send(Packet p) {
		// If the packet's destination is this computer, receive it.
		if (p.dest_ip == this.ipv4_addr) {
			this.receive(p);
		}

		// Otherwise route it along
		for (Route r : routingTable) { // This could also be a hash table
			if ((p.dest_ip.and(r.netmask)).equals(r.destination)) {
				for (Computer neighbor : links) { //TODO links should be a hashtable
					if (neighbor.ipv4_addr == p.dest_ip) {
						neighbor.send(p);
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		Computer h1 = new Computer("a", new IPv4Address("10.0.0.1"));
		System.out.println(h1.toString());
	}
}

