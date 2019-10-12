import java.util.Scanner;

public class FileFromXmlTag {
    public static void main(String[] args) {
        try {
            int count = 1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the tag name of xml file that from you want to create file: ");
            final String TAGNAME = sc.nextLine();

            UserData userData = new UserData();
            userData.getData();
            System.out.println("Do you wanna print all files's names ? yes/no");
            String answer = sc.nextLine();
            if ((answer.toLowerCase().equals("yes")) || (answer.toLowerCase().equals("y"))) {
                userData.printFiles();
            }
            XmlRead xml = new XmlRead();
            xml.setTagName(TAGNAME);

            final String dir = "txt_files";
            final String txtName = dir + "/verse";

            Action.createDirectory(dir);

            for (String file : userData.fileNames){
                xml.setFileName(file);
                xml.getTextFromTag();
                String currFileName = txtName + "(" + String.valueOf(count) + ").txt";
                Action.writeTextToFile(xml.data, currFileName);
                System.out.println("File '" + currFileName + "' was created successfully!");
                count++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
