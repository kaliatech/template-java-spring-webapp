package com.mycompany.myproj.shared.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class MiscUtils {
  private static final String HTML_REGEXP = "</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/?>";

  static public String formatWithLeadingZeros(int val, int numDigits) {
    String valStr = new Integer(val).toString();
    int numChars = valStr.length();
    for (int i = 0; i < numDigits - numChars; i++)
      valStr = "0" + valStr;

    return valStr;
  }

  /**
   * Truncates a string and adds an ellipse string to the end. Note that if the string passed in is not longer the
   * [len(str) - len(ellipse)], then nothing happens and the string is simply returned as it was passed in.
   * 
   * @param str
   *          the string to be truncated.
   * @param maxNumChars
   *          maximum num of characters in the string, including additional characters of the ellipse string.
   * @returns the truncated string
   */
  public static String truncateStr(String str, int maxNumChars) {
    final String ellipse = "...";

    if (str == null)
      return "";

    if (str.length() >= maxNumChars) {
      StringBuffer newStr = new StringBuffer(maxNumChars);
      newStr.append(str.substring(0, maxNumChars - 1 - ellipse.length()));
      newStr.append(ellipse);
      return newStr.toString();
    } else {
      return str;
    }
  }

  public static String[] breakLongStringToMultiple(String str, int maxChars) {
    String[] strs = null;

    if (StringUtils.isEmpty(str) || str.length() <= maxChars || maxChars <= 0) {
      return new String[] { str };
    }

    int numLines = str.length() / maxChars;
    if (str.length() % maxChars > 0)
      numLines++;

    strs = new String[numLines];

    for (int i = 0; i < numLines; i++) {
      int start = i * maxChars;

      int end = (i * maxChars) + maxChars;
      end = end > str.length() ? str.length() : end;

      strs[i] = str.substring(start, end);
    }

    return strs;
  }

  public static String formatPhoneNum(String phoneNum) {
    if (StringUtils.isBlank(phoneNum)) {
      return "";
    } else if (phoneNum.length() == 7) {
      return phoneNum.substring(0, 3) + "-" + phoneNum.substring(3, phoneNum.length());
    } else if (phoneNum.length() == 10) {
      return "(" + phoneNum.substring(0, 3) + ") " + phoneNum.substring(3, 6) + "-"
          + phoneNum.substring(6, phoneNum.length());
    } else
      return phoneNum;

  }

  public static String stripHtml(String before) {
    if (StringUtils.isBlank(before)) {
      return before;
    }
    return before.replaceAll(HTML_REGEXP, "");
  }

  public static String getRandomStr() {
    return RandomStringUtils.randomAscii(5);
  }

  /**
   * Tries to idenfity links in the given text and wraps them with an a tag.
   * 
   * @param text
   *          the text to be analyzed
   * @return the same text, but with the links wrapped with a tags
   */
  public static String linkify(String text) {
    return text.replaceAll("(http(s)?://[a-zA-Z0-9\\.-/?=&\\;+]+)", "<a href=\"$1\">$1</a>");
  }

  public String formatDuration(Integer duration) {
    return DurationFormatUtils.formatDuration(duration * 1000, "mm:ss", true);
  }

}
