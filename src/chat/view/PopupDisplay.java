package chat.view;

import javax.swing.JOptionPane;

public class PopupDisplay
{
	public void displayMessage(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String fromQuestion)
	{
		String reply = "";
		
		reply += JOptionPane.showInputDialog(null, fromQuestion);
		
		return reply; 
	}
}
