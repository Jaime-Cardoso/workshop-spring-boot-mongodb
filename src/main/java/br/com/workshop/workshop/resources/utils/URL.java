package br.com.workshop.workshop.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decoderParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
