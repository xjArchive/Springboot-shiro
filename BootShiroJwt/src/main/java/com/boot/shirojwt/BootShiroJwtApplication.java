package com.boot.shirojwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: BootShiroJwtApplication
 * Description:
 * date: 2020/2/14 21:47
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
@SpringBootApplication
@MapperScan(value = "com.boot.shirojwt.mapper")
public class BootShiroJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootShiroJwtApplication.class, args);
    }
}
