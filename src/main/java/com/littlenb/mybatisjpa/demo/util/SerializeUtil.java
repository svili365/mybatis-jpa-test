package com.littlenb.mybatisjpa.demo.util;

import com.google.gson.Gson;

/**
 * @author sway.li
 */
public class SerializeUtil {

    public static String toJSONString(Object obj){
        return new Gson().toJson(obj);
    }

}
