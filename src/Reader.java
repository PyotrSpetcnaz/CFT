import java.io.*;
import java.util.ArrayList;

public class Reader {

    protected static ArrayList<Integer> integerValues = null;
    protected static ArrayList<String> stringValues = null;

    public static boolean readIntFromFile(String fileName) throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            integerValues = new ArrayList<>(100);

            while (reader.ready()){
                integerValues.add(Integer.parseInt(reader.readLine()));
            }
            reader.close();
        } catch (FileNotFoundException e){
            return false;
        }
        return true;
    }

    public static boolean readStringsFromFile(String fileName) throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            stringValues = new ArrayList<>(100);

            while (reader.ready()){
                stringValues.add(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e){
            return false;
        }
        return true;
    }

    public static void output(String fileName, int type){
        try {
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
        } catch (IOException e){
            System.out.println("Ошибка при выводе в файл.");
            return;
        }
    }

    public static void outputBackwards(String fileName, int type){
        try {
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
        } catch (IOException e){
            System.out.println("Ошиюка при выводе в файл." );
            return;
        }
    }
}
