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
    static int height;//��̬�ĳ��Ϳ�
    static Image[] icons;
    static String folder = "icons";

    public static Image[] getIcons() {      //��ȡͼ��
        String path = System.getProperty("user.dir");  //����ϵͳ��user.dir���ԣ����صľ��ǵ�ǰ�û�����Ŀ¼
        File file = new File(path, folder);//����һ��Fileʵ��
        String[] filenames = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();//�Ӻ���ǰ��
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
        java.util.List<Picture> iconlist = new LinkedList<Picture>();//���ɵ�ͼ
        if (icons == null) {
            icons = getIcons();//���û��ͼ��ͻ�ȡͼ��
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
