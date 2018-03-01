package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

																									// Welcome to ChatPanel, where everything is nearly entirely boring. Here we extend our hands towards JPanel. Give a clap for JPanel. He brought a few stuff for us, isn't that sweet?

/**
 * This is the Jpanel. It basically has many of the functions and windows. 
 * 
 * @author Jeremy
 */
public class ChatPanel extends JPanel
{
	
																												// Let's also honor those who have set up this ChatPanel. Let's clap our hands together for the data members. 
	/**
	 * These are the many data members. Many of them are Jcomponents. 
	 */
	private ChatbotController appController;
	private JButton chatButton;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	private SpringLayout appLayout;
	private JTextField inputField;
	private JTextArea chatArea;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private JButton meowButton;
	private ImageIcon button;
	private URL url; 
	private AudioClip meow;
	
																															// Let's also thank our construction crew. They've been tasked by our data members to help out. Isn't that "super"? Let's also call our setupPanel, setupLayout, and setupListeners to the stage. 
	
	/**
	 * This basically sets up all the values, and sort of initializes them.
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		checkerButton = new JButton("Check Your Privledge");
		chatButton = new JButton("Meow", new ImageIcon(getClass().getResource("/chat/view/images/TinyGod.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/TinyGod.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/TinyGod.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/TinyGod.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/TinyGod.png")));
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, checkerButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 152, SpringLayout.SOUTH, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -398, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -293, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 257, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -27, SpringLayout.WEST, tweetButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -58, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 383, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -25, SpringLayout.EAST, this);
		
		chatArea = new JTextArea(7, 25);
		inputField = new JTextField(20);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatButton);
		
		infoLabel = new JLabel("Type something up, and then click Meow to speak to me.");
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -20, SpringLayout.NORTH, infoLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -9, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, infoLabel, -10, SpringLayout.EAST, this);
		
		infoLabel.setForeground(Color.WHITE);
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatScrollPane);
		button = new ImageIcon(getClass().getResource("images/catBttn3.png"));
		url = getClass().getResource("sounds/meow.mp3");    
		meow = Applet.newAudioClip(url);
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
																																			// Hi I'm the setupPanel, I thank you for the honor of being here today to speak. I help out setup the panel, like changing background color, or adding buttons and input fields. I don't really add 
																																			// functionality though. That is my friend, setupListeners. Speaking of him...
	
	/**
	 *  This is the setupPanel where we basically add all the components. We also make the chatArea unusable by users.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(infoLabel);
		this.add(chatScrollPane);
		this.add(searchButton);
		this.add(tweetButton);
		this.add(loadButton);
		this.add(saveButton);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		meowButton = new JButton(button);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -233, SpringLayout.WEST, meowButton);
		appLayout.putConstraint(SpringLayout.NORTH, meowButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, meowButton, 0, SpringLayout.EAST, inputField);
		
		add(meowButton);
		add(checkerButton);
	}
	
																																			// Hello everyone. My name is setupListeners. What I basically do is set up events and actions. I somewhat give functionality. I don't actually do the functionality myself a lot however. 
																																			// I like to connect events to actions instead. 
	
	/**
	 * This is the setupListeners which basically is like waiting for a event and performing an action. 
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
			
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		meowButton.addActionListener(new ActionListener() 
		{
			private int check = 0;
			public void actionPerformed(ActionEvent click)
			{
				check = 1;
				
				if (check == 1)
				{
				meow.play();
				
				}
			}
			
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(appController.search(usernameToSearch));
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
						
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
						
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
	}
	
																																			// Hey everyone, I do a pretty important job. I setup the layout and add in the position of things. Although, sometimes I misplace where I put all my positions, and need to go find them.
	/**
	 * This is the setupLayout which basically is carrying junk code from messing with windowbuilder. 
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 259, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -25, SpringLayout.EAST, this);
	}
	
																																					// Oh sorry I'm late. I setup the scroll pane. I am currently new and I didn't arrive with everybody else. I'm sorry. I make it so this chatArea becomes a viewport and has scrollableness.
	
	/**
	 * This adds in scrollability for the chatArea box. 
	 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
}
