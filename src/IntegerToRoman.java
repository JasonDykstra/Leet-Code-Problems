import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    // My first solution
    public String intToRoman(int num) {
        // My first appraoch will be to modulo the number and start replacing it with roman numerals

        // Define the string to output to
        String result = "";

        // Start with M (1000)
        while(num >= 1000){
            result += "M";
            num -= 1000;
        }

        // Go to special case CM (900)
        while(num >= 900){
            result += "CM";
            num -= 900;
        }

        // D (500)
        while(num >= 500){
            result += "D";
            num -= 500;
        }

        // CD (400)
        while(num >= 400){
            result += "CD";
            num -= 400;
        }

        // C (100)
        while(num >= 100){
            result += "C";
            num -= 100;
        }

        // XC (90)
        while(num >= 90){
            result += "XC";
            num -= 90;
        }

        // L (50)
        while(num >= 50){
            result += "L";
            num -= 50;
        }

        // XL (40)
        while(num >= 40){
            result += "XL";
            num -= 40;
        }

        // X (10)
        while(num >= 10){
            result += "X";
            num -= 10;
        }

        // IX (9)
        while(num >= 9){
            result += "IX";
            num -= 9;
        }

        // V (5)
        while(num >= 5){
            result += "V";
            num -= 5;
        }

        // IV (4)
        while(num >= 4){
            result += "IV";
            num -= 4;
        }

        // I (1)
        while(num != 0){

            result += "I";
            num -= 1;
            System.out.println(num);
        }

        return result;
    }

    /*
    Runtime: 14 ms, faster than 20.40% of Java online submissions for Integer to Roman.
    Memory Usage: 39.2 MB, less than 39.90% of Java online submissions for Integer to Roman.
     */

    // As expected, this solution was very slow. While writing it, I came up with an idea that does
    // practically the same thing, just more compact with a linked hashmap.



    // My second solution (a cleaner version of my first solution):
    public String intToRoman2(int num) {
        // My second appraoch will attempt to use a linked hashmap
        String result = "";

        LinkedHashMap<Integer, String> romanDictionary = new LinkedHashMap<Integer, String>();

        romanDictionary.put(1000, "M");
        romanDictionary.put(900, "CM");
        romanDictionary.put(500, "D");
        romanDictionary.put(400, "CD");
        romanDictionary.put(100, "C");
        romanDictionary.put(90, "XC");
        romanDictionary.put(50, "L");
        romanDictionary.put(40, "XL");
        romanDictionary.put(10, "X");
        romanDictionary.put(9, "IX");
        romanDictionary.put(5, "V");
        romanDictionary.put(4, "IV");
        romanDictionary.put(1, "I");

        // While the number is not 0, translate it to roman numerals!
        // Starting place
        for(Map.Entry m : romanDictionary.entrySet()){
            // While the number is greater than the divisor, convert that part to roman numerals
            while(num >= (int)(m.getKey())){
                result += m.getValue();
                num -= (int)(m.getKey());
            }
        }

        return result;
    }

    /*
    Runtime: 8 ms, faster than 34.89% of Java online submissions for Integer to Roman.
    Memory Usage: 38.5 MB, less than 78.11% of Java online submissions for Integer to Roman.
     */

    
}
