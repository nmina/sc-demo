package com.demo;

import com.demo.cassandra.repositories.entities.Feeds;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikko on 2/26/17.
 */
public class DemoUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Feeds convertFromJSON(String json) throws IOException {
        Map<String, String> feedMap = OBJECT_MAPPER.readValue(json, HashMap.class);
        return new Feeds(feedMap.get("title"), feedMap.get("someValue"));
    }

}
