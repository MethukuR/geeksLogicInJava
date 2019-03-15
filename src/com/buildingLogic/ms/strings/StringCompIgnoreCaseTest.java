package com.buildingLogic.ms.strings;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StringCompIgnoreCaseTest {

  private StringCompIgnoreCase compIgnoreCase;
  
  @Before
  public void setUp() {
    compIgnoreCase = new StringCompIgnoreCase();
  }
  
  @Test
  public void test() {
    assertEquals(0, compIgnoreCase.icStrcmp("abcd", "abcD"));
    assertEquals(1, compIgnoreCase.icStrcmp("abcd", ""));
    assertEquals(-1, compIgnoreCase.icStrcmp("abcd", "cbcD"));
    assertEquals(-1, compIgnoreCase.icStrcmp("ABCD", "abcdEghe"));
    assertEquals(-1, compIgnoreCase.icStrcmp("", "abcDe"));
    assertEquals(0, compIgnoreCase.icStrcmp("GeeksForGeeks", "gEEksFORGeEKs"));
    assertEquals(0, compIgnoreCase.icStrcmp("GeeksForGeeks", "geeksForGeeks"));
  }

}
