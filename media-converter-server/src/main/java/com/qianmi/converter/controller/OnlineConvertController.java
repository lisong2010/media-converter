package com.qianmi.converter.controller;

import com.qianmi.converter.audio.AudioAttributes;
import com.qianmi.converter.convert.ConvertInfo;
import com.qianmi.converter.convert.MediaConverterService;
import com.qianmi.converter.encoder.EncodingAttributes;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lisong(OF2016)
 * @date 2017-10-11
 */
@Controller
public class OnlineConvertController {

    @Autowired
    MediaConverterService mediaConverterService;

    /**
     * 上传文件测试
     * @param audio2Mp3
     * @return
     * @throws Exception
     */
    @RequestMapping("/audio2Mp3")
    public void audio2Mp3(@RequestBody byte[] audio2Mp3, HttpServletResponse response) throws Exception {
        EncodingAttributes encodingAttributes = new EncodingAttributes();
        AudioAttributes audioAttributes = new AudioAttributes();
        audioAttributes.setCodec("libmp3lame");
        encodingAttributes.setFormat("mp3");
        encodingAttributes.setAudioAttributes(audioAttributes);

        ConvertInfo convertInfo = ConvertInfo.builder()
                .data(audio2Mp3)
                .encodingAttributes(encodingAttributes)
                .build();

        byte[] bytes = mediaConverterService.convert(convertInfo);

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Dispostiion", "attachment;filename=test.map3;");
        response.getOutputStream().write(bytes);
    }
}
