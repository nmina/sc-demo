package com.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nikko on 2/22/17.
 */
public class DemoConsumer {

    private static final Logger LOG = LogManager.getLogger(DemoConsumer.class);

    public CountDownLatch countDownLatch0 = new CountDownLatch(3);
    public CountDownLatch countDownLatch1 = new CountDownLatch(3);
    public CountDownLatch countDownLatch2 = new CountDownLatch(3);

    @KafkaListener(id = "id0", topicPartitions = {@TopicPartition(topic = "SpringKafkaTopic", partitions  = {"0"})})
    public void listenerPartition0(ConsumerRecord<?, ?> record) {
        LOG.info("ConsumerID={}, Received: {}","id0-" + Thread.currentThread().getId(), record);
        countDownLatch0.countDown();
    }

    @KafkaListener(id = "id1", topicPartitions = {@TopicPartition(topic = "SpringKafkaTopic", partitions  = {"1"})})
    public void listenerPartition1(ConsumerRecord<?, ?> record) {
        LOG.info("ConsumerID={}, Received: {}","id1-" + Thread.currentThread().getId(), record);
        countDownLatch1.countDown();
    }

    @KafkaListener(id = "id2", topicPartitions = {@TopicPartition(topic = "SpringKafkaTopic", partitions  = {"2"})})
    public void listenerPartition2(ConsumerRecord<?, ?> record) {
        LOG.info("ConsumerID={}, Received: {}","id2-" + Thread.currentThread().getId(), record);
        countDownLatch2.countDown();
    }
}
