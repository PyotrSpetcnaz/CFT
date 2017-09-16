public class Sorter extends Reader{

    public static void sortIntegers(){
        for (int j = 1; j < integerValues.size(); j++) {
            int key = integerValues.get(j);
            int i = j - 1;
            while (i >= 0 && integerValues.get(i) > key){
                integerValues.set(i + 1, integerValues.get(i));
                i--;
            }
            integerValues.set(i + 1, key);
        }
    }

    public static void sortStrings(){
        for (int j = 1; j < stringValues.size(); j++) {
            String key = stringValues.get(j);
            int i = j - 1;
            while (i >= 0 && stringValues.get(i).compareTo(key) > 0){
                stringValues.set(i + 1, stringValues.get(i));
                i--;
            }
            stringValues.set(i + 1, key);
        }
    }
}