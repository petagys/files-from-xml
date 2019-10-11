import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Action {

    public static void writeTextToFile(String text, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        new File(fileName)));
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static void createDirectory(String dirName){
        File theDir = new File(dirName);

        if (!theDir.exists()) {
            System.out.println("Creating directory: " + theDir.getName());
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                System.out.println("Can not create directory!");
            }
            if(result) {
                System.out.println("Directory " + theDir + " is successfully created!");
            }
        }
    }
}
