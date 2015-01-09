package poc.ide.gui;

import java.util.Observable;
import java.util.Observer;

import poc.ide.code.CodeTree;
import poc.ide.main.RecursiveObserver;

public abstract class Viewer implements Observer
{
	private RecursiveObserver<CodeTree> observer;
	private CodeTree code;
	
	public Viewer()
	{
		observer = new RecursiveObserver<CodeTree>();
		observer.addObserver(this);
		
		code = null;
	}

	public void setCode(CodeTree newCode)
	{
		if (code != null)
		{
			observer.remove(code);
		}
		
		code = newCode;
		display(code);

		if (code != null)
		{
			observer.add(code);
		}
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
		if (code != null)
		{
			display(code);
		}
	}

	public abstract void display(CodeTree code);
}
