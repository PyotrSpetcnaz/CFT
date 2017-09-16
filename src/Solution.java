import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        if (args.length < 4){
            System.out.println("Недостаточное количество ключей.");
            return;
        }
        switch (args[2]){
            case "-i":
                try {
                    while(!Reader.readIntFromFile(args[0]))
                    {
                        System.out.println("Входной файл с именем \"" + args[0] + "\" не найден, введите другое имя: ");
                        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                        try {
                            args[0] = userInput.readLine();
                        } catch (IOException ex){
                            System.out.println("Ошибка ввода");
                        }
                    }
                } catch (IOException e){
                    System.out.println("Ошибка ввода во входном файле.");
                    return;
                } catch (NumberFormatException e){
                    System.out.println("Ошибка ввода во входном файле.");
                    return;
                }
                Sorter.sortIntegers();
                switch (args[3]){
                    case "-a": Reader.output(args[1], 0);
                        break;
                    case "-d": Reader.outputBackwards(args[1], 0);
                        break;
                    default:
                        System.out.println("Неизвестные ключи.");
                        return;
                }
                System.out.println("Сортировка выполнена успешно! Результат в файле \"" + args[1] + "\"");
                break;
            case "-s":
                try {
                    while(!Reader.readStringsFromFile(args[0])){
                        System.out.println("Входной файл с именем \"" + args[0] + "\" не найден, введите другое имя: ");
                        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                        try {
                            args[0] = userInput.readLine();
                        } catch (IOException ex){
                            System.out.println("Ошибка ввода");
                        }
                    }
                } catch (FileNotFoundException e){
                    System.out.println("Входной файл с таким именем не найден.");
                } catch (IOException e){
                    System.out.println("Ошибка ввода во входном файле.");
                }
                Sorter.sortStrings();
                switch (args[3]) {
                    case "-a":
                        Reader.output(args[1], 1);
                        break;
                    case "-d":
                        Reader.outputBackwards(args[1], 1);
                        break;
                    default:
                        System.out.println("Неизвестные ключи.");
                        return;
                }
                System.out.println("Сортировка выполнена успешно! Результат в файле \"" + args[1] + "\"");
                break;
            default:
                System.out.println("Неизвестные ключи.");
        }
    }
}
