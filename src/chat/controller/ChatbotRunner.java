package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotRunner
{
	public static void main (String [] args) 
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("words go here");
		test.collectResponse("ask a question");
	}
}
