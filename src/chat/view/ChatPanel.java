package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton firstButton;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		
		this.appController = appController;
		firstButton = new JButton("Click on the button");
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(firstButton);
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener() 
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
