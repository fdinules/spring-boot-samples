package com.example.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.example.message.library.SpecificCommand;
import com.example.producer.model.CommandMessage;
import com.example.producer.source.Source;

@Service
@EnableBinding(Source.class)
public class CommandSenderService {
	private @Autowired Source commandsSource;

	public void sendCommand(CommandMessage cmd) {
		Message<CommandMessage> message = MessageBuilder.withPayload(cmd).build();
		commandsSource.output().send(new ObjectToJsonTransformer().transform(message));
	}
}
