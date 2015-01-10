package poc.ide.code;

import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public abstract class Type extends Code
{
	protected Name name;

	public Type(Code parent)
	{
		super(parent);
	}
	
	public Type(Code parent, String name)
	{
		super(parent);
		this.name = new Name(this, name);
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


	public static class Primitive extends Type
	{
		protected Primitive(String name) { super(null, name); }
		
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
		public void appendInputs(List<InputMethod<? extends Code>> list)
		{
			list.add(Window.getWindow().getGuiFactory().createNameInputMethod("Class name:", name));
		}
	}
}
