package com.qianmi.converter.video;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lisong(OF2016)
 * @date 2017-10-10
 */
@Data
public class VideoAttributes implements Serializable {
    /**
     * The codec name for the encoding process. If null or not specified the
     * encoder will perform a direct stream copy.
     */
    private String codec = null;

    /**
     * The the forced tag/fourcc value for the video stream.
     */
    private String tag = null;

    /**
     * The bitrate value for the encoding process. If null or not specified a
     * default value will be picked.
     */
    private Integer bitRate = null;

    /**
     * The frame rate value for the encoding process. If null or not specified a
     * default value will be picked.
     */
    private Integer frameRate = null;

    /**
     * The video size for the encoding process. If null or not specified the
     * source video size will not be modified.
     */
    private VideoSize size = null;
}
