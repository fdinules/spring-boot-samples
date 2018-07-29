package com.example.consumer.handler;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import com.example.consumer.sink.Sink;
import com.example.message.library.SpecificCommand;

@EnableBinding(Sink.class)
public class SimpleMessageHandler {

	@StreamListener(Sink.COMMAND_PRODUCER_TO_CONSUMER)
	public void handle(Message<SpecificCommand> cmd) {
		System.err.println("*** Received SpecificCommand: " + ((SpecificCommand) cmd.getPayload()).getCommandSpecificId());
	}
}
