package poc.ide.gui;

import poc.ide.awt.AwtGuiFactory;
import poc.ide.code.Function;


public class Window
{
	Selector selector;
	
	public Window()
	{
		selector = guiFactory.createSelector();
	}

	public static GuiFactory guiFactory = new AwtGuiFactory();
	private static final Window window = new Window();
	public static Window getWindow() { return window; }

	public Selector getSelector()
	{
		return selector;
	}
}
