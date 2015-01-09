package poc.ide.gui;

import poc.ide.awt.AwtGuiFactory;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;


public class Window
{
	private GuiFactory guiFactory;
	
	private Viewer viewer;
	private Selector selector;
	private ClassViewer cViewer;
	
	private Window()
	{
		guiFactory = new AwtGuiFactory();
		viewer = guiFactory.createViewer();
		selector = guiFactory.createSelector(viewer);
		cViewer = guiFactory.createClassViewer(new Project(new FsLocation("./")));
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
	
	public GuiFactory getGuiFactor()
	{
		return guiFactory;
	}

	private static final Window window = new Window();
	public static Window getWindow() { return window; }

}
