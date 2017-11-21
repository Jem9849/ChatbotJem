package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

/**
 * Manages the Chatbot and includes model and frame from view. 
 * @author Jeremy Saysanasy
 * @version 11/21/17 ~ 0.0.7 Fixed up content checker. 
 */

public class ChatbotController
{
	 private Chatbot chatbot;
	 private PopupDisplay display;
	 private ChatFrame appFrame;
	 
	 public ChatbotController() // Makes an instance of Chatbot and PopupDisplay.
	 {
		 chatbot = new Chatbot("MURRRR");
		 display = new PopupDisplay();
		 appFrame = new ChatFrame(this);
	 }
	 
	public void start() // Makes a string called response which displays takes to gather a response from a user. It then checks the response to see whether it says quit, or if it is the correct length.
	{
		
		display.displayText("Welcome to all hell broken loose.");
		
		//String response = display.collectResponse("What do you want to talk about?");
		
	/*	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) 
		{
			response = popupChat(response); 
			response = display.collectResponse(response);
		}
	*/
		
	}
	
	public String interactWithChatbot(String input)
	{
		String MURRRRChat = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		MURRRRChat += chatbot.processConversation(input);
		
		return MURRRRChat;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if (chatbot.cuteAnimalMemeChecker(text))
		{
			response += "This text matches the animal memes\n";		
		}
		if (chatbot.htmlTagChecker(text))
		{
			response += "This text matches the correct HTML tag\n";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "This text does not look like keyboard mashing \n";
		}
		if(chatbot.lengthChecker(text))
		{
			response += "This text is the correct length \n";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "";
		}
		
		return response;
	}
	
	private void close()
	{
		display.displayText("Gooby plz.");
		System.exit(0);
	}
	
	private String popupChat(String chat) // Je ne sais pas qu'il a fait.
	{
		String chatbotSays = ""; 

		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	// Things that return the chatbot, display, appFrame.
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
}
