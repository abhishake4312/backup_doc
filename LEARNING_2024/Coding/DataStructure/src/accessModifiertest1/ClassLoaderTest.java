package accessModifiertest1;

public class ClassLoaderTest {
	 public static void main(String[] args) {
	        String fileName = "//Upload_Parts_Template.xlsx";
	        System.out.println(fileName);
	        String fileName2 = "Upload_Parts_Template.xlsx";
	        System.out.println(new ClassLoaderTest().getClass().getResource(fileName));
	        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getResource(fileName2));
	    }
}
