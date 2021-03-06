package com.library.live.stream;

import com.library.common.UdpControlInterface;
import com.library.common.VoiceCallback;
import com.library.live.vd.VideoInformationInterface;

/**
 * Created by android1 on 2017/9/27.
 */

public abstract class BaseRecive {
    public static final int RECIVE_STATUS_START = 0;
    public static final int RECIVE_STATUS_STOP = 1;
    protected int RECIVE_STATUS = RECIVE_STATUS_STOP;

    protected VideoInformationInterface informaitonInterface;
    protected UdpControlInterface udpControl = null;
    protected VoiceCallback voiceCallback = null;
    protected VideoCallback videoCallback = null;
    protected WeightCallback weightCallback;

    /**
     * 手动送入数据的方法
     */
    public abstract void write(byte[] bytes);

    public abstract void startRevice();

    public abstract void stopRevice();

    public abstract void destroy();

    public void setInformaitonInterface(VideoInformationInterface informaitonInterface) {
        this.informaitonInterface = informaitonInterface;
    }

    public void setUdpControl(UdpControlInterface udpControl) {
        this.udpControl = udpControl;
    }

    public void setVoiceCallback(VoiceCallback voiceCallback) {
        this.voiceCallback = voiceCallback;
    }

    public void setVideoCallback(VideoCallback videoCallback) {
        this.videoCallback = videoCallback;
    }

    //控制缓存包数量 用于解决udp乱序
    public abstract void setUdpPacketCacheMin(int udpPacketCacheMin);

    /*
    子类可以通过这个方法获得一些策略参数，根据需要决定是否使用,
     */
    public abstract void setOther(int videoFrameCacheMin);

    /*
    缓冲接口，用于PlayerView判断是否正在缓冲，根据需要决定是否需要使用
     */
    public abstract void setIsInBuffer(IsInBuffer isInBuffer);

    public void setWeightCallback(WeightCallback weightCallback) {
        this.weightCallback = weightCallback;
    }

    public int getReciveStatus() {
        return RECIVE_STATUS;
    }
}
