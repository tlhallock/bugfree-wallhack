package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.code.Type.Primitive.BooleanType;
import poc.ide.gui.InputMethod;

public abstract class Expression<T extends Type> extends CodeTree
{
	public Expression(CodeTree parent)
	{
		super(parent);
	}
	
	public static final class BooleanExpression extends Expression<BooleanType>
	{
		boolean value;
		
		private BooleanExpression(CodeTree parent, boolean value) { super(parent); this.value = value; }
		
		@Override
		public StringBuilder appendText(StringBuilder builder, int depth)
		{
			return builder.append(value);
		}

		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			throw new RuntimeException("boolean not implemented");
		}
		
		public static final BooleanExpression getTrue( CodeTree p) { return new BooleanExpression(p, true);  }
		public static final BooleanExpression getFalse(CodeTree p) { return new BooleanExpression(p, false); }
	}
	
	public static class FunctionCall<T extends Type> extends Expression<T>
	{
		public FunctionCall(CodeTree parent)
		{
			super(parent);
		}

		@Override
		public StringBuilder appendText(StringBuilder builder, int depth)
		{
			return builder.append("function call");
		}

		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			return Collections.emptyList();
		}
	}
	
	public static class Null<T extends Clazz> extends Expression<T>
	{
		public Null(CodeTree parent)
		{
			super(parent);
		}

		@Override
		public StringBuilder appendText(StringBuilder builder, int depth)
		{
			return builder.append("null");
		}

		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			return Collections.emptyList();
		}
	}
	
	public static class New<T extends Clazz> extends Expression<T>
	{
		private T t;
		private Function f;
		
		public New(CodeTree parent)
		{
			super(parent);
		}

		@Override
		public StringBuilder appendText(StringBuilder builder, int depth)
		{
			return builder.append("new ");
		}

		@Override
		public List<InputMethod<? extends CodeTree>> getInputs()
		{
			return Collections.emptyList();
		}
	}
	
	public static <T extends Type> Expression<T> getDefaultExpression(T t)
	{
		return null;
	}
}
