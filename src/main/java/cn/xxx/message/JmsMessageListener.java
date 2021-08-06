package cn.xxx.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class JmsMessageListener {


    @Async("taskExecutor")
    @JmsListener(destination = "${msg.queue.recvQueue}")
    public void receiveMessage(Message message, Session session) throws JMSException {

        String msg = messageToString(message);
        System.out.println(Thread.currentThread().getName());
        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

    }

    /**
     * 根据Message报文转换成字符窜
     * @param message Jms报文
     * @return 字符串
     * @throws JMSException
     */
    private String messageToString(Message message) throws JMSException
    {
        String msg = null;

        // 如果是文本消息
        if (message instanceof TextMessage){
            //logger.debug("接受消息类型： TextMessage");
            msg = ((TextMessage) message).getText();
        }
        // 如果是bytes消息
        else if (message instanceof BytesMessage) {
            log.debug("接受消息类型： BytesMessage");
            //byte类型需要进行格式转化
            BytesMessage byteMsg = (BytesMessage)message;
            byte[] buff = null;
            try{
                long length = byteMsg.getBodyLength();
                buff = new byte[(int)length];
                byteMsg.readBytes(buff);
                msg = new String(buff, "UTF-8");
            }
            catch (JMSException | UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        // 如果是Map消息
        else if (message instanceof MapMessage) {
            log.debug("接受消息类型： MapMessage");
        }
        // 如果是Stream消息
        else if (message instanceof StreamMessage) {
            log.debug("接受消息类型： StreamMessage");
        }
        // 如果是Object消息
        else if (message instanceof ObjectMessage) {
            log.debug("接受消息类型： ObjectMessage");
        }
        else
        {
            log.error("从MQ得到的消息不是TextMessage类型或者BytesMessage类型，无法转换，转换结果为NULL。");
        }

        //logger.info("========================================");
        //logger.info("Step 1=====MQ JMS Listener started for queue: [" + mqConfig.getApp_queue_recvQueue() + "]");
        log.info("Received message is: [" + msg + "]");
        //logger.info("========================================");

        return msg;
    }
}
