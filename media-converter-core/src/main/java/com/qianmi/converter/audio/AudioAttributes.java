package com.qianmi.converter.audio;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lisong(OF2016)
 * @date 2017-10-10
 */
@Data
public class AudioAttributes implements Serializable {
    /**
     * The codec name for the encoding process. If null or not specified the
     * encoder will perform a direct stream copy.
     */
    private String codec = null;

    /**
     * The bitrate value for the encoding process. If null or not specified a
     * default value will be picked.
     */
    private Integer bitRate = null;

    /**
     * The samplingRate value for the encoding process. If null or not specified
     * a default value will be picked.
     */
    private Integer samplingRate = null;

    /**
     * The channels value (1=mono, 2=stereo) for the encoding process. If null
     * or not specified a default value will be picked.
     */
    private Integer channels = null;

    /**
     * The volume value for the encoding process. If null or not specified a
     * default value will be picked. If 256 no volume change will be performed.
     */
    private Integer volume = null;
}
