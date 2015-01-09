package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.ScopeModifier.Scoping;
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
	
	Scoping scope;
	
	public ScopeModifier()
	{
		this(Scoping.Private);
	}
	
	public ScopeModifier(Scoping value)
	{
		scope = value;
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(scope.text);
	}

	@Override
	protected void setParameter(String label, Object value)
	{
		scope = ((ScopeModifier) value).getScope();
	}

	public Scoping getScope()
	{
		return scope;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		returnValue.add(Window.guiFactory.createScopeInputMethod("slope", this));
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}

}
