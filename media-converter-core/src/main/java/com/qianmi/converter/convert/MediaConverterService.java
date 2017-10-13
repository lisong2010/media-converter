package com.qianmi.converter.convert;

import com.qianmi.converter.constants.Constants;
import com.qianmi.converter.encoder.Encoder;
import com.qianmi.converter.exception.ConverterRunTimeException;
import com.qianmi.converter.exception.ErrorCode;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author lisong(OF2016)
 * @date 2017-10-10
 */
@Service
public class MediaConverterService {

    @Autowired
    Encoder encoder;

    public byte[] convert(ConvertInfo convertInfo) {
        File temp = new File(System.getProperty("java.io.tmpdir"), Constants.FILE_PATH);
        if (!temp.exists()) {
            temp.mkdirs();
            temp.deleteOnExit();
        }
        File sourceFile = null;
        File distFile = null;
        try {
            sourceFile = new File(temp.getAbsolutePath(), String.valueOf(System.nanoTime()));
            FileUtils.writeByteArrayToFile(sourceFile, convertInfo.getData());

            distFile = new File(temp.getAbsolutePath(), String.valueOf(System.nanoTime()));

            encoder.encode(sourceFile, distFile, convertInfo.getEncodingAttributes());

            return FileUtils.readFileToByteArray(distFile);
        } catch (Exception e) {
            throw new ConverterRunTimeException(ErrorCode.ENCODER_ERR);
        } finally {
            if (sourceFile != null) {
                sourceFile.delete();
            }
            if (distFile != null) {
                distFile.delete();
            }
        }
    }
}
