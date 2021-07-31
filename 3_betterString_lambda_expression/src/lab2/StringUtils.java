/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author AsmaaAbdelkader
 */
public class StringUtils {
    public static String betterString(String string1 , String string2 , BiPredicate<String , String> fn){
        if(fn.test(string1, string2))
            return string1;
        else
            return string2;
    }
    
    
    public static boolean isAlphabet(String s, Predicate<Character> fn) {
        boolean isAlpha = true;
        for (var ch : s.toCharArray()) {
            if (!fn.test(ch)) 
                isAlpha = false;
            
        }
        return isAlpha;
    }
}
