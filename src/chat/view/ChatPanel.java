package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import chat.controller.ChatbotController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

// Welcome to ChatPanel, where everything is nearly entirely boring. Here we extend our hands towards JPanel. Give a clap for JPanel. He brought a few stuff for us, isn't that sweet?
public class ChatPanel extends JPanel
{
	
	// Let's also honor those who have set up this ChatPanel. Let's clap our hands together for the data members. 
	private ChatbotController appController;
	private JButton chatButton;
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
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("Meow");
		appLayout = new SpringLayout();
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type something up, and then click Meow to speak to me.");
		checkerButton = new JButton("Check Your Privledge");
		infoLabel.setForeground(Color.WHITE);
		chatScrollPane = new JScrollPane();
		button = new ImageIcon(getClass().getResource("images/catBttn3.png"));
		meowButton = new JButton(button);
		url = getClass().getResource("sounds/meow.mp3");    
		meow = Applet.newAudioClip(url);
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	// Hi I'm the setupPanel, I thank you for the honor of being here today to speak. I help out setup the panel, like changing background color, or adding buttons and input fields. I don't really add 
	// functionality though. That is my friend, setupListeners. Speaking of him...
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(checkerButton);
		this.add(infoLabel);
		this.add(chatScrollPane);
		this.add(meowButton);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	// Hello everyone. My name is setupListeners. What I basically do is set up events and actions. I somewhat give functionality. I don't actually do the functionality myself a lot however. 
	// I like to connect events to actions instead. 
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
				
				wait(3);
				}
			}
			
		});
	}
	
	// Hey everyone, I do a pretty important job. I setup the layout and add in the position of things. Although, sometimes I misplace where I put all my positions, and need to go find them.
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -23, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, meowButton, 0, SpringLayout.NORTH, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, meowButton, 24, SpringLayout.WEST, this);
		
	}
	
	// Oh sorry I'm late. I setup the scroll pane. I am currently new and I didn't arrive with everybody else. I'm sorry. I make it so this chatArea becomes a viewport and has scrollableness.
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
}
