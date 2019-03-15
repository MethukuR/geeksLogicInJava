package com.buildingLogic.ms.numbers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidIPAddressTest {

  private ValidIPAddress validIPAddress;
  
  @BeforeEach
  void setUp() throws Exception {
    validIPAddress = new ValidIPAddress();
  }

  @Test
  void testInvalidInputs() {
    String[] ipAddressesInvalid = {"1.1.1", "1.1.1.", "1.1..1", ".1.1.1", "172.8.9.256", 
        "172.8.-9.255", "172.8.9.266"};
    
    for (String ipAddress : ipAddressesInvalid) {
      assertFalse(validIPAddress.isValidAddress(ipAddress));
    }
    
    String[] ipAddressesInvalid2  = { "1.1.1.x", "172.a.1.2"};
    for (String ipAddress : ipAddressesInvalid2) {
      assertThrows(NumberFormatException.class, () -> {
        validIPAddress.isValidAddress(ipAddress);
      });
    }
    
  }
  
  @Test
  void testValidInputs() {
    String[] validIPAddresses = {"1.1.1.1", "127.0.0.1", "255.255.255.255",
        "172.68.8.63"};
    
    for (String ipAddress : validIPAddresses) {
      assertTrue(validIPAddress.isValidAddress(ipAddress));
    }
  }

}
