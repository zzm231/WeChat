package com.swu.zzm.wechat.nimsdk.audio;

/**
 * @author zzm
 */
public interface Playable {
    long getDuration();
    String getPath();
    boolean isAudioEqual(Playable audio);
}
