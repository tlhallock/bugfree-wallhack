package poc.ide.code.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import poc.ide.code.Block;
import poc.ide.code.Break;
import poc.ide.code.Clazz;
import poc.ide.code.Code;
import poc.ide.code.CompilationUnit;
import poc.ide.code.Continue;
import poc.ide.code.DoWhile;
import poc.ide.code.EmptyStatement;
import poc.ide.code.For;
import poc.ide.code.Function;
import poc.ide.code.Generic;
import poc.ide.code.If;
import poc.ide.code.Import;
import poc.ide.code.Label;
import poc.ide.code.Name;
import poc.ide.code.Package;
import poc.ide.code.Throw;
import poc.ide.code.Try;
import poc.ide.code.While;
import poc.ide.code.util.CodeGeneratorFilters.CodeGeneratorFilter;
import poc.ide.gui.Window;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;

public class CodeGenerators
{
	public static final List<CodeGenerator<? extends Code>> GENERATORS = new LinkedList<>();
	
	public static List<CodeGenerator<? extends Code>> getGenerators(CodeGeneratorFilter filter)
	{
		List<CodeGenerator<? extends Code>> returnValue = new LinkedList<>();
		
		for (CodeGenerator<? extends Code> gen : GENERATORS)
		{
			returnValue.add(gen);
		}
		
		return returnValue;
	}
	
	
	
	
	public interface CodeGenerator<T extends Code>
	{
		T createCode(Code parent, Map<String, Object> params);
		Class<T> getImpl();
		String getLabel();
	}
	
	// Declaration
	// Assignment
	// Return
	// switch
	// primitives
	
	
	public static final CodeGenerator<Clazz> Clazz_GENERATOR = new CodeGenerator<Clazz>()
	{
		@Override
		public Clazz createCode(Code parent, Map<String, Object> params)
		{
			return new Clazz((CompilationUnit) parent);
		}

		@Override
		public Class<Clazz> getImpl()
		{
			return Clazz.class;
		}

		@Override
		public String getLabel()
		{
			return "class";
		}
	};
	static { GENERATORS.add(Clazz_GENERATOR); }
	

	public static final CodeGenerator<Block> Block_GENERATOR = new CodeGenerator<Block>()
	{
		@Override
		public Block createCode(Code parent, Map<String, Object> params)
		{
			return new Block(parent);
		}

		@Override
		public Class<Block> getImpl()
		{
			return Block.class;
		}

		@Override
		public String getLabel()
		{
			return "block";
		}
	};
	static { GENERATORS.add(Block_GENERATOR); }
	

	public static final CodeGenerator<CompilationUnit> CompilationUnit_GENERATOR = new CodeGenerator<CompilationUnit>()
	{
		public CompilationUnit createCode(Code parent, Map<String, Object> params)
		{
			return new CompilationUnit((Package) parent);
		}

		@Override
		public Class<CompilationUnit> getImpl()
		{
			return CompilationUnit.class;
		}

		@Override
		public String getLabel()
		{
			return "compilation unit";
		}
	};
	static { GENERATORS.add(CompilationUnit_GENERATOR); }

	public static final CodeGenerator<Continue> Continue_GENERATOR = new CodeGenerator<Continue>()
	{
		@Override
		public Continue createCode(Code parent, Map<String, Object> params)
		{
			return new Continue(parent);
		}

		@Override
		public Class<Continue> getImpl()
		{
			return Continue.class;
		}

		@Override
		public String getLabel()
		{
			return "continue";
		}
	};
	static { GENERATORS.add(Continue_GENERATOR); }



	public static final CodeGenerator<Break> Break_GENERATOR = new CodeGenerator<Break>()
	{
		@Override
		public Break createCode(Code parent, Map<String, Object> params)
		{
			return new Break(parent);
		}

		@Override
		public Class<Break> getImpl()
		{
			return Break.class;
		}

		@Override
		public String getLabel()
		{
			return "break";
		}
	};
	static { GENERATORS.add(Break_GENERATOR); }


	public static final CodeGenerator<DoWhile> DoWhile_GENERATOR = new CodeGenerator<DoWhile>()
	{
		@Override
		public DoWhile createCode(Code parent, Map<String, Object> params)
		{
			return new DoWhile(parent);
		}

		@Override
		public Class<DoWhile> getImpl()
		{
			return DoWhile.class;
		}

		@Override
		public String getLabel()
		{
			return "do {...} while";
		}
	};
	static { GENERATORS.add(DoWhile_GENERATOR); }

	

	public static final CodeGenerator<EmptyStatement> EmptyStatement_GENERATOR = new CodeGenerator<EmptyStatement>()
	{
		@Override
		public EmptyStatement createCode(Code parent, Map<String, Object> params)
		{
			return new EmptyStatement(parent);
		}

		@Override
		public Class<EmptyStatement> getImpl()
		{
			return EmptyStatement.class;
		}

		@Override
		public String getLabel()
		{
			return ";";
		}
	};
	static { GENERATORS.add(EmptyStatement_GENERATOR); }


