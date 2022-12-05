package com.erick.company;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class KaftaStream {
    public static void main( String[] args ) {

        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafta-streams-demo");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder builder = new StreamsBuilder(); //create topology
        final KStream<String, String> source = builder.stream("test-stream-in"); //Read from topic

        source.flatMapValues(value -> {
            var r = new ArrayList<>();
            r.add("{ word: '"+ value + "', length: "+value.length() + ", words: " + value.split(" ").length+"}");
            return r;
        }).to("test-stream-out"); //adding result to the out topic

        final KafkaStreams streams = new KafkaStreams(builder.build(), properties);
        streams.start();
    }
}
