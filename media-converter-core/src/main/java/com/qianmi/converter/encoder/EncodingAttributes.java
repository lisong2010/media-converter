package com.qianmi.converter.encoder;

import com.qianmi.converter.audio.AudioAttributes;
import com.qianmi.converter.video.VideoAttributes;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lisong(OF2016)
 * @date 2017-10-10
 */
@Data
public class EncodingAttributes implements Serializable{

    /**
     * The format name for the encoded target multimedia file. Be sure this
     * format is supported (see {@link Encoder#getSupportedEncodingFormats()}.
     */
    private String format = null;

    /**
     * The start offset time (seconds). If null or not specified no start offset
     * will be applied.
     */
    private Float offset = null;

    /**
     * The duration (seconds) of the re-encoded stream. If null or not specified
     * the source stream, starting from the offset, will be completely
     * re-encoded in the target stream.
     */
    private Float duration = null;

    /**
     * The attributes for the encoding of the audio stream in the target
     * multimedia file. If null of not specified no audio stream will be
     * encoded. It cannot be null if also the video field is null.
     */
    private AudioAttributes audioAttributes = null;

    /**
     * The attributes for the encoding of the video stream in the target
     * multimedia file. If null of not specified no video stream will be
     * encoded. It cannot be null if also the audio field is null.
     */
    private VideoAttributes videoAttributes = null;

}
