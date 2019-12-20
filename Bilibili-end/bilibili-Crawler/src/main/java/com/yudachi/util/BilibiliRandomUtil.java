package com.yudachi.util;

import java.util.Random;

public class BilibiliRandomUtil {
    public static String getRandom(int min, int max)
    {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return String.valueOf(s);

    }
}
