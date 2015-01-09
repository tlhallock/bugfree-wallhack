package poc.ide.awt;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import poc.ide.code.CodeTree;
import poc.ide.code.Name;
import poc.ide.code.ScopeModifier;
import poc.ide.code.ScopeModifier.Scoping;
import poc.ide.gui.ClassViewer;
import poc.ide.gui.GuiFactory;
import poc.ide.gui.InputMethod;
import poc.ide.gui.Selector;
import poc.ide.gui.Viewer;
import poc.ide.proj.Project;

public class AwtGuiFactory extends GuiFactory
{
	@Override
	public Viewer createViewer()
	{
		AwtViewer viewer = new AwtViewer();
		AwtUtil.createWindow("Viewer", viewer.getTextArea());
		return viewer;
	}

	@Override
	public Selector createSelector()
	{
		JFrame createWindow = AwtUtil.createWindow("Selector");
		JRootPane rootPane = createWindow.getRootPane();
		AwtSelector selector = new AwtSelector(rootPane);
		return selector;
	}

	@Override
	public InputMethod<Name> createNameInputMethod(String label, Name callback)
	{
		return new AwtNameInput(label, callback);
	}

	@Override
	public InputMethod<ScopeModifier> createScopeInputMethod(String string, ScopeModifier scope)
 {
		return new AwtEnumeratedInput<ScopeModifier, ScopeModifier.Scoping>(
				string,
				scope,
				AwtEnumeratedInput.getNames(Scoping.values()),
				scope.getScope().name()) {
			@Override
			protected ScopeModifier.Scoping getCode(String name) {
				return AwtEnumeratedInput.getValue(Scoping.values(), name);
			}

			@Override
			public void assign()
			{
				code.setScope(getCode());
			}
		};
	}

	@Override
	public <T extends CodeTree> InputMethod<T> createChildInputMethod(String string, T child)
	{
		return new AwtSelectorInput<T>(string, child);
	}

	@Override
	public ClassViewer createClassViewer(Project project)
	{
		AwtClassViewer awtClassViewer = new AwtClassViewer(project);
		AwtUtil.createWindow("Class View", awtClassViewer.getComponent());
		return awtClassViewer;
	}
}
