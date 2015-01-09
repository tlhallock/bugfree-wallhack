package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class ScopeModifier extends CodeTree
{
	public enum Scoping
	{
		Public("public"),
		Default(""),
		Private("private"),
		Protected("protected"),
		
		;
		
		String text;
		
		Scoping(String code)
		{
			this.text = code;
		}
		
		String getCode()
		{
			return text;
		}
	}
	
	private Scoping scope;
	
	public ScopeModifier(CodeTree parent)
	{
		this(parent, Scoping.Private);
	}
	
	public ScopeModifier(CodeTree parent, Scoping value)
	{
		super(parent);
		scope = value;
	}

	public Scoping getScope()
	{
		return scope;
	}
	
	public void setScope(Scoping scoping)
	{
		scope = scoping;
		notifyObservers();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(scope.text);
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		returnValue.add(Window.getWindow().getGuiFactor().createScopeInputMethod("slope", this));
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}

}
