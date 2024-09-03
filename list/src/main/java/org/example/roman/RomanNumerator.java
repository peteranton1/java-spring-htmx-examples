package org.example.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerator {

  private static final Map<String, Integer> NUMERALS = getNumeralsMap();

  private static Map<String, Integer> getNumeralsMap() {
    Map<String, Integer> map = new LinkedHashMap<>();

    map.put("M", 1000);
    map.put("CM", 900);
    map.put("D", 500);
    map.put("CD", 400);
    map.put("C", 100);
    map.put("XC", 90);
    map.put("L", 50);
    map.put("XL", 40);
    map.put("X", 10);
    map.put("IX", 9);
    map.put("V", 5);
    map.put("IV", 4);
    map.put("I", 1);

    return map;
  }

  public String getNumerals(long value) {
    StringBuilder buf = new StringBuilder();
    if (value <= 0) {
      return "Error input: " + value;
    }
    long runningTotal = value;
    for (var entry : NUMERALS.entrySet()) {
      String key = entry.getKey();
      long amount = (long) entry.getValue();
      while (runningTotal >= amount) {
        runningTotal -= amount;
        buf.append(key);
      }
    }
    return buf.toString();
  }

  public long getLongValue(String romanStr) {
    if (romanStr == null || !isRoman(romanStr)) {
      throw new RuntimeException("Error input: " + romanStr);
    }
    long runningTotal = 0L;
    String leftOver = romanStr;
    for (var entry : NUMERALS.entrySet()) {
      String key = entry.getKey();
      long amount = (long) entry.getValue();
      while (leftOver.startsWith(key)) {
        runningTotal += amount;
        leftOver = leftOver.substring(key.length());
      }
    }
    return runningTotal;
  }

  public boolean isRoman(String romanStr) {
    final String romanChars = "MDCLXVI";
    if (romanStr.trim().isEmpty()) {
      return false;
    }
    for (int i = 0; i < romanStr.length(); i++) {
      char c = romanStr.charAt(i);
      if (!romanChars.contains(String.valueOf(c))) {
        return false;
      }
    }
    return true;
  }
}
