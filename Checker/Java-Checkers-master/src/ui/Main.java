

package ui;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		
		//Set the look and feel to the OS look and feel
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Create a window to display the checkers game
		CheckersWindow window = new CheckersWindow();
		window.setDefaultCloseOperation(CheckersWindow.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
