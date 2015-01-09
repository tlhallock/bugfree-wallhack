package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.code.Type.Clazz;
import poc.ide.code.Type.Primitive.BooleanType;
import poc.ide.gui.InputMethod;

public abstract class Expression<T extends Type> extends CodeTree
{
	public static final class BooleanExpression extends Expression<BooleanType>
	{
		boolean value;
		
		private BooleanExpression(boolean value) { this.value = value; }
		
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
		
		public static final BooleanExpression TRUE = new BooleanExpression(true);
		public static final BooleanExpression FALSE = new BooleanExpression(false);
	}
	
	public static class FunctionCall<T extends Type> extends Expression<T>
	{
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
	
	public static <T extends Type> Expression<T> getDefaultExpression(T t)
	{
		return null;
	}
}
