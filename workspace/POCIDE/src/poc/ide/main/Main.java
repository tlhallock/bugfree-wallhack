package poc.ide.main;

import poc.ide.code.Function;
import poc.ide.gui.Window;

public class Main {

	public static void main(String[] args)
	{
		Window.getWindow().getSelector().push(new Function(null));
		Window.getWindow().getClassViewer().showClasses();
	}
}
