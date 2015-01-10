package poc.ide.gui;

import poc.ide.code.Code;
import poc.ide.code.util.Observer;
import poc.ide.code.util.RecursiveObserver;

public abstract class Viewer implements Observer
{
	private RecursiveObserver<Code> observer;
	private Code code;
	
	public Viewer()
	{
		observer = new RecursiveObserver<Code>();
		observer.addObserver(this);
		
		code = null;
	}

	public void setCode(Code newCode)
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
	public void update()
	{
		if (code != null)
		{
			display(code);
		}
	}

	public abstract void display(Code code);
}
