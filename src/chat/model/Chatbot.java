package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<String> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<String>(5);
		this.shoppingList = new ArrayList<String>(10);
		this.cuteAnimalMemes = new ArrayList<String>(5);
		this.currentTime = null;
		this.questions = new String [10];
		this.username = "@mrweirdoguy";
		this.content = null;
		this.intro = "Hello I'm a weirdo chatbot that hates everyone.";
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
		buildQuestions();
		buildChatbotResponse();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "LOVE";
		verbs[1] = "HATE";
		verbs[2] = "am detestant of";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add("Rawr");
		movieList.add("Rawr2");
		movieList.add("Rawr3");
		movieList.add("Rawr4");
		movieList.add("Rawr5");
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("A Dasani Water Bottle Outfitted With Explosives (terror)");
		shoppingList.add("gross things(ew)");
		shoppingList.add("drugs(ew)");
		shoppingList.add("hippoes(protein)");
		shoppingList.add("drinks(drinks)");
		shoppingList.add("TOMOTTOES(veggies)");
		shoppingList.add("A fistful of knowledge(ew)");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("nuke");
		cuteAnimalMemes.add("pupper");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "HATE me?";
		questions[2] = "am detestant of me?";
		questions[3] = "am thinking about me?";
		questions[4] = "LOVE me?";
		questions[5] = "HATE you?";
		questions[6] = "am detestant of you?";
		questions[7] = "am thinking about you?";
		questions[8] = "HATE friends?";
		questions[9] = "am detestant of friends?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	public String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;  
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			/*
			if (input.length() > 2)
			{
				validLength = true;
			}
			*/
			validLength = true; 
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean ok = false;
		char[] inpt = input.toCharArray();
		int count = 0;
		
		for (int i = 0; i < input.length(); i++)
		{
			if(inpt[i] == '@')
			{
				count++;
			}
		}
		
		if (input != null && count == 1 && (!(input.contains(".com"))))
		{
			ok = true;
		}
		
		return ok;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean ok = false;
		
		for (int index = 0; index < shoppingList.size(); index++)
		{
			
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				ok = true;
			}
		}
		
		return ok;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<String> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{		
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
