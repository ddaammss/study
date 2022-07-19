package com.dams.java.etc;

import org.apache.commons.lang.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class StringUtil {
    public static final String Y = "Y";
    public static final String N = "N";
    public static final String EMPTY = "";

    public static boolean containsHangul(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(ch);
            if (Character.UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
                    || Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
                    || Character.UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock)) {
                return true;
            }
        }
        return false;
    }

    // 한글이 아닌 영문자나 한자, 특수캐릭이 포함되면 false, only 정상적인 한글
    public static boolean isAllHangul(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(ch);
            if (!Character.UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)) {
                return false;
            }
        }
        return true;
    }

    public static Charset detectCharset(byte[] buffer, String[] charsets) {
        Charset charset = null;
        for (String charsetName : charsets) {
            charset = detectCharset(buffer, Charset.forName(charsetName));
            if (charset != null) {
                break;
            }
        }
        return charset;
    }

    private static Charset detectCharset(byte[] buffer, Charset charset) {
        CharsetDecoder decoder = charset.newDecoder();
        decoder.reset();
        try {
            decoder.decode(ByteBuffer.wrap(buffer));
            return charset;
        } catch (CharacterCodingException e) {
            return null;
        }
    }

    public static boolean isYes(String yn) {
        if (yn == null) {
            return false;
        }
        return Y.equalsIgnoreCase(yn);
    }

    public static boolean isNo(String yn) {
        if (yn == null) {
            return false;
        }
        return N.equalsIgnoreCase(yn);
    }

    /**
     * 문자열 y 혹은 n을 y = true, 나머지는 false
     *
     * @param yn
     * @return
     */
    public static boolean ynToBoolean(String yn) {
        return StringUtil.isYes(yn);
    }

    /**
     * 문자열에서 제어 문자을 제거한다. 제어 문자에는 줄바꿈도 포함됨
     *
     * @param xml
     * @return
     */
    public static String removeCTLChar(String xml) {
        if (StringUtil.isEmpty(xml)) {
            return xml;
        }
        StringBuilder sb = new StringBuilder(xml.length());
        char c[] = xml.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.getType(c[i]) == Character.CONTROL) {
                continue;
            }
            sb.append(c[i]);
        }
        return sb.toString();
    }

    /**
     * 특정 문자(-) 공백 처리
     *
     * @param str
     * @return
     */
    public static String stringEmptyCheck(String str) {
        String result = null;
        if (str != null && str.equals("-")) {
            result = "";
        } else {
            result = str;
        }
        return result;
    }

    public static String defaultString(String str, String defaultStr) {

        return StringUtils.defaultString(str, defaultStr);
    }

    /**
     * <pre>
     * StringUtils.defaultIfBlank(null, "NULL")  = "NULL"
     * StringUtils.defaultIfBlank("", "NULL")    = "NULL"
     * StringUtils.defaultIfBlank(" ", "NULL")   = "NULL"
     * StringUtils.defaultIfBlank("bat", "NULL") = "bat"
     * StringUtils.defaultIfBlank("", null)      = null
     * </pre>
     *
     * @param str
     * @param defaultStr
     * @return
     */
    public static String defaultIfBlank(String str, String defaultStr) {
        return StringUtils.defaultIfBlank(str, defaultStr);
    }

    ////////////////////////////////////////////////////////////////////////
    public static String left(String str, int len) {
        return StringUtils.left(str, len);
    }

    /**
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !StringUtil.isEmpty(cs);
    }

    /**
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !StringUtil.isBlank(cs);
    }


    /**
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split("", *)           = []
     * StringUtils.split("a.b.c", '.')    = ["a", "b", "c"]
     * StringUtils.split("a..b.c", '.')   = ["a", "b", "c"]
     * StringUtils.split("a:b:c", '.')    = ["a:b:c"]
     * StringUtils.split("a b c", ' ')    = ["a", "b", "c"]
     * </pre>
     *
     * @param str
     * @param separatorChar
     * @return
     */
    public static String[] split(String str, char separatorChar) {
        return StringUtils.split(str, separatorChar);
    }

    public static String[] split(String str, String separatorChars) {
        return StringUtils.split(str, separatorChars);
    }

    public static String substring(String str, int start) {
        return StringUtils.substring(str, start);
    }

    public static String remove(String str, char remove) {
        return StringUtils.remove(str, remove);
    }

    public static String rightPad(String str, int size, char padChar) {
        return StringUtils.rightPad(str, size, padChar);
    }

    public static String leftPad(String str, int size, char padChar) {
        return StringUtils.leftPad(str, size, padChar);
    }

    public static boolean contains(String str, String searchStr) {
        return StringUtils.contains(str, searchStr);
    }

    public static boolean contains(String str, char searchChar) {
        return StringUtils.contains(str, searchChar);
    }

    /**
     * 문자열을 max치 만큼 적당히 줄인다.
     * <pre>
     * StringUtils.abbreviate(null, *) = null
     * StringUtils.abbreviate("", 4) = ""
     * StringUtils.abbreviate("abcdefg", 6) = "abc..."
     * StringUtils.abbreviate("abcdefg", 7) = "abcdefg"
     * StringUtils.abbreviate("abcdefg", 8) = "abcdefg"
     * StringUtils.abbreviate("abcdefg", 4) = "a..."
     * StringUtils.abbreviate("abcdefg", 3) = IllegalArgumentException
     * </pre>
     *
     * @param str      the String to check, may be null
     * @param maxWidth maximum length of result String, must be at least 4
     * @return
     */
    public static String abbreviate(String str, int maxWidth) {
        return StringUtils.abbreviate(str, maxWidth);
    }
}
