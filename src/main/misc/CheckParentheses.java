package main.misc;

import main.datastructures.lists.LinkedList;
import main.datastructures.stack.MyStack;

import java.util.Map;

public class CheckParentheses {

    // checks a given String whether an opening parenthesis is followed by a closing parenthesis
    // crosswise placement of opening and closing parentheses is not allowed
    public static void main(String[] args) {

        String pattern = "(<>){}_laksdjf{asjf}";
        MyStack stack = new LinkedList();

        Map<String, String> parenMatch = Map.of(
                "(", ")",
                "[", "]",
                "{", "}",
                "<", ">"
        );

        for(int i = 0; i < pattern.length(); i++) {
            String character = pattern.substring(i, i+1);
            if(parenMatch.containsKey(character)) {
                stack.push(character);
            } else if (parenMatch.containsValue(character)) {
                String lastParen = stack.pop();
                boolean valid = lastParen != null && parenMatch.get(lastParen).equals(character);
                if (!valid) {
                    System.out.println("Not valid.");
                    return;
                }
            }
        }

        if(!stack.isEmpty()) {
            System.out.println("Not valid. Missing closing parentheses.");
        } else {
            System.out.println("Expression is valid.");
        }

    }
}
