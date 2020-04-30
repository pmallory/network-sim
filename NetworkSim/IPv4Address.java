package NetworkSim;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IPv4Address {

    public int address;

    public IPv4Address(int address) throws IllegalArgumentException {
        this.address = address;
    }

    public IPv4Address(String dottedQuad) throws IllegalArgumentException {

        Scanner s = new Scanner(dottedQuad).useDelimiter("\\.");
        short byte0 = 0; // least significant byte, use a short b/c java bytes are signed (can't hold > 127)
        short byte1 = 0;
        short byte2 = 0;
        short byte3 = 0; // most significant

        try {
            byte3 = s.nextShort();
            byte2 = s.nextShort();
            byte1 = s.nextShort();
            byte0 = s.nextShort();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(String.format("Invalid IP address: %s", dottedQuad));
        }

        if (!(fitsInByte(byte0) && fitsInByte(byte1) && fitsInByte(byte2) && fitsInByte(byte3)) ) {
            throw new IllegalArgumentException(String.format("Invalid IP address: %s", dottedQuad));
        }

        if (s.hasNext()) {
            throw new IllegalArgumentException(String.format("Invalid IP address: %s", dottedQuad));
        }

        this.address = ((byte3 << 24) | (byte2 << 16) | (byte1 << 8) | (byte0));
    }

    @Override
    public String toString() {
        byte byte0 = (byte) (address & 0x000000FF);
        byte byte1 = (byte) ((address & 0x0000FF00 >>> 8));
        byte byte2 = (byte) ((address & 0x00FF0000) >>> 16);
        byte byte3 = (byte) ((address & 0xFF000000) >>> 24);

        return String.format("%d.%d.%d.%d", byte3 & 0xFF, byte2 & 0xFF, byte1 & 0xFF, byte0 & 0xFF); // The &0xFF is a hack to get Java to print an unsigned value
    }

    private boolean fitsInByte(short s) {
        return (0 <= s && s <= 255);
    }

    public static void main(String[] args) {
        IPv4Address test = new IPv4Address(0xffffffff);
        System.out.println(test.toString());

        IPv4Address test1 = new IPv4Address("255.55.25.25");
        System.out.println(test1.toString());

        IPv4Address test2 = new IPv4Address("255.5.5.5.5");
    }
}
