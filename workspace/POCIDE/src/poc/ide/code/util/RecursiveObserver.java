package poc.ide.code.util;

import poc.ide.code.util.Observer;
import poc.ide.code.util.Observable;

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
		
		((Observable) t).removeObserver(this);
	}

	@Override
	public void update()
	{
		notifyObservers();
	}
}
