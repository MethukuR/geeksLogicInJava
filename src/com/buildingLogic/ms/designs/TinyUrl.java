/**
 * https://gist.github.com/rakeshsingh/64918583972dd5a08012
 */
package com.buildingLogic.ms.designs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUrl {
  // storage for generated keys
  private Map<String, String> keyMap; // key-url map
  private Map<String, String> valueMap;// url-key map to quickly check

  // already entered in our system
  private String domain; // Use this attribute to generate urls for a custom
                         // domain name defaults to http://fkt.in
  private char myChars[]; // This array is used for character to number mapping
  private Random myRand; // Random object used to generate random integers
  private int keyLength; // the key length in URL defaults to 8

  public TinyUrl() {
    this.keyMap = new HashMap<String, String>();
    this.valueMap = new HashMap<String, String>();
    this.domain = "http://fkt.in";
    String b62String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    this.myChars = b62String.toCharArray();
    this.myRand = new Random();
    this.keyLength = 8;
  }

  public TinyUrl(int keyLength, String domain) {
    this();
    this.keyLength = keyLength;
    this.domain = sanitizeUrl(domain);
  }
  
  public String shortenUrl(String longUrl) {
    String shortUrl = "";
    longUrl = sanitizeUrl(longUrl);
    
    if(valueMap.containsKey(longUrl)) {
      shortUrl = domain + "/" + valueMap.get(longUrl);
    }else {
      shortUrl = domain + "/" + getKey(longUrl);
    }
    
    return shortUrl;
  }
  
  public String expandUrl(String shortUrl) {
    
    String key = shortUrl.substring(domain.length()+1);
    return keyMap.containsKey(key) ? keyMap.get(key) : null;
    
  }

  private String getKey(String longUrl) {
    String key = generateKey(longUrl);
    
    keyMap.put(key, longUrl);
    valueMap.put(longUrl, key);
    
    return key;
  }

  private String generateKey(String longUrl) {
    String key = "";
    boolean flag = true;
    
    while(flag) {
      for (int i = 0; i < keyLength; i++) {
        key += myChars[myRand.nextInt(62)];
      }
      
      if(!keyMap.containsKey(key)) {
        flag = false;
      }
    }
    
    return key;
  }

  // sanitizeURL
  // This method should take care various issues with a valid url
  // e.g. www.google.com,www.google.com/, http://www.google.com,
  // http://www.google.com/
  // all the above URL should point to same shortened URL
  // There could be several other cases like these.
  private String sanitizeUrl(String longUrl) {

    if (longUrl.substring(0, 7).equals("http://")) {
      longUrl = longUrl.substring(7);
    }

    if (longUrl.substring(0, 8).equals("https://")) {
      longUrl = longUrl.substring(8);
    }

    if (longUrl.charAt(longUrl.length() - 1) == '/') {
      longUrl = longUrl.substring(0, longUrl.length() - 1);
    }

    return longUrl;
  }


  public static void main(String[] args) {
    TinyUrl u = new TinyUrl(5, "www.tinyurl.com/");
    String urls[] = { "www.google.com/", "www.google.com",
            "http://www.yahoo.com", "www.yahoo.com/", "www.amazon.com",
            "www.amazon.com/page1.php", "www.amazon.com/page2.php",
            "www.flipkart.in", "www.rediff.com", "www.techmeme.com",
            "www.techcrunch.com", "www.lifehacker.com", "www.icicibank.com" };

    for (int i = 0; i < urls.length; i++) {
        System.out.println("URL:" + urls[i] + "\tTiny: "
                + u.shortenUrl(urls[i]) + "\tExpanded: "
                + u.expandUrl(u.shortenUrl(urls[i])));
    }

  }

}
