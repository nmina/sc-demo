package com.demo.cassandra.controllers;

import com.demo.DemoUtils;
import com.demo.cassandra.repositories.FeedsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nikko on 2/25/17.
 */
@RestController
@RequestMapping("/cassandra/rest")
public class FeedsController {

    private static final Logger LOG = LogManager.getLogger(FeedsController.class);

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    FeedsRepository feedsRepository;

    @RequestMapping(value="/store", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String storeData(@RequestBody String jsonInput) {
        try {
            feedsRepository.save(DemoUtils.convertFromJSON(jsonInput));
            LOG.info("added! value={}", jsonInput);

            return OBJECT_MAPPER.writeValueAsString("{success!}");
        } catch (Exception e) {
            LOG.error("#storeData - error encountered ", e);
        }
        return null;
    }

    @RequestMapping("get-all")
    public String getAllData() {
        ObjectNode objNode = OBJECT_MAPPER.createObjectNode();
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();

        feedsRepository.findAll().forEach(feed -> arrayNode.add(OBJECT_MAPPER.convertValue(feed, JsonNode.class)));

        objNode.put("FeedsRecord", arrayNode);

        return objNode.toString();
    }
}
