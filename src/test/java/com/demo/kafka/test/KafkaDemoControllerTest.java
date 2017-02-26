package com.demo.kafka.test;

import com.demo.kafka.controllers.KafkaDemoController;
import org.junit.Assert;
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
public class KafkaDemoControllerTest {

    @Autowired
    KafkaDemoController kafkaDemoController;

    @Test
    public void sendMessage() throws Exception {
        String requestBody = "{\"sample\":\"hello world\"}";
        String response = kafkaDemoController.sendMessage("SpringKafkaTopic", requestBody);

        Assert.assertNotNull(response);
    }

}