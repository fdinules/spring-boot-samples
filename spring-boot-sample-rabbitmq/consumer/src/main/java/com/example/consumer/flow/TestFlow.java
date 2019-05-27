package com.example.consumer.flow;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import com.example.consumer.model.CommandMessage;
import com.example.consumer.sink.Sink;

@EnableBinding(Sink.class)
public class TestFlow {

	@Bean
	public IntegrationFlow fdinulesFlow() {
		return IntegrationFlows.from(Sink.COMMAND_PRODUCER_TO_CONSUMER)//
				.wireTap(sf -> sf.handle(wireTapHandler()))//
				.filter(filterType1())//trec doar type2
				.handle(type2Handler())//
				.get();
	}

	@Bean
	public MessageSelector filterType1() {
		return new MessageSelector() {
			
			@Override
			public boolean accept(Message<?> source) {
				JsonToObjectTransformer transformer = new JsonToObjectTransformer(CommandMessage.class);
				CommandMessage commandMessage = (CommandMessage) transformer.transform(source).getPayload();
				
				if (commandMessage.getType().equals("type1")) {
					System.err.println("2.filterType1 e type1, nu merge mai departe ");
					return false;
				}
				System.out.println("2.filterType1 e "+ commandMessage.getType()+ ", merge mai departe");
				return true;
			}
		};
	}
	
	@Bean
	public MessageHandler type2Handler() {
		MessageHandler handler = new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				
				JsonToObjectTransformer transformer = new JsonToObjectTransformer(CommandMessage.class);
				CommandMessage commandMessage = (CommandMessage) transformer.transform(message).getPayload();
				System.out.println("3.type2Handler handled " + commandMessage.getType());

			}
		};
		return handler;
	}
	
	@Bean
	public MessageHandler wireTapHandler() {
		MessageHandler handler = new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				JsonToObjectTransformer transformer = new JsonToObjectTransformer(CommandMessage.class);
				CommandMessage commandMessage = (CommandMessage) transformer.transform(message).getPayload();
				//System.out.println(((SpecificCommand)message.getPayload()).getCommandSpecificId());
				System.out.println("1.wireTapHandler handled " + commandMessage.getType());

			}
		};
		return handler;
	}
}
