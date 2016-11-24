/*
 * constructs files for hard drive
 * 
 * should be refactored to an interface and 
 * individual classes for types of files
 * 
 * AUTHOR: Jrobertzz
 * 11/23/2016
 */
public class File {
	static String name;
	static String extension;
	static int size;
	static GraphicalUserInterface GUI;
	public File(String fileName, GraphicalUserInterface GUIin)
	{
		GUI = GUIin;
		name = fileName.substring(0, fileName.length()-4);
		extension = fileName.substring(fileName.length()-4);
		System.out.println(name);
		System.out.println(extension);
		int type = fileType();
	}
	public int fileType()
	{
		switch(extension)
		{
			case ".txt":
				return 0;
			default:
				notRecognized();
				return -1;
		}
	}
	
	public static void notRecognized()
	{
		String input = String.format("print %s is not a recognized file extension", extension);
		GUI.Terminator(input);
	}
	
	public static void textFile()
	{
		
	}
}
