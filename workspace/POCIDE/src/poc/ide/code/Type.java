package poc.ide.code;

import java.util.LinkedList;
import java.util.List;


import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public abstract class Type extends CodeTree
{
	protected Name name;

	public Type() {}
	
	public Type(String name)
	{
		this.name = new Name(name);
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return name.getName();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(name);
	}

	@Override
	protected void setParameter(String label, Object value) {}
	
	public static class Clazz extends Type
	{
		private ScopeModifier scope;
		private Package pack4ge;
		
		private final List<Variable> variables   ;
		private final List<Function> functions   ;
		private final List<Type>     parameters  ;
		private final List<Type>     innerClasses;
		private final List<Block>    blocks      ;
		private final List<Block>    staticBlocks;
		
		public Clazz(String name)
		{
			super(name);
			
			pack4ge = new Package();
			
			scope = new ScopeModifier(ScopeModifier.Scoping.Public);
			
			variables    = new LinkedList<Variable> ();  
			functions    = new LinkedList<Function> ();  
			parameters   = new LinkedList<Type>     ();  
			innerClasses = new LinkedList<Type>     ();  
			blocks       = new LinkedList<Block>    ();  
			staticBlocks = new LinkedList<Block>    ();  
		}

		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
			
			returnValue.add(Window.guiFactory.createScopeInputMethod("Class Scope:", scope));
			returnValue.add(Window.guiFactory.createNameInputMethod("Class name:", name));
			
			return returnValue;
		}

		public Package getPackage()
		{
			return pack4ge;
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
	}
	

	public static final class Primitive extends Type
	{
		private Primitive(String name) { super(name); }
		
		public static Primitive IntegerType = new Primitive("int");
		public static Primitive DoubleType  = new Primitive("double");
		public static Primitive Float       = new Primitive("float");
		public static Primitive ShortType   = new Primitive("short");
		public static Primitive ByteType    = new Primitive("byte");
		public static Primitive CharType    = new Primitive("char");
		public static Primitive LongType    = new Primitive("long");
		public static Primitive VoidType    = new Primitive("void");
		
		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
			
			Window.guiFactory.createNameInputMethod("Class name:", name);
			
			return returnValue;
		}
	}
}
