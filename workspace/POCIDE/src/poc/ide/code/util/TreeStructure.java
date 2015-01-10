package poc.ide.code.util;

import java.util.Collection;

public interface TreeStructure<T>
{
	T getParent();
	Collection<T> getChildren();
}