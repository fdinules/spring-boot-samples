package com.example.consumer.handler;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.messaging.Message;

import com.example.consumer.model.CommandMessage;
import com.example.consumer.sink.Sink;
import com.example.message.library.SpecificCommand;

@EnableBinding(Sink.class)
public class SimpleMessageHandler {

//	@StreamListener(Sink.COMMAND_PRODUCER_TO_CONSUMER)
//	public void handle(Message<?> cmd) {
//		JsonToObjectTransformer transformer = new JsonToObjectTransformer(CommandMessage.class);
//		CommandMessage commandMessage = (CommandMessage) transformer.transform(cmd).getPayload();
//		System.out.println("Received id :" + commandMessage.getId());
//	}
}
