package poc.ide.awt;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poc.ide.code.Clazz;
import poc.ide.code.Code;
import poc.ide.code.CompilationUnit;
import poc.ide.code.Package;
import poc.ide.code.util.CodeGenerators;
import poc.ide.gui.ClassViewer;
import poc.ide.gui.Window;
import poc.ide.proj.FsLocation;

class AwtClassViewer extends ClassViewer
{
	private JPanel panel;
	
	private JButton newClass;
	
	private GridLayout layout;
	
	AwtClassViewer()
	{
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
				Package createCode = CodeGenerators.Package_GENERATOR.createCode(null, null);
				CompilationUnit createCode2 = CodeGenerators.CompilationUnit_GENERATOR.createCode(createCode, null);
				Clazz clazz = CodeGenerators.Clazz_GENERATOR.createCode(createCode2, null);
				getProject().getCodeSet().add(clazz);
				Window.getWindow().getSelector().push(clazz);
				
				// Needs to be more generic...
				showClasses();
			}
		});
	}

	@Override
	public void showClasses(Set<Clazz> types)
	{
		panel.removeAll();
		
		layout.setColumns(2);
		layout.setRows(types.size() + 1);
		
		for (final Clazz type : types)
		{
			Code parent = type.getParent();
			
			JLabel label;
			if (parent == null)
			{
				label = new JLabel("Not parent");
			}
			else
			{
				label = new JLabel(parent.getNameSpaceUniqueKey());
			}
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
