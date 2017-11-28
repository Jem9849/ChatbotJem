package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import chat.model.Movie;

public class Chatbot
{
	private List<Movie> movieList;
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
		this.movieList = new ArrayList<Movie>(5);
		this.shoppingList = new ArrayList<String>(10);
		this.cuteAnimalMemes = new ArrayList<String>(5);
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = "TheTitleofTitlesAboutTitlesInTheTitleofTitles.";
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
		Movie chris = new Movie("Christoph");
		Movie chris2 = new Movie("Christoph2");
		Movie chris3 = new Movie("Christoph3");
		Movie chris4 = new Movie("Christoph4");
		Movie chris5 = new Movie("Christoph5");
		Movie chris6 = new Movie("Christoph5");
		movieList.add(chris);
		movieList.add(chris2);
		movieList.add(chris3);
		movieList.add(chris4);
		movieList.add(chris5);
		movieList.add(chris6);
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
		shoppingList.add("Chocolatedrunks(snacks)");
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
	
	/**
	 * It repeats what the user said, and then builds a response to return.  
	 * @param input The parameter is the input from the user.
	 * @return This returns what the chatbot will say in response and what the user says. 
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * It returns a response built using randomly generated words from verbs, topics, and questions. It may also take from movieList. 
	 * @return Returns the final built response to processConversation. 
	 */
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch(followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
			break;
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
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
		
		if (input != null )
		{
			ok = true;
		}
		
		return ok;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		boolean ok = false;
		
		if (contentCheck != null && contentCheck.contains(content))
		{
			ok = true;
		}
		return ok;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean ok = false; 
		
		for (int i = 0; i < cuteAnimalMemes.size(); i++)
		{
			if (input.contains(cuteAnimalMemes.get(i)))
			{
				ok = true;
			}
		}
		
		return ok;
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
		boolean ok = false;
		//if (genre != null && )
		{
			ok = true;
		}
		
		return ok;
	}

	public boolean quitChecker(String exitString)
	{
		boolean ok = false;
		
		if (exitString != null && exitString.equalsIgnoreCase("quit") )
		{
			ok = true;
		}
		
		return ok;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean ok = false;
		
		//if (sample != null && sample != "")
		
		return ok;
	}
	
	public List<Movie> getMovieList()
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
