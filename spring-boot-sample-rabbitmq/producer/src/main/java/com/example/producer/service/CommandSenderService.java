package com.example.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.example.message.library.SpecificCommand;
import com.example.producer.source.Source;

@Service
@EnableBinding(Source.class)
public class CommandSenderService {
	private @Autowired Source commandsSource;

	public void sendCommand(SpecificCommand cmd) {
		Message<SpecificCommand> message = MessageBuilder.withPayload(cmd).build();
		commandsSource.output().send(message);
	}
}
