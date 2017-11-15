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

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private SpringLayout appLayout;
	private JTextField inputField;
	private JTextArea chatArea;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("Click on the button");
		appLayout = new SpringLayout();
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
	}
	
	private void setupLayout()
	{
		
	}
}
