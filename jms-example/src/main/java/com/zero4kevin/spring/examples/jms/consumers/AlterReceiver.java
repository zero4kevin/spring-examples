package com.zero4kevin.spring.examples.jms.consumers;

import com.zero4kevin.spring.examples.jms.models.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by kevin on 7/2/18.
 */

public class AlterReceiver extends Thread {

    public AlterReceiver() {
        start();
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public Object getAlter(){
        ObjectMessage receivedMessage=(ObjectMessage) jmsTemplate.receive();
        try {
            return receivedMessage.getObject();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }

    @Override
    public void run() {
        System.out.println(((Hunter)getAlter()).toString());
    }
}
