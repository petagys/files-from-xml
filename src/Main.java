import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeTextToFile(String text, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        new File(fileName)));
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
            final String TAGNAME = "text";
            UserData userData = new UserData();
            userData.getData();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
