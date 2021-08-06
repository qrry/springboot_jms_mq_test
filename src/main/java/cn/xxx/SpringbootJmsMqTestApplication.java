package cn.xxx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class SpringbootJmsMqTestApplication{

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootJmsMqTestApplication.class);
        //关闭banner
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        //SpringApplication.run(cn.xxx.message.SpringbootJmsMqTestApplication.class, args);
        //System.out.println("(♥◠‿◠)ﾉﾞ  Springboot Jms Mq Test 启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
