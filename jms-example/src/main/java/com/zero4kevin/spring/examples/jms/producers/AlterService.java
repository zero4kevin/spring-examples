package com.zero4kevin.spring.examples.jms.producers;

import com.zero4kevin.spring.examples.jms.models.Hunter;

/**
 * Created by kevin on 7/1/18.
 */
public interface AlterService {
    void sendAltert(Hunter hunter);
}
