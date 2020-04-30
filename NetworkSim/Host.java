package NetworkSim;

import NetworkSim.Packet;
import NetworkSim.Route;

import java.util.List;

class Host {

	private String name;
	private int ipv4_addr;
	private List<Route> routingTable;

	public Host(String name, int ipv4_addr) {
		this.name = name;
		this. ipv4_addr = ipv4_addr;
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

	public static void main(String args[]) {
		Host h1 = new Host("a", 1);
		System.out.println(h1.toString());
	}
}

