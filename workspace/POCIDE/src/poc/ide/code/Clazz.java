package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.ScopeModifier.Scoping;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class Clazz extends Type
{
	public static final Code implementation = new Clazz(null);

	private ScopeModifier scope;
	
	private final List<Declaration<? extends Type>>  variables   ;
	private final List<Function>                     functions   ;
	private final List<Type>                         parameters  ;
	private final List<Type>                         innerClasses;
	private final List<Block>                        blocks      ;
	private final List<Block>                        staticBlocks;

	public Clazz(CompilationUnit u)
	{
		this(u, "DaNewClassB");
	}
	
	public Clazz(CompilationUnit u, String name)
	{
		super(u, name);
		
		scope = new ScopeModifier(this, ScopeModifier.Scoping.Public);
		
		variables    = new LinkedList<Declaration<? extends Type>> ();  
		functions    = new LinkedList<Function>                    ();  
		parameters   = new LinkedList<Type>                        ();  
		innerClasses = new LinkedList<Type>                        ();  
		blocks       = new LinkedList<Block>                       ();  
		staticBlocks = new LinkedList<Block>                       ();  
	}
	
	public boolean isPublic()
	{
		return getScopeModifier().getScope().equals(Scoping.Public);
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		returnValue.add(Window.getWindow().getGuiFactory().createScopeInputMethod("Class Scope:", scope));
		returnValue.add(Window.getWindow().getGuiFactory().createNameInputMethod("Class name:", name));
		
		return returnValue;
	}

	public String getName()
	{
		return getUniqueNamespaceToken();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		builder.append(scope).append(" class ").append(name).append('\n');
		builder.append("{\n");
		builder.append("}\n");
		return builder;
	}

	public ScopeModifier getScopeModifier()
	{
		return scope;
	}
}