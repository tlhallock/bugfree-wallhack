package poc.ide.gui;

import poc.ide.code.Code;
import poc.ide.code.Name;
import poc.ide.code.ScopeModifier;
import poc.ide.code.Type;
import poc.ide.code.util.CodeGenerators.CodeGenerator;
import poc.ide.proj.Project;

public abstract class GuiFactory
{
	public abstract                  Viewer       createViewer();
	public abstract                  Selector     createSelector(Viewer v);
	public abstract                  ClassViewer  createClassViewer();
	
	public abstract                  InputMethod<Name>          createNameInputMethod (String label, Name callback);
	public abstract                  InputMethod<ScopeModifier> createScopeInputMethod(String string, ScopeModifier scope);
	public abstract <T extends Code> InputMethod<T>         createChildInputMethod(String string, T child);
	public abstract                  GeneratorInput             createGeneratorInputMethod(Code parent, Code child, CodeGenerator<? extends Code> generator); 
	
	
	public void getLabelInput() {}
	public void getBooleanInput() {}
	public void getVariableInput(Type t) {}
}
