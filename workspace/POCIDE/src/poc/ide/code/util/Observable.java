package poc.ide.code.util;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Observable
{
	@JsonIgnore
	private Set<Observer> observers;
	
	public Observable()
	{
		observers = new HashSet<>();
	}
	
	public void addObserver(Observer o)
	{
		observers.add(o);
	}
	
	public void removeObserver(Observer o)
	{
		observers.remove(o);
	}

	public void notifyObservers()
	{
		for (Observer observer : observers)
		{
			observer.update();
		}
	}
}
