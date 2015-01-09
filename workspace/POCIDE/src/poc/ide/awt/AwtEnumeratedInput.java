package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import poc.ide.code.CodeTree;

abstract class AwtEnumeratedInput<C extends CodeTree, EN> extends AwtInputMethod<C>
{
	private JPanel panel;
	private JSpinner spinner;

	AwtEnumeratedInput(String label, C c, String[] names, String cValue)
	{
		super(label, c);
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(40,40,40,40);
		panel.setLayout(new GridLayout(1,2));
		
		JLabel jLabel = new JLabel(label);
		jLabel.setBounds(30,30,30,30);
		jLabel.setVisible(true);
		panel.add(jLabel);

		
		spinner = new JSpinner(new SpinnerListModel(names));
		spinner.setBounds(50, 50, 500, 500);
		spinner.setVisible(true);
		spinner.setValue(cValue);
		panel.add(spinner);
	}
	
	@Override
	Component getComponent()
	{
		return panel;
	}

	protected abstract EN getCode(String name);
	protected EN getCode()
	{
		return getCode((String) spinner.getValue());  
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static <T extends Enum<T>> String[] getNames(T[] e)
	{
		LinkedList<String> names = new LinkedList<String>();
		
		for (T t : e)
		{
			names.add(t.name());
		}
		
		return names.toArray(new String[0]);
	}
	
	public static <T extends Enum<T>> T getValue(T[] e, String name)
	{
		for (T t : e)
		{
			if(t.name().equals(name))
			{
				return t;
			}
		}
		return null;
	}
}
