package com.leetcode.lc535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

  private final Map<String, String> mapLongUrlKey;
  private final Map<String, String> mapShortUrlKey;

  public Codec() {
    mapLongUrlKey = new HashMap<>();
    mapShortUrlKey = new HashMap<>();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if (longUrl == null || longUrl.isEmpty()) {
      throw new RuntimeException("longUrl is null or empty");
    }
    if (mapLongUrlKey.containsKey(longUrl)) {
      return mapLongUrlKey.get(longUrl);
    }
    String shortUrl;
    do {
      shortUrl = getShortUrl();
    } while (mapShortUrlKey.containsKey(shortUrl));
    mapLongUrlKey.put(longUrl, shortUrl);
    mapShortUrlKey.put(shortUrl, longUrl);
    return shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    if (shortUrl == null || shortUrl.isEmpty()) {
      throw new RuntimeException("shortUrl is null or empty");
    }
    if (mapShortUrlKey.containsKey(shortUrl)) {
      return mapShortUrlKey.get(shortUrl);
    } else {
      throw new RuntimeException("shortUrl does not exist");
    }
  }

  private String getShortUrl() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    String baseUrl = "http://tinyurl.com/";
    Random random = new Random();

    return baseUrl + random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));