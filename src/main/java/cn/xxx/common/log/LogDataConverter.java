package cn.xxx.common.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LogDataConverter extends MessageConverter {


    @Override
    public String convert(ILoggingEvent event){
        // 获取原始日志
        String oriLogMsg = event.getFormattedMessage();
        Level logLevel = event.getLevel();

        Thread t = Thread.currentThread();
        return "\n####Thread：[" + t.getId() + "]######\n";
    }
}
