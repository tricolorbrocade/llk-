package net.walsece.game;

import net.walsece.model.Picture;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.awt.*;
import java.awt.List;
import java.util.*;


public class IconsManage {
    static int width;
    static int height;//静态的长和宽
    static Image[] icons;
    static String folder = "icons";

    public static Image[] getIcons() {      //获取图标
        String path = System.getProperty("user.dir");  //调用系统的user.dir属性，返回的就是当前用户工作目录
        File file = new File(path, folder);//生成一个File实例
        String[] filenames = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();//从后往前查
                return isAllowed(ext, new String[]{"jpg", "jpeg", "png", "gif"});
            }

            private boolean isAllowed(String ext, String[] types) {
                for (String t : types) {
                    if (ext.equals(t)) {
                        return true;
                    }
                }
                return false;
            }
        });

        Image[] icons = new Image[filenames.length];
        for (int i = 0; i < filenames.length; i++) {
            icons[i] = new ImageIcon(path + "/" + folder + "/" + filenames[i]).getImage();

        }

        return icons;
    }


    public static java.util.List<Picture> getRandomIcons(int numbers, Map<String, java.util.List<Picture>> maps) {
        java.util.List<Picture> iconlist = new LinkedList<Picture>();//生成地图
        if (icons == null) {
            icons = getIcons();//如果没有图标就获取图标
        }
        int size = icons.length;
        int number = 0;
        maps.clear();
        for (int i = 0; i < numbers / 2; i++) {
            Image icon = icons[(int) (Math.random() * size)];
            Picture p1 = new Picture(icon, number++ + "");
            Picture p2 = new Picture(icon, number++ + "");
            java.util.List<Picture> lists = maps.get(icon.toString());
            if (lists == null) {
                lists = new ArrayList<Picture>();
                maps.put(icon.toString(), lists);
            }
            lists.add(p1);
            lists.add(p2);
            iconlist.add(p1);
            iconlist.add(p2);
        }

        return iconlist;
    }
}
