package com.gokhanabi.com.gokhanabi.util;

import java.util.List;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class CommonUtils {

    public static <E> boolean isEmpty(List<E> list){
        return list == null || list.size() == 0;
    }
}
