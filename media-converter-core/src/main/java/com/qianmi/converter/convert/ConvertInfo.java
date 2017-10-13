package com.qianmi.converter.convert;

import com.qianmi.converter.encoder.EncodingAttributes;
import lombok.Builder;
import lombok.Data;

/**
 * @author lisong(OF2016)
 * @date 2017-10-10
 */
@Data
@Builder
public class ConvertInfo {
    /**
     * base64后的数据
     */
    private byte[] data;

    /**
     * 压缩参数
     */
    private EncodingAttributes encodingAttributes;
}
