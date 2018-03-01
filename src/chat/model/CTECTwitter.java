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
	private long totalWordCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.totalWordCount = 0;
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
	
	
	public String getMostCommonWord(String username)
	{
		String mostCommon = "";
		
		collectTweets(username);
		
		return mostCommon;
	}
}
