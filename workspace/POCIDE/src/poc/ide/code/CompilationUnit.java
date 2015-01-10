package poc.ide.code;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import poc.ide.code.ScopeModifier.Scoping;
import poc.ide.code.util.CodeGeneratorFilters;
import poc.ide.code.util.CodeGeneratorFilters.CodeGeneratorFilter;
import poc.ide.code.util.CodeGeneratorFilters.OrFilter;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;
import poc.ide.main.Serializer;
import poc.ide.proj.FsLocation;

public class CompilationUnit extends Code
{
	private Package pack4ge;
	
	private List<Import> imports;
	
	private List<Clazz> types;
	
	public CompilationUnit(Package pack4ge)
	{
		super(pack4ge);
		
		this.pack4ge = pack4ge;
		imports = new LinkedList<>();
		types = new LinkedList<>();
		
		types.add(new Clazz(this, "Foobar"));
	}
	
	public Package getPackage()
	{
		return pack4ge;
	}
	
	public Clazz getPrimaryClass()
	{
		for (Clazz clazz : types)
		{
			if (clazz.getScopeModifier().getScope().equals(Scoping.Public))
			{
				return clazz;
			}
		}
		
		return types.get(0);
		
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		for (Import i : imports)
		{
			i.appendText(builder, depth);
		}

		for (Clazz t : types)
		{
			t.appendText(builder, depth);
		}
		
		return builder;
	}


	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();

		for (Import i : imports)
		{
			returnValue.addAll(i.getInputs());
		}

		for (Clazz t : types)
		{
			Window.getWindow().getGuiFactory().createChildInputMethod(t.getName(), t);
		}
		
		return returnValue;
	}
	

	public CodeGeneratorFilter getFilter(Code prev)
	{
		 OrFilter orFilter = new CodeGeneratorFilters.OrFilter();
		 
		 orFilter.add(CodeGeneratorFilters.getTypeFilter(Clazz.implementation));
		 orFilter.add(CodeGeneratorFilters.getTypeFilter(Import.implementation));
		 
		 return orFilter;
	}

	private boolean  checkNewPublicClassError(Clazz t)
	{
		if (!t.isPublic())
		{
			return false;
		}
		for (Clazz o : types)
		{
			if (!o.isPublic())
			{
				continue;
			}
			return true;
		}
		return false;
	}
	
	public void newCodeAdded(Code prev, Code newCode)
	{
		if (newCode instanceof Clazz)
		{
			if (checkNewPublicClassError((Clazz) newCode))
			{
				System.err.println("Two classes are public in the same compilation unit.");
			}
			types.add((Clazz) newCode);
		}
		else if (newCode instanceof Import)
		{
			imports.add((Import) newCode);
		}
		else
		{
			throw new RuntimeException("Can't handle type " + newCode.getClass().getName());
		}
	}
	
	public void save() throws IOException
	{
		FsLocation defaultSourceDir = Window.getWindow().getCurrentProject().getDefaultSourceDir();
		File file = Serializer.getJsonFile(defaultSourceDir, pack4ge, this);
		Serializer.write(this, file);
	}
}
