import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserData {
    String path;
    List<String> fileNames = null;

    public UserData(){}
    public UserData(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path of directory with xml files: ");
        String path = sc.nextLine();
        setPath(path);
        fileNames = readDirectory(path);
        System.out.println("In directory '"+ getPath() + "' founded " + fileNames.size() + "xml files!");
        System.out.println("Do you want to continue? yes/no");
        String answer = sc.nextLine();
        if ((answer.toLowerCase().equals("yes")) || (answer.toLowerCase().equals("y"))){
            return fileNames;
        } else {
            System.exit(0);
        }
        System.exit(0);
        return null;
    }

    public List<String> readDirectory(String path){
        try {
            File dir = new File(path);
            File []arrFiles = dir.listFiles();
            List<File> lst = Arrays.asList(arrFiles);
            List<String> fileNames = new ArrayList<>();
            for (File file : lst){
                if (file.getName().endsWith(".xml")){
                    fileNames.add(path + "\\" + file.getName());
                }
            }
            if (fileNames.size() == 0){
                System.out.println("In the directory '" + path + "' no xml files founded!");
                System.exit(0);
            }
            return fileNames;
        } catch (java.lang.NullPointerException e){
            System.out.println("Wrong directory! Please, try again..");
            System.out.println("Do yo wanna try again ? yes/no:");
            Scanner sc = new Scanner(System.in);
            String data = sc.nextLine();
            if ((data.toLowerCase().equals("yes")) || (data.toLowerCase().equals("y"))){
                this.getData();
            } else {
                System.exit(0);
            }
            System.exit(0);
            return null;
        }
    }

    public void printFiles(){
        for (String file : fileNames){
            System.out.println(file);
        }
    }

}
