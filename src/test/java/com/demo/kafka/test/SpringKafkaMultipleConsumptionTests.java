package com.demo.kafka.test;

import com.demo.kafka.DemoConsumer;
import com.demo.kafka.DemoProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 122386 on 2/23/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaMultipleConsumptionTests {

    @Autowired
    private DemoConsumer consumer;

    @Autowired
    private DemoProducer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            producer.sendMessage("SpringKafkaTopic", "Message number " + i);
        }
//        assertThat(this.consumer.countDownLatch0.await(1, TimeUnit.SECONDS)).isTrue();
//        assertThat(this.consumer.countDownLatch1.await(1, TimeUnit.SECONDS)).isTrue();
//        assertThat(this.consumer.countDownLatch2.await(1, TimeUnit.SECONDS)).isTrue();
    }
}
