package com.demo.kafka.controllers;

import com.demo.kafka.DemoProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 122386 on 2/23/17.
 */
@RestController
@RequestMapping("/kafka/rest")
public class KafkaDemoController {

    private static final Logger LOG = LogManager.getLogger(KafkaDemoController.class);

    @Autowired
    private DemoProducer producer;

    @RequestMapping(value = "send-message/{kafkaTopic}", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@PathVariable("kafkaTopic") String topic, @RequestBody String requestBody) {

        LOG.debug("#sendMessage for topic {}. RequestBody is {}", topic, requestBody);

        try {
            producer.sendMessage(topic, requestBody);
            return this.sendJsonResponse("Success!");
        } catch (Exception e) {
            return this.sendJsonResponse("An error was encountered while trying to send a message");
        }
    }

    @RequestMapping("test")
    public String testService() {
        return "Hello There!";
    }

    private String sendJsonResponse(String message) {
        return "{\"response\":\"" + message + "\"}";
    }
}
