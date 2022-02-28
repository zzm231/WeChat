package com.swu.zzm.wechat.utils;

import android.webkit.MimeTypeMap;

/**
 * @Date: 13-7-26
 * @Time: 下午2:31
 * @author zzm
 */
public class MimeTypeUtils {

    private MimeTypeUtils() {
    }

    public static String getMimeType(final String fileName) {
        String result = "application/octet-stream";
        int extPos = fileName.lastIndexOf(".");
        if (extPos != -1) {
            String ext = fileName.substring(extPos + 1);
            result = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext);
        }
        return result;
    }
}
