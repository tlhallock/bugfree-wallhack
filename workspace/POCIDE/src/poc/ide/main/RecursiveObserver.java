package poc.ide.main;

import java.util.Observable;
import java.util.Observer;

public class RecursiveObserver<T extends TreeStructure<T>> extends Observable implements Observer
{
	public RecursiveObserver() {}
	
	public void add(T t)
	{
		if (t == null)
		{
			return;
		}
		
		for (T child : t.getChildren())
		{
			add(child);
		}
		
		((Observable) t).addObserver(this);
	}
	
	public void remove(T t)
	{
		if (t == null)
		{
			return;
		}
		
		for (T child : t.getChildren())
		{
			add(child);
		}
		
		((Observable) t).deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		notifyObservers(arg);
	}
}
