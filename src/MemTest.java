import java.math.BigInteger;

public class MemTest {
		public MemTest(Memory RAM, GraphicalUserInterface GUI){
			byte[] intTest = RAM.intToByteArray(5435631);
			RAM.SET(intTest, 10, intTest.length);
			System.out.println("int test		" + RAM.byteArrayToInt(RAM.GET(10, intTest.length)));
			
			byte[] charTest = RAM.charToByteArray('z');
			RAM.SET(charTest, 100, charTest.length);
			System.out.println("char test		" + RAM.byteArrayToChar(charTest));
			
			byte[] stringTest = RAM.stringToByteArray("Hello World!");
			RAM.SET(stringTest, 200, stringTest.length);
			System.out.println("string test		" + RAM.byteArrayToString(stringTest));
			
			byte[] doubleTest = RAM.doubleToByteArray(3.1415);
			RAM.SET(doubleTest, 300, doubleTest.length);
			System.out.println("double test		" + RAM.byteArrayToDouble(doubleTest));

			byte[] floatTest = RAM.floatToByteArray((float)6.283);
			RAM.SET(floatTest, 400, floatTest.length);
			System.out.println("float test		" + RAM.byteArrayToFloat(floatTest));

			byte[] shortTest = RAM.shortToByteArray((short)11);
			RAM.SET(shortTest, 500, shortTest.length);
			System.out.println("short test		" + RAM.byteArrayToShort(shortTest));

			byte[] longTest = RAM.longToByteArray((long)19);
			RAM.SET(longTest, 600, longTest.length);
			System.out.println("long test		" + RAM.byteArrayToLong(longTest));

			byte[] booleanTest = RAM.booleanToByteArray(true);
			RAM.SET(booleanTest, 700, booleanTest.length);
			System.out.println("boolean test		" + RAM.byteArrayToBoolean(booleanTest));
			
			//testing printing to commandline, uncomment to see
			//GUI.command_pane.setText("double test		" + RAM.byteArrayToDouble(doubleTest));
			//GUI.actionPerformed(null);
		}
}
