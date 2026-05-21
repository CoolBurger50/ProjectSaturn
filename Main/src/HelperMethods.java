import java.util.*;
import java.io.*;


public class HelperMethods {
    public static String getPathLocation() {
        ArrayList<String> config = HelperMethods.getFileData("Main/Config");
        if (!config.get(1).equals("true")) {
            return "";
        }
        return config.get(0);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
