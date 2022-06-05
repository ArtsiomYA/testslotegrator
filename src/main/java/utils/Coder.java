package utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Coder {

    public static String encode(String text) {
        return Base64.getUrlEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String text) {
        return new String(Base64.getUrlDecoder().decode(text), StandardCharsets.UTF_8);
    }
}
