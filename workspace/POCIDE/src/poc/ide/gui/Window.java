package poc.ide.gui;

import poc.ide.awt.AwtGuiFactory;
import poc.ide.proj.Project;


public class Window
{
	private GuiFactory guiFactory;
	
	private Viewer viewer;
	private Selector selector;
	private ClassViewer cViewer;
	
	private Project project;
	
	private Window()
	{
		guiFactory = new AwtGuiFactory();
		
		viewer = guiFactory.createViewer();
		selector = guiFactory.createSelector(viewer);
		cViewer = guiFactory.createClassViewer();
	}
	
	public void setProject(Project project)
	{
		this.project = project;
		cViewer.setProject(project);
	}
	
	public Project getCurrentProject()
	{
		return project;
	}
	
	public Selector getSelector()
	{
		return selector;
	}
	
	public Viewer getViewer()
	{
		return viewer;
	}
	
	public ClassViewer getClassViewer()
	{
		return cViewer;
	}
	
	public GuiFactory getGuiFactory()
	{
		return guiFactory;
	}

	private static Window window;

	public static Window getWindow()
	{
		if (window == null)
		{
			window = new Window();
		}
		return window;
	}

}
