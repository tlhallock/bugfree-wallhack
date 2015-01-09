package poc.ide.awt;

import java.awt.Color;

import javax.swing.JTextArea;

import poc.ide.code.CodeTree;
import poc.ide.gui.Viewer;

class AwtViewer extends Viewer
{
	private JTextArea textArea;
	
	AwtViewer()
	{
		textArea = new JTextArea("");
		textArea.setEditable(false);
//		textArea.setBounds(0, 0, 500, 500);
		textArea.setVisible(true);
		
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
	}

	@Override
	public void display(CodeTree code)
	{
		textArea.setText(code.toString());
	}

	JTextArea getTextArea()
	{
		return textArea;
	}
}
