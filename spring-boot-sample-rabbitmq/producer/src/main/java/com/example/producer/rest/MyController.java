package com.example.producer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.library.SpecificCommand;
import com.example.producer.service.CommandSenderService;

@RestController
public class MyController {
	@Autowired
	private CommandSenderService commandSenderService;

	@PostMapping("/send")
	public void send(@RequestBody SpecificCommand cmd) {
		commandSenderService.sendCommand(cmd);
	}
}
