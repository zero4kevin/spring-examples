package com.zero4kevin.spring.examples.jms;

import com.zero4kevin.spring.examples.jms.consumers.AlterReceiver;
import com.zero4kevin.spring.examples.jms.models.Hunter;
import com.zero4kevin.spring.examples.jms.models.Ranks;
import com.zero4kevin.spring.examples.jms.models.Skills;
import com.zero4kevin.spring.examples.jms.producers.AlterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by kevin on 7/2/18.
 */
public class App {

    public static void main (String[] args){
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("jms-example/src/main/resources/applicatonContext.xml");
        AlterService producer= (AlterService) applicationContext.getBean("alterService");

        AlterReceiver receiver=new AlterReceiver();

        Hunter hunter=new Hunter();
        hunter.setName("hunter1");
        hunter.setRank(Ranks.Begining);
        hunter.setSkill(Skills.SHOOTING);
        producer.sendAltert(hunter);
    }
}