	public static final CodeGenerator<For> For_GENERATOR = new CodeGenerator<For>()
	{
		@Override
		public For createCode(Code parent, Map<String, Object> params)
		{
			return new For(parent);
		}

		@Override
		public Class<For> getImpl()
		{
			return For.class;
		}

		@Override
		public String getLabel()
		{
			return "for (;;)";
		}
	};
	static { GENERATORS.add(For_GENERATOR); }


	public static final CodeGenerator<Function> Function_GENERATOR = new CodeGenerator<Function>()
	{
		@Override
		public Function createCode(Code parent, Map<String, Object> params)
		{
			return new Function(parent);
		}

		@Override
		public Class<Function> getImpl()
		{
			return Function.class;
		}

		@Override
		public String getLabel()
		{
			return "function";
		}
	};
	static { GENERATORS.add(Function_GENERATOR); }


	public static final CodeGenerator<Generic> Generic_GENERATOR = new CodeGenerator<Generic>()
	{
		@Override
		public Generic createCode(Code parent, Map<String, Object> params)
		{
			return new Generic(parent);
		}

		@Override
		public Class<Generic> getImpl()
		{
			return Generic.class;
		}

		@Override
		public String getLabel()
		{
			return "generic";
		}
	};
	static { GENERATORS.add(Generic_GENERATOR); }


	public static final CodeGenerator<If> If_GENERATOR = new CodeGenerator<If>()
	{
		@Override
		public If createCode(Code parent, Map<String, Object> params)
		{
			return new If(parent);
		}

		@Override
		public Class<If> getImpl()
		{
			return If.class;
		}

		@Override
		public String getLabel()
		{
			return "if";
		}
	};
	static { GENERATORS.add(If_GENERATOR); }


	public static final CodeGenerator<Import> Import_GENERATOR = new CodeGenerator<Import>()
	{
		@Override
		public Import createCode(Code parent, Map<String, Object> params)
		{
			return new Import(parent, "java.lang.util.*");
		}

		@Override
		public Class<Import> getImpl()
		{
			return Import.class;
		}

		@Override
		public String getLabel()
		{
			return "import";
		}
	};
	static { GENERATORS.add(Import_GENERATOR); }


	public static final CodeGenerator<Label> Label_GENERATOR = new CodeGenerator<Label>()
	{
		@Override
		public Label createCode(Code parent, Map<String, Object> params)
		{
			return new Label(parent, null);
		}

		@Override
		public Class<Label> getImpl()
		{
			return Label.class;
		}

		@Override
		public String getLabel()
		{
			return "label";
		}
	};
	static { GENERATORS.add(Label_GENERATOR); }


	public static final CodeGenerator<Name> Name_GENERATOR = new CodeGenerator<Name>()
	{
		@Override
		public Name createCode(Code parent, Map<String, Object> params)
		{
			return new Name(parent);
		}

		@Override
		public Class<Name> getImpl()
		{
			return Name.class;
		}

		@Override
		public String getLabel()
		{
			return "name";
		}
	};
	static { GENERATORS.add(Name_GENERATOR); }


	public static final CodeGenerator<Package> Package_GENERATOR = new CodeGenerator<Package>()
	{
		@Override
		public Package createCode(Code parent, Map<String, Object> params)
		{
			Project currentProject = Window.getWindow().getCurrentProject();
			FsLocation defaultSourceDir = currentProject.getDefaultSourceDir();
			return new Package(defaultSourceDir);
		}

		@Override
		public Class<Package> getImpl()
		{
			return Package.class;
		}

		@Override
		public String getLabel()
		{
			return "package";
		}
	};
	static { GENERATORS.add(Package_GENERATOR); }


	public static final CodeGenerator<Throw> Throw_GENERATOR = new CodeGenerator<Throw>()
	{
		@Override
		public Throw createCode(Code parent, Map<String, Object> params)
		{
			return new Throw(parent);
		}

		@Override
		public Class<Throw> getImpl()
		{
			return Throw.class;
		}

		@Override
		public String getLabel()
		{
			return "throw";
		}
	};
	static { GENERATORS.add(Throw_GENERATOR); }


	public static final CodeGenerator<Try> Try_GENERATOR = new CodeGenerator<Try>()
	{
		@Override
		public Try createCode(Code parent, Map<String, Object> params)
		{
			return new Try(parent);
		}

		@Override
		public Class<Try> getImpl()
		{
			return Try.class;
		}

		@Override
		public String getLabel()
		{
			return "try";
		}
	};
	static { GENERATORS.add(Try_GENERATOR); }


	public static final CodeGenerator<While> While_GENERATOR = new CodeGenerator<While>()
	{
		@Override
		public While createCode(Code parent, Map<String, Object> params)
		{
			return new While(parent);
		}

		@Override
		public Class<While> getImpl()
		{
			return While.class;
		}

		@Override
		public String getLabel()
		{
			return "while";
		}
	};
	static { GENERATORS.add(While_GENERATOR); }
}
