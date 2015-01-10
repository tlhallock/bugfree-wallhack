package poc.ide.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.ObjectMapper;

import poc.ide.code.CompilationUnit;
import poc.ide.proj.FsLocation;

public class Serializer
{
	private static final ObjectMapper mapper = new ObjectMapper();
	static
	{
		mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
		                .withFieldVisibility(Visibility.ANY)
		                .withGetterVisibility(Visibility.NONE)
		                .withSetterVisibility(Visibility.NONE)
		                .withCreatorVisibility(Visibility.NONE));
	}
	public static void write(CompilationUnit tree, File jsonLocation) throws IOException
	{
		String path = jsonLocation.getPath();
		File javaFile = new File(path.substring(0, path.lastIndexOf('.')) + ".java");
		
		try (PrintStream printStream = new PrintStream(new FileOutputStream(javaFile));)
		{
			printStream.println(tree.appendText(new StringBuilder(), 0));
		}
		
		mapper.defaultPrettyPrintingWriter().writeValue(jsonLocation, tree);
		
	}
	
	public static CompilationUnit read(File location) throws JsonProcessingException, IOException
	{
		return mapper.reader().readValue(location); 
	}
	
	public static File getJsonFile(FsLocation location, poc.ide.code.Package pack4ge, CompilationUnit unit)
	{
		return new File(location.toString() + "/" + pack4ge.toFs() +"/" + unit.getPrimaryClass().getName() + ".json");
	}
}
