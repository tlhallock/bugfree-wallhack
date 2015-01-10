package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class ScopeModifier extends Code
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
	
	public ScopeModifier(Code parent)
	{
		this(parent, Scoping.Private);
	}
	
	public ScopeModifier(Code parent, Scoping value)
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
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		returnValue.add(Window.getWindow().getGuiFactory().createScopeInputMethod("slope", this));
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}

}
