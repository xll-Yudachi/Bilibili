package com.yudachi.util;

import java.util.UUID;

public class UUIDUtils {
        /**
         * 生成随机的32位uuid
         * @return
         */
        public final static String getId(){
            return UUID.randomUUID().toString().replaceAll("-", "");
        }
}
