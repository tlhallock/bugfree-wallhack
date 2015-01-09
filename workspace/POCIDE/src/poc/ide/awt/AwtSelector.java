package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import poc.ide.code.CodeTree;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Selector;
import poc.ide.gui.Viewer;

class AwtSelector extends Selector implements ActionListener
{
	private JRootPane root;
	private JButton done;
	
	private List<InputMethod<? extends CodeTree>> inputs;
	
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
	public void edit(List<InputMethod<? extends CodeTree>> inputMethod)
	{
		// move this...
		inputs = inputMethod;
		
		root.removeAll();
		for (InputMethod<? extends CodeTree> method : inputMethod)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 2));
			panel.setVisible(true);
			root.add(panel);
			
			AwtInputMethod im = (AwtInputMethod) method;
			Component component = im.getComponent();
			panel.add(component);
			component.setVisible(true);
			
			JButton button = new JButton("Insert");
			button.setVisible(true);
			button.setBounds(50,50,50,50);
			panel.add(button);
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					System.out.println("Want to insert");
				}});
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
