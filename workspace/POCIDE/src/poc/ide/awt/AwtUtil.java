package poc.ide.awt;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

class AwtUtil
{
	static JFrame createWindow(String name)
	{
		JFrame frame = new JFrame(name);
		frame.setBounds(50,50,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		return frame;
	}
	
	static JFrame createWindow(String name, Component root)
	{
		JFrame frame = createWindow(name);
		frame.getRootPane().setLayout(new BorderLayout());
		frame.getRootPane().add(root, BorderLayout.CENTER);
		return frame;
	}
}
