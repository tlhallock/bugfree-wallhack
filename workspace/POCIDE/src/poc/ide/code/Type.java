package poc.ide.code;

import java.util.HashMap;
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
		
		private final List<Declaration<? extends Type>>  variables   ;
		private final List<Function>                     functions   ;
		private final List<Type>                         parameters  ;
		private final List<Type>                         innerClasses;
		private final List<Block>                        blocks      ;
		private final List<Block>                        staticBlocks;
		
		public Clazz(String name)
		{
			super(name);
			
			pack4ge = new Package();
			
			scope = new ScopeModifier(ScopeModifier.Scoping.Public);
			
			variables    = new LinkedList<Declaration<? extends Type>> ();  
			functions    = new LinkedList<Function>                    ();  
			parameters   = new LinkedList<Type>                        ();  
			innerClasses = new LinkedList<Type>                        ();  
			blocks       = new LinkedList<Block>                       ();  
			staticBlocks = new LinkedList<Block>                       ();  
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
	

	public static class Primitive extends Type
	{
		private static HashMap<String, String> names = new HashMap<String, String>();
		protected Primitive(String name) { super(name); }
		
		public static final class IntegerType extends Primitive { public static IntegerType implementation = new IntegerType(); private IntegerType() { super("int");    } };
		public static final class DoubleType  extends Primitive { public static DoubleType  implementation = new DoubleType (); private DoubleType () { super("double"); } };
		public static final class Float       extends Primitive { public static Float       implementation = new Float      (); private Float      () { super("float");  } };
		public static final class ShortType   extends Primitive { public static ShortType   implementation = new ShortType  (); private ShortType  () { super("short");  } };
		public static final class ByteType    extends Primitive { public static ByteType    implementation = new ByteType   (); private ByteType   () { super("byte");   } };
		public static final class CharType    extends Primitive { public static CharType    implementation = new CharType   (); private CharType   () { super("char");   } };
		public static final class LongType    extends Primitive { public static LongType    implementation = new LongType   (); private LongType   () { super("long");   } };
		public static final class VoidType    extends Primitive { public static VoidType    implementation = new VoidType   (); private VoidType   () { super("void");   } };
		public static final class BooleanType extends Primitive { public static BooleanType implementation = new BooleanType(); private BooleanType() { super("boolean");} };
		
		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
			
			Window.guiFactory.createNameInputMethod("Class name:", name);
			
			return returnValue;
		}
	}
}
