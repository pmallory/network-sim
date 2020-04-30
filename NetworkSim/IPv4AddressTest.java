package NetworkSim;

import static org.junit.jupiter.api.Assertions.*;
import NetworkSim.IPv4Address;

class IPv4AddressTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        int a = 0xffffffff;
        IPv4Address test = new IPv4Address(a);
        assertEquals("255.255.255.255", test.toString());
    }

    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor1(){
        int a = 0xffffffff;
        IPv4Address test = new IPv4Address(a);
        assertEquals(a, test.address);
    }
    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor2(){
        int a = 0xdeadbeef;
        IPv4Address test = new IPv4Address(a);
        assertEquals(a, test.address);
    }
    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor3(){
        IPv4Address test = new IPv4Address("255.255.255.255");
        assertEquals(test.address, 0xffffffff);
    }
    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor4() {
        IPv4Address test = new IPv4Address("1.2.254.255");
        assertEquals(test.address, 0x0102feff);
    }

    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor5() {
        assertThrows(IllegalArgumentException.class, () -> {new IPv4Address("420.1.2.3");});
    }

    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor6() {
        assertThrows(IllegalArgumentException.class, () -> {new IPv4Address("1.2.3.4.5");});
    }

    @org.junit.jupiter.api.Test
    void testIPv4AddressConstructor7() {
        assertThrows(IllegalArgumentException.class, () -> {new IPv4Address("1.2");});
    }
}