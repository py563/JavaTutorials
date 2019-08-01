import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class luckynumbers{
    // credit to python version by github user @informaticienzero
    //Java version of codingame luckynumbers program a number is lucky if it has 6 or 8 but not both.
    public static void main(String[] args) {
        int l = 1;
        int h = 200;
        if (l == h) {
            //We know that if they are the same, no need to make calculus.
            String num = Integer.toString(l);
            if ((num.contains("6") ) ^ (num.contains("8")))    
                System.out.println(1);
            else
                System.out.println(0);
        }else{
            int luckyUntilL = count(l);
            int luckyUntilh = count(h + 1);
            System.out.println(luckyUntilh - luckyUntilL);
        }
    }
    public static int count(int number) {
    /***
    Count the lucky numbers from 0 to number with a fast mathematic range.
    ***/
        List<Integer> digits = get_digits(number);
        int pow_10 = digits.size() - 1;
        Map<Integer, Integer> possibilities = calculate_possibilities(pow_10 + 1);
        int lucky_numbers = 0;
        
        boolean found_lucky_digit = false;
        int lucky_digit = -1;

        for (int digit : digits) {
            if (found_lucky_digit == false){
                //We're in the classic case.
                if (digit == 7)
                    lucky_numbers += 6 * possibilities.get(pow_10) + Math.pow(9,pow_10);
                else if (digit == 8)
                    lucky_numbers += 7 * possibilities.get(pow_10) + Math.pow(9,pow_10);
                else if (digit == 9)
                    lucky_numbers += 7 * possibilities.get(pow_10) + 2 * Math.pow(9,pow_10);
                else
                    lucky_numbers += digit * possibilities.get(pow_10);
            } else {
                //Things change now that we know we have a lucky digit before us.
                if (digit == 6) {
                    lucky_numbers += 6 * Math.pow(9,pow_10);
                    if (found_lucky_digit && lucky_digit != 6) {
                        //We'll find no more lucky numbers.
                        return lucky_numbers;
                    }
                } else if (digit == 7){
                    if (lucky_digit == 6) { 
                        lucky_numbers += 7 * Math.pow(9,pow_10);
                    } else {
                        lucky_numbers += 6 * Math.pow(9,pow_10);
                    }
                } else if (digit == 8) { 
                    lucky_numbers += 7 * Math.pow(9,pow_10);
                    if (found_lucky_digit && lucky_digit != 8){
                        //We'll find no more lucky numbers.
                        lucky_numbers += Math.pow(9,pow_10);
                        return lucky_numbers;
                    }
                } else if (digit == 9)
                    lucky_numbers += 8 * Math.pow(9,pow_10);
                else
                    lucky_numbers += digit * Math.pow(9,pow_10);
            }
            pow_10--;
            
            if (found_lucky_digit == false && (digit == 6 || digit == 8)){
                lucky_digit = digit;
                found_lucky_digit = true;
            }
        }
        return lucky_numbers;
    }
    public static List<Integer> get_digits(int number){
    //Gets the list of all digits of a number, from left to right.
        List<Integer> digits = new ArrayList<Integer>();
            if (number < 10){
                digits.add(number);
            }
            else {
                while(number>0){
                    digits.add(number%10);
                    number = number / 10;
                }
                Collections.reverse(digits);
            }
            //System.out.println(digits.toString());
        return digits;
    }
    public static Map<Integer,Integer> calculate_possibilities(int max){
        //Calculate the numbers of lucky numbers from 0 to 10**(max - 1)"""
        Map<Integer,Integer> possibilities = new HashMap<Integer, Integer> ();
        possibilities.put (0, 0);
        possibilities.put(1,2);
        int index = 2;
        int value = 0;
        while (index < max){
            value = 2 * (int)Math.pow(9,(index - 1)) + 8 * possibilities.get((index - 1));
            possibilities.put(index, value);
            index++;
        }
        return possibilities;
    }
 

}