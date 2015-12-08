package com.gokhanabi.com.gokhanabi.util;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class CommonUtils {

    public static <E> boolean isEmpty(List<E> list){
        return list == null || list.size() == 0;
    }


    /** Returns an ImageIcon, or null if the path was invalid. */
    public static ImageIcon createImageIcon(String path, String description) {
        if (path != null) {
            java.net.URL imgURL = CommonUtils.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL, description);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }
        return null;
    }

    public static void centralizeJFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

}
