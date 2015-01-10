package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poc.ide.code.Code;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

class AwtSelectorInput<C extends Code> extends InputMethod<C> implements ActionListener, AwtInputMethod
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
	public Component getComponent()
	{
		return panel;
	}

	public void assign() {}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Window.getWindow().getSelector().push(code);
	}
}
