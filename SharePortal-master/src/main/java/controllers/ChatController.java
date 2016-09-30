package controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Message;
import model.ChatMessage;

@Controller
public class ChatController {
	@RequestMapping("/Chat")
	public String viewApplication() {
		System.out.println("chat controller");
		return "ChatView";
	}

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public ChatMessage sendMessage(Message message) {
		return new ChatMessage(message, new Date());
	}
}
