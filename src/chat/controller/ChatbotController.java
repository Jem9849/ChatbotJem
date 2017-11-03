package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatbotController
{
	 private Chatbot chatbot;
	 private PopupDisplay display;
	 //private ChatFrame appFrame;
	 
	 public ChatbotController() // Makes an instance of Chatbot and PopupDisplay.
	 {
		 chatbot = new Chatbot("MURRRR");
		 display = new PopupDisplay();
	 }
	 
	public void start() // Makes a string called response which displays takes to gather a response from a user. It then checks the response to see whether it says quit, or if it is the correct length.
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) 
		{
			response = popupChat(response); 
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	{
		return input;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
}
