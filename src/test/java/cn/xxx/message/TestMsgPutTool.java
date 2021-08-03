package cn.xxx.message;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMsgPutTool {

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void testMessage(){
        for(int i = 0;i<500; i++){
            System.out.println("==============================" + i + "=====================================");
            jmsTemplate.convertAndSend("DEV.QUEUE.1", "************test" + i + "*********");
        }


    }


}
