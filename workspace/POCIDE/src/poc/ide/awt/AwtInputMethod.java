package poc.ide.awt;

import java.awt.Component;

import poc.ide.code.CodeTree;
import poc.ide.gui.InputMethod;

public abstract class AwtInputMethod<T extends CodeTree> extends InputMethod<T>
{
	AwtInputMethod(String label, T code)
	{
		super(label, code);
	}

	abstract Component getComponent();
}
