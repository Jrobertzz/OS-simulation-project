import java.math.BigInteger;

public class MemTest {
		public MemTest(Memory RAM, GraphicalUserInterface GUI){
			
			Interpretor mem_interpretor = new Interpretor();
			
			byte[] intTest = mem_interpretor.intToByteArray(5435631);
			RAM.SET(intTest, 10, intTest.length);
			System.out.println("int test		" + mem_interpretor.byteArrayToInt(RAM.GET(10, intTest.length)));
			
			byte[] charTest = mem_interpretor.charToByteArray('z');
			RAM.SET(charTest, 100, charTest.length);
			System.out.println("char test		" + mem_interpretor.byteArrayToChar(charTest));
			
			byte[] stringTest = mem_interpretor.stringToByteArray("Hello World!");
			RAM.SET(stringTest, 200, stringTest.length);
			System.out.println("string test		" + mem_interpretor.byteArrayToString(stringTest));
			
			byte[] doubleTest = mem_interpretor.doubleToByteArray(3.1415);
			RAM.SET(doubleTest, 300, doubleTest.length);
			System.out.println("double test		" + mem_interpretor.byteArrayToDouble(doubleTest));

			byte[] floatTest = mem_interpretor.floatToByteArray((float)6.283);
			RAM.SET(floatTest, 400, floatTest.length);
			System.out.println("float test		" + mem_interpretor.byteArrayToFloat(floatTest));

			byte[] shortTest = mem_interpretor.shortToByteArray((short)11);
			RAM.SET(shortTest, 500, shortTest.length);
			System.out.println("short test		" + mem_interpretor.byteArrayToShort(shortTest));

			byte[] longTest = mem_interpretor.longToByteArray((long)19);
			RAM.SET(longTest, 600, longTest.length);
			System.out.println("long test		" + mem_interpretor.byteArrayToLong(longTest));

			byte[] booleanTest = mem_interpretor.booleanToByteArray(true);
			RAM.SET(booleanTest, 700, booleanTest.length);
			System.out.println("boolean test		" + mem_interpretor.byteArrayToBoolean(booleanTest));
			
			//testing printing to commandline, uncomment to see
			//GUI.command_pane.setText("double test		" + RAM.byteArrayToDouble(doubleTest));
			//GUI.actionPerformed(null);
		}
}
