package fileTest;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("/Users/ryan/Downloads/Code/JAVA/JavaProject/src/fileTest/test_folder");
        file.mkdir();

        File file1 = new File("/Users/ryan/Downloads/Code/JAVA/JavaProject/src/fileTest/Test.txt");
        try {
            file1.createNewFile();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
