package poc.ide.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JRootPane;

import poc.ide.code.CodeTree;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Selector;

public class AwtSelector extends Selector implements ActionListener
{
	private GridLayout layout = new GridLayout(0,1);
	private JRootPane root;
	private JButton done;
	
	List<InputMethod<? extends CodeTree>> inputs;
	
	AwtSelector(JRootPane root)
	{
		this.root = root;
		root.setLayout(layout);
		
		done = new JButton("Done");
		done.setBounds(50,50,50,50);
		done.setVisible(true);
		done.addActionListener(this);
	}
	
	@Override
	public void edit(List<InputMethod<? extends CodeTree>> inputMethod)
	{
		// move this...
		inputs = inputMethod;
		
		root.removeAll();
		for (InputMethod<? extends CodeTree> method : inputMethod)
		{
			AwtInputMethod im = (AwtInputMethod) method;
			Component component = im.getComponent();
			root.add(component);
			component.setVisible(true);
		}
		
		root.add(done);
		root.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (inputs == null)
		{
			return;
		}
		
		for (InputMethod<? extends CodeTree> input : inputs)
		{
			input.assign();
		}
		
		pop();
	}
}
