package com.demo.kafka;

import com.demo.DemoUtils;
import com.demo.cassandra.repositories.FeedsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by 122386 on 2/24/17.
 */
@KafkaListener(id="ASD123", topics = {"SpringKafkaClassLevelTopic"}, containerFactory = "kafkaListenerContainerFactoryClassLevel")
public class DemoConsumerClassLevel {

    private static final Logger LOG = LogManager.getLogger(DemoConsumerClassLevel.class);

    @Autowired
    FeedsRepository feedsRepository;

    @KafkaHandler
    public void listen(String record) {
        LOG.info("Message received: {}", record);
        try {
            feedsRepository.save(DemoUtils.convertFromJSON(record));
            LOG.info("added! value={}", record);

        } catch (Exception e) {
            LOG.error("#storeData - error encountered ", e);
        }
    }


}
