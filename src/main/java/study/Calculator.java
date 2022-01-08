package study;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Integer result = null;

        try (Scanner scanner = new Scanner(System.in)) {
            String input_string = scanner.nextLine();
            String[] input_values = input_string.split(" ");

            Integer left_value = null;
            Integer right_value = Integer.parseInt(input_values[0]);
            Character operator = null;
            Calculator calculator = new Calculator();

            for (int i=1; i<input_values.length; i+=2){
                left_value = calculator.calculate(left_value, right_value, operator);
                operator = input_values[i].charAt(0);
                right_value = Integer.parseInt(input_values[i+1]);
            }

            result = calculator.calculate(left_value, right_value, operator);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
    
    public Integer add(Integer left_value, Integer right_value) {
        return left_value + right_value;
    }
    public Integer subtract(Integer left_value, Integer right_value) {
        return left_value - right_value;
    }
    public Integer multiply(Integer left_value, Integer right_value) {
        return left_value * right_value;        
    }
    public Integer divide(Integer left_value, Integer right_value) {
        return left_value / right_value;
    }
    public Integer calculate(Integer left_value, Integer right_value, Character operator) {
        if (operator == null) {
            return right_value;
        }
        if (operator.equals('+')) {
            return add(left_value, right_value);
        }
        if (operator.equals('-')) {
            return subtract(left_value, right_value);
        }
        if (operator.equals('*')) {
            return multiply(left_value, right_value);
        }
        if (operator.equals('/')) {
            return divide(left_value, right_value);
        }
        return right_value;
    }
}
