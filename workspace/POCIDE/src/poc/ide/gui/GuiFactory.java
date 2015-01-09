package poc.ide.gui;

import poc.ide.code.CodeTree;
import poc.ide.code.Name;
import poc.ide.code.ScopeModifier;
import poc.ide.proj.Project;

public abstract class GuiFactory
{
	public abstract                  Viewer       createViewer();
	public abstract                  Selector     createSelector();
	public abstract                  ClassViewer  createClassViewer(Project project);
	
	public abstract                  InputMethod<Name>  createNameInputMethod (String label, Name callback);
	public abstract                  InputMethod<ScopeModifier> createScopeInputMethod(String string, ScopeModifier scope);
	public abstract <T extends CodeTree> InputMethod<T>     createChildInputMethod(String string, T child);
}
