package NetworkSim;

import java.net.Inet4Address;

class Packet {

	public IPv4Address src_ip;
	public IPv4Address dest_ip;
	public int dest_port;
	public String payload;

	public Packet(IPv4Address src_ip, IPv4Address dest_ip, int dest_port, String payload) {
		this.src_ip = src_ip;
		this.dest_ip = dest_ip;
		this.dest_port = dest_port;
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Packet{" +
				"src_ip=" + src_ip +
				", dest_ip=" + dest_ip +
				", dest_port=" + dest_port +
				", payload='" + payload + '\'' +
				'}';
	}

	public static void main(String[] args) {
		Packet a = new Packet(new IPv4Address(1),new IPv4Address(2),80, "Hello world!");
		System.out.println(a.toString());
	}
}
