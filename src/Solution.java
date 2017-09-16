import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        switch (args[2]){
            case "-i":
                try {
                    Reader.readIntFromFile(args[0]);
                } catch (FileNotFoundException e){
                    System.out.println("Входной файл с именем \"" + args[0] + "\" не найден, введите другое имя: ");
                    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                    tryInput:
                    try {
                        args[0] = userInput.readLine();
                    } catch (IOException ex){
                        System.out.println("Ошибка ввода, введите другое имя: ");
                        GOTO tryInput;
                    }
                    GOTO tryRead;
                } catch (IOException e){
                    System.out.println("Ошибка ввода во входном файле.");
                    return;
                } catch (NumberFormatException e){
                    System.out.println("Ошибка ввода во входном файле.");
                    return;
                }
                Sorter.sortIntegers();
                try {
                    switch (args[3]){
                        case "-a": Reader.output(args[1], 0);
                        break;
                        case "-d": Reader.outputBackwards(args[1], 0);
                        break;
                    }
                } catch (IOException e){
                    System.out.println("Ошибка при выводе в файл.");
                    return;
                }
                break;
            case "-s":
                try {
                    Reader.readStringsFromFile(args[0]);
                } catch (FileNotFoundException e){
                    System.out.println("Входной файл с таким именем не найден.");
                } catch (IOException e){
                    System.out.println("Ошибка ввода во входном файле.");
                }
                Sorter.sortStrings();
                try {
                    switch (args[3]){
                        case "-a": Reader.output(args[1], 1);
                        break;
                        case "-d": Reader.outputBackwards(args[1], 1);
                        break;
                    }
                } catch (IOException e){
                    System.out.println("Ошибка при выводе в файл.");
                }
                break;
        }
    }
}
