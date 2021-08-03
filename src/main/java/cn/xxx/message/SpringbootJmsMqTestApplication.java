package cn.xxx.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@EnableJms
@EnableTransactionManagement
@EnableAsync
public class SpringbootJmsMqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJmsMqTestApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Springboot Jms Mq Test 启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
