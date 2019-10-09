import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserData {
    String path;

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

    public void getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the directory with xml files: ");
        String path = sc.nextLine();
        setPath(path);
        System.out.println("In directory '"+ getPath() + "' founded " + readDirectory(path).size() + " files!");
    }

    public List<String> readDirectory(String path){
        try {
            File dir = new File(path);
            File []arrFiles = dir.listFiles();
            List<File> lst = Arrays.asList(arrFiles);
            List<String> fileNames = new ArrayList<String>();
            for (File file : lst){
                fileNames.add(file.getName());
            }
            return fileNames;
        } catch (java.lang.NullPointerException e){
            System.out.println("Wrong directory! Please, try again..");
            System.out.println("Do yo wanna try again ? Enter yes/no:");
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

}
