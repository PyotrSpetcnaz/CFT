import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    protected static ArrayList<Integer> integerValues = null;
    protected static ArrayList<String> stringValues = null;

    public static void readIntFromFile(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        integerValues = new ArrayList<>(100);

        while (reader.ready()){
            integerValues.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();
    }

    public static void readStringsFromFile(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        stringValues = new ArrayList<>(100);

        while (reader.ready()){
            stringValues.add(reader.readLine());
        }
        reader.close();
    }

    public static void output(String fileName, int type) throws IOException{
        FileWriter writer = new FileWriter(fileName);
        if (type == 0) {
            for (int i :
                    integerValues) {
                writer.write(i + "\r\n");
            }
        } else if (type == 1){
            for (String s :
                    stringValues) {
                writer.write(s + "\r\n");
            }
        }
        writer.close();
    }

    public static void outputBackwards(String fileName, int type) throws IOException{
        FileWriter writer = new FileWriter(fileName);
        if (type == 0){
            for (int i = integerValues.size() - 1; i >= 0; i--) {
                writer.write(integerValues.get(i) + "\r\n");
            }
        } else if (type == 1){
            for (int i = stringValues.size() - 1; i >= 0; i--) {
                writer.write(stringValues.get(i) + "\r\n");
            }
        }
        writer.close();
    }
}
