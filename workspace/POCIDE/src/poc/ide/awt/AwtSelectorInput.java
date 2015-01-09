package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poc.ide.code.CodeTree;
import poc.ide.gui.Window;

public class AwtSelectorInput<C extends CodeTree> extends AwtInputMethod<C> implements ActionListener
{
	private JPanel panel;
	
	AwtSelectorInput(String label, C code)
	{
		super(label, code);
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setLayout(new GridLayout(1,2));
		
		JLabel jLabel = new JLabel(label);
		jLabel.setBounds(0,0,50,50);
		jLabel.setVisible(true);
		panel.add(jLabel);
		
		JButton button = new JButton("Modify");
		button.setBounds(0,0,50,50);
		button.setVisible(true);
		panel.add(button);
		
		button.addActionListener(this);
	}

	@Override
	Component getComponent()
	{
		return panel;
	}

	@Override
	public C getInput()
	{
		return code;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Window.getWindow().getSelector().push(code);
	}

}
