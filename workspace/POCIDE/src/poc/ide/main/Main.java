package poc.ide.main;

import poc.ide.gui.Window;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;

public class Main
{

	public static void main(String[] args)
	{
//		Window.getWindow().getSelector().push(new Function(null));
		Window.getWindow().setProject(new Project(new FsLocation("./")));
		Window.getWindow().getSelector().pop();
		Window.getWindow().getClassViewer().showClasses();
	}
}
