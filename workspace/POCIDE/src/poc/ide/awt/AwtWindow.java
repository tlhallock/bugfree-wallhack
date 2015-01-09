package poc.ide.awt;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import poc.ide.gui.Viewer;
import poc.ide.gui.Window;

public class AwtWindow extends Window {

	public JFrame frame;

	public void show()
	{
		frame = new JFrame("Main window");
		frame.setBounds(50,50,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
