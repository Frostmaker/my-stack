package org.kaguya;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private boolean checkBrackets(String string) {
        char[] char_array = string.toCharArray();
        Stack stack = new Stack();
        char ch;

        for (int i = 0; i < string.length(); i++) {
            ch = char_array[i];
            if (Character.isMirrored(ch)) {
                // { [ < ( } ] > )
                if (Character.isMirrored(ch + 1) || Character.isMirrored(ch + 2)) {
                    // { [ < (
                    try {
                        stack.push((Character) ch);
                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
                    }
                } else {
                    // } ] > )
                    try {
                        Character stack_top = (Character) stack.peek();
                        if (stack_top + 1 == ch || stack_top + 2 == ch) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } catch (Throwable e) {
//                        System.out.println(e.getMessage());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void First() {
        String test_string1 = "{([2 - (3 + 5)] * 12) / 3} + 14";
        String test_string2 = "}14 + 13}";
        String test_string3 = "[15 + <16 - 13] - 12>";

        Assert.assertTrue(checkBrackets(test_string1));
        Assert.assertFalse(checkBrackets(test_string2));
        Assert.assertFalse(checkBrackets(test_string3));
    }

    private Stack toPolish(String string) {
        Stack stack = new Stack();
        char[] char_array = string.toCharArray();
        for (int i = 0; i < char_array.length; i++) {
            if (char_array[i] == ' ') {
            } else if (Character.isDigit(char_array[i])) {
                if ()
            } else if (char_array[i] == '+' || char_array[i] == '-' || char_array[i] == '*' || char_array[i] == '/') {

            }
        }
        return stack;
    }


    private double solvePolish(Stack polish_stack) {

        return .0;
    }

    @Test
    public void Second() {
        Stack stack = new Stack();
        String string = "5 - (2 + 2)";
        if (checkBrackets(string)) {
            System.out.println("check");
        }
    }
}