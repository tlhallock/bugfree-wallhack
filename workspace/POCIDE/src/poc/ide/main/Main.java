package poc.ide.main;

import poc.ide.code.Function;
import poc.ide.gui.Window;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;

public class Main {

	public static void main(String[] args)
	{
		Window.getWindow().getSelector().push(new Function());
		Window.guiFactory.createClassViewer(new Project(new FsLocation("./"))).showClasses();
	}
}
