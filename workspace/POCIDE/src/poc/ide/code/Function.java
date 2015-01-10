package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.ScopeModifier.Scoping;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;


public class Function extends Code
{
	private Name name;
	private ScopeModifier scope;
	
	// The are declarations...
	private Type[] argTypes;
	private Name[] argNames;
	
	private Type returnType;
	private List<Type> exceptions;
	

	private List<Type> innerClasses;
	
	Type generic;

	
	public Function(Code parent)
	{
		super(parent);
		
		name = new Name(this, "newfunction");
		name.setParent(this);
		
		scope = new ScopeModifier(this, Scoping.Public);
		scope.setParent(this);
		
		argTypes = new Type[0];
		argNames = new Name[0];
		returnType = Type.Primitive.VoidType.implementation;
	}
	
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		scope.appendText(builder, depth).append(" ");
		builder.append(returnType).append(" ");
		builder.append(name);
		builder.append("()\n{\n\t\n}");
		return builder;
	}
	
	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		returnValue.add(Window.getWindow().getGuiFactory().createScopeInputMethod("Function Scope:", scope));
		returnValue.add(Window.getWindow().getGuiFactory().createNameInputMethod("Function Name:", name));
		
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(name.getUniqueNamespaceToken());
		
		for (Type t : argTypes)
		{
			builder.append(t.getUniqueNamespaceToken());
		}
		
		return builder.toString();
	}
}








