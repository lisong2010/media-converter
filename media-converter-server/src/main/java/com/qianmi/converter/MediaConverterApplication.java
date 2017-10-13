package com.qianmi.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author lisong(OF2016)
 * @date 2017-10-11
 */
@SpringBootApplication(scanBasePackages = {"com.qianmi.converter"})
@Slf4j
public class MediaConverterApplication {

    public static void main(String[] args) throws Exception {
        Environment env = SpringApplication.run(MediaConverterApplication.class, args).getEnvironment();
        String port = env.getProperty("server.port", "8080");
        log.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
                        + "External: \thttp://{}:{}\n----------------------------------------------------------",
                port, InetAddress.getLocalHost().getHostAddress(), port
        );
    }
}
