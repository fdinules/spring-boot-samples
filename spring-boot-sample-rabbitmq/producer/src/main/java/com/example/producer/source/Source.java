package com.example.producer.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
	String COMMAND_PRODUCER_TO_CONSUMER = "command.producer.consumer";

	@Output(COMMAND_PRODUCER_TO_CONSUMER)
	MessageChannel output();
}
