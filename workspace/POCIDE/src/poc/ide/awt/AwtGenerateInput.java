package poc.ide.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import poc.ide.code.util.CodeGenerators.CodeGenerator;
import poc.ide.code.Code;
import poc.ide.gui.GeneratorInput;
import poc.ide.gui.Window;

public class AwtGenerateInput extends GeneratorInput implements AwtInputMethod, ActionListener
{
	private JButton button;

	AwtGenerateInput(Code parent, Code child, CodeGenerator<? extends Code> generator)
	{
		super(parent, child, generator);
		
		button = new JButton(getLabel());
		button.setBounds(50,50,50,50);
		button.setVisible(true);
		
		button.addActionListener(this);
	}

	@Override
	public JButton getComponent()
	{
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		assign();
		Window.getWindow().getSelector().pop();
	}
}
