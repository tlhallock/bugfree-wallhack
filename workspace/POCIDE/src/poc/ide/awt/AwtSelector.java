package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import poc.ide.code.Code;
import poc.ide.code.util.CodeGenerators.CodeGenerator;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Selector;
import poc.ide.gui.Viewer;

class AwtSelector extends Selector implements ActionListener
{
	private JRootPane root;
	private JButton done;
	
	private List<InputMethod<? extends Code>> inputs;
	
	AwtSelector(Viewer v, JRootPane root)
	{
		super(v);
		this.root = root;
		root.setLayout(new GridLayout(0,1));
		
		done = new JButton("Done");
		done.setBounds(50,50,50,50);
		done.setVisible(true);
		done.addActionListener(this);
	}
	
	@Override
	public void edit(List<InputMethod<? extends Code>> inputMethod)
	{
		// move this...
		inputs = inputMethod;
		root.removeAll();
		
		for (final InputMethod<? extends Code> method : inputMethod)
		{
			JPanel panel = new JPanel();
			panel.setVisible(true);
			root.add(panel);
			
			AwtInputMethod im = (AwtInputMethod) method;
			Component component = im.getComponent();
			component.setVisible(true);
			
			
			if (!method.canInsert())
			{
				panel.setLayout(new GridLayout(1, 1));
				panel.add(component);
				continue;
			}

			panel.setLayout(new GridLayout(1, 2));

			panel.add(component);

			JButton button = new JButton("Insert");
			button.setVisible(true);
			button.setBounds(50, 50, 50, 50);
			panel.add(button);

			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					generatorPrompt(method);
				}
			});
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
		
		for (InputMethod<? extends Code> input : inputs)
		{
			input.assign();
		}
		
		pop();
	}
}

