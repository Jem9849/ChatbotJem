package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;



/**
 * This is the ChatFrame public class that inherits from JFrame. It hosts some private variables that are instances of ChatbotController and ChatPanel.
 * 
 * @author Jeremy
 */
public class ChatFrame extends JFrame
{
	/**
	 * These are the data members which make an appController object, and appPane object.
	 */
	private ChatbotController appController;
	private ChatPanel appPane;
	
	/**
	 * Here is a constructor for ChatFrame that has a sub class. It calls everything and connects the panel to the controller.
	 * @param appController
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		
		this.appController = appController;
		appPane = new ChatPanel(appController);
		
		setupFrame();
	}
	
	/**
	 * Sets up the basic parts of the frame, and includes the Jpanel. 
	 */
	private void setupFrame()
	{
		this.setContentPane(appPane);
		this.setTitle("MURRRRRRRRRRRRRRRRRRRRRRRRR");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	// This sets up the heat death extinction of ignorant users. Joking, it actually just returns the controller. 
	/**
	 * This returns the controller.
	 * @return appController
	 */
	public ChatbotController getBaseController()
	{
		return appController;
	}
	
}
