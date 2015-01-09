package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poc.ide.code.Name;

public class AwtNameInput extends AwtInputMethod<Name>
{
	private JTextField field;
	private JPanel panel;
	
	AwtNameInput(final String label, final Name callback)
	{
		super(label, callback);
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(40,40,40,40);
		panel.setLayout(new GridLayout(1,2));
		
		JLabel jLabel = new JLabel(label);
		jLabel.setBounds(30,30,30,30);
		jLabel.setVisible(true);
		panel.add(jLabel);
		
		field = new JTextField();
		field.setBounds(50,50,50,50);
		field.setText(callback.getName());
		panel.add(field);
	}
	
	JTextField getField()
	{
		return field;
	}

	@Override
	public Name getInput() {
		return new Name(field.getText());
	}

	@Override
	Component getComponent()
	{
		return panel;
	}
}

