package com.example;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class KafkaStreamsApp {
    public static void main(String[] args) {
        // Set up configuration properties for Kafka Streams
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");  // Adjust your Kafka broker address here
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // Create a StreamsBuilder to build the processing topology
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> sourceStream = builder.stream("input-topic"); // Replace with your input topic
        sourceStream.to("output-topic"); // Replace with your output topic

        // Build the Kafka Streams topology
        Topology topology = builder.build();

        // Create and start the Kafka Streams application
        KafkaStreams streams = new KafkaStreams(topology, new StreamsConfig(props));
        streams.start();

        // Add a shutdown hook to stop the stream gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
