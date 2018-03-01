package chat.model;

import chat.controller.ChatbotController;
import chat.controller.IOController;

//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//import twitter4j.Twitter;
//import twitter4j.Status;
import twitter4j.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CTECTwitter 
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWorddCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		}
		
		catch(TwitterException tweetError)
		{
			appController.handleError(tweetError);
		}
		
		catch(Exception otherError)
		{
			appController.handleError(otherError);
		}
	}
}
