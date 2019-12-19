package com.mutong.util;


import java.util.Random;

/**
 * 随机数工具类
 */

public class RandomUtil {

    /**
     * 生成邀请码
     *
     * @param length 长度
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if ("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }

    /**
     * 随机生成n位数字验证码
     *
     * @return
     */
    public static String getNumberRandom(int length) {
        Random random = new Random();
        int num = (int) Math.pow(10, length);//10^length
        String fourRandom = random.nextInt(num) + "";
        int randLength = fourRandom.length();
        if (randLength < length) {
            for (int i = 1; i <= length - randLength; i++) {
                fourRandom = "0" + fourRandom;
            }
        }
        return fourRandom;
    }


    /**
     * 生成一段字符串
     *
     * @param length 长度
     * @return
     */
    public static String getTextRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    public static void main(String[] args) {

        System.out.println(getCharAndNumr(6));

        System.out.println(getTextRandom(16));


    }

}


