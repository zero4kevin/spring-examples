package com.zero4kevin.spring.examples.jms.producers;

import com.zero4kevin.spring.examples.jms.models.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by kevin on 7/1/18.
 */
@Component("alterService")
public class ObjectCreationAlterService implements AlterService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendAltert(final Hunter hunter) {
        jmsTemplate.send("no1", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(hunter);
            }
        });

    }
}
