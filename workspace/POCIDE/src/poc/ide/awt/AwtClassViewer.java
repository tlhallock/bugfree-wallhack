package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poc.ide.code.Type.Clazz;
import poc.ide.gui.ClassViewer;
import poc.ide.gui.Window;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;

public class AwtClassViewer extends ClassViewer
{
	private JPanel panel;
	
	private JButton newClass;
	
	private GridLayout layout;
	
	public AwtClassViewer(Project project)
	{
		super(project);
		
		panel = new JPanel();
		panel.setBounds(50,50,50,50);
		panel.setLayout(layout = new GridLayout(0,2));
		panel.setVisible(true);
		
		newClass = new JButton("New");
		newClass.setBounds(60,60,60,60);
		newClass.setVisible(true);
		newClass.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				FsLocation next = getProject().getSources().iterator().next();
				Clazz clazz = new Clazz("DaNewClass");
				getProject().getCodeSet().add(clazz);
				Window.getWindow().getSelector().push(clazz);
				
				// Needs to be more generic...
				showClasses();
			}
		});
	}

	@Override
	public void showClasses(TreeSet<Clazz> types)
	{
		panel.removeAll();
		
		layout.setColumns(2);
		layout.setRows(types.size() + 1);
		
		for (final Clazz type : types)
		{
			JLabel label = new JLabel(type.getPackage().collect());
			label.setBounds(50,50,50,50);
			label.setVisible(true);
			panel.add(label);

			label = new JLabel(type.getName());
			label.setBounds(50,50,50,50);
			label.setVisible(true);
			panel.add(label);
			
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent arg0)
				{
					Window.getWindow().getSelector().push(type);
				}
			});
		}
		
		panel.add(newClass);
		panel.updateUI();
		
	}
	
	Component getComponent()
	{
		return panel;
	}
}