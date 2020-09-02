package com.epam.university.java.core.task008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task008Impl implements Task008 {

    class MyStack {
        private List<Character> stack;
        private int index;

        MyStack () {
            stack = new ArrayList<>();
        }

        private void add(Character character) {
            stack.add(character);
            System.out.println("Added char " + character);
            index++;
            System.out.println(index);
        }

        private Character pop () {
            index--;
            System.out.println("Popped char " + stack.get(index));
            if (index < 0) {
                return '~';
            }
            System.out.println(index);
            return stack.get(index);
        }

        private Character peek () {
            if (index < 1) {
                return '~';
            }
            System.out.println(index);
            return stack.get(index - 1);
        }

    }


    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('{', '[', '('));
        List<Character> closeBrackets = new ArrayList<>(Arrays.asList('}', ']', ')'));
        MyStack myStack = new MyStack();

        for (int i = 0; i < sourceString.length() ; i++) {
            if (openBrackets.contains(sourceString.charAt(i))) {
                myStack.add(sourceString.charAt(i));
            } else if (closeBrackets.contains(sourceString.charAt(i))) {
                System.out.println("Inside secod if");
                if ((myStack.peek().equals('~')) || (myStack.peek().equals('{') && sourceString.charAt(i) != '}') ||
                        (myStack.peek().equals('[') && sourceString.charAt(i) != ']') ||
                        (myStack.peek().equals('(') && sourceString.charAt(i) != ')')) {
                    return false;
                } else {
                    myStack.pop();
                }
            }
        }
        return true;
    }
}
