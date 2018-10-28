package com.example.consumer.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
	String COMMAND_PRODUCER_TO_CONSUMER = "cmdProducerToConsumer";

	@Input(COMMAND_PRODUCER_TO_CONSUMER)
	SubscribableChannel input();
}
