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
	
	// Let's also thank our construction crew. They've been tasked by our data members to help out. Isn't that "super"? Let's also call our setupPanel, setupLayout, and setupListeners to the stage. 
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("Meow");
		appLayout = new SpringLayout();
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		checkerButton = new JButton("Check Your Privledge");		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	// Hi I'm the setupPanel, I thank you for the honor of being here today to speak. I help out setup the panel, like changing background color, or adding buttons and input fields. I don't really add 
	// functionality though. That is my friend, setupListeners. Speaking of him...
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(checkerButton);
		
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
	}
	
	// Hey everyone, I do a pretty important job. I setup the layout and add in the position of things. Although, sometimes I misplace where I put all my positions, and need to go find them.
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -23, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -10, SpringLayout.EAST, this);
	}
}
