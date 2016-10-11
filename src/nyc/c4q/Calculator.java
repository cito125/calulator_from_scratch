package nyc.c4q;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Created by andresarango on 10/8/16.
 */
public class Calculator {

    private String makeNice(String inputString){
        String toReturn = inputString;
        for (int i = 1; i <toReturn.length() - 1 ; i++) {
            if(toReturn.charAt(i) == '('){
                if (Character.isDigit(toReturn.charAt(i -1))) {
                    toReturn = toReturn.substring(0,i) + "*" + toReturn.substring(i,toReturn.length());
                }
            }
            if(toReturn.charAt(i) == ')'){
                if (Character.isDigit(toReturn.charAt(i + 1))) {
                    toReturn = toReturn.substring(0,i + 1) + "*" + toReturn.substring(i + 1,toReturn.length());
                }
            }


        }
        return toReturn;
    }

    private String exponent(String a, String b){
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        double result = Math.pow(numa,numb);
        return Double.toString(result);
    }

    private String multiply(String a, String b){
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        double result = numa * numb;
        return Double.toString(result);
    }

    private String divide(String a, String b){
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        double result = numa/numb;
        return Double.toString(result);
    }

    private String add(String a, String b){
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        double result = numa + numb;
        return Double.toString(result);
    }

    private String subtract(String a, String b){
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        double result = numa - numb;
        return Double.toString(result);
    }

    public String calculate(String inputString) {
        String exponent = "^";
        String multiplication = "*";
        String divide = "/";
        String add = "+";
        String subtract = "-";
        String openParentheses = "(";
        String closeParentheses = ")";

        if (inputString.contains(openParentheses)){
//            if(inputString.contains(closeParentheses)){
//                String toReplace = "(" + flattenParenthese(inputString) + ")";
//                String replacement = calculate(flattenParenthese(inputString));
//                String operatedString = inputString.replace(toReplace,replacement);
//                return calculate(operatedString);
//            }else{
//                String toReplace = "(" + flattenParenthese(inputString);
//                String replacement = calculate(flattenParenthese(inputString));
//                String operatedString = inputString.replace(toReplace,replacement);
//                return calculate(operatedString);
//            }
            String toReplace = "(" + flattenParenthese(inputString) + ")";
            String replacement = calculate(flattenParenthese(inputString));
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);
        }else if(inputString.contains(exponent)){
            String[] thisCalculation = getOperandsArray(inputString,exponent);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = exponent(thisCalculation[0],thisCalculation[1]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(multiplication)){
            String[] thisCalculation = getOperandsArray(inputString,multiplication);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = multiply(thisCalculation[0],thisCalculation[1]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(divide)){
            String[] thisCalculation = getOperandsArray(inputString,divide);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = divide(thisCalculation[0],thisCalculation[1]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(add)){
            String[] thisCalculation = getOperandsArray(inputString,add);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = add(thisCalculation[0],thisCalculation[1]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(subtract)){
            String[] thisCalculation = getOperandsArray(inputString,subtract);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = subtract(thisCalculation[0],thisCalculation[1]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);
        }
        return inputString;
    }

    private String flattenParenthese(String inputString){
        int start = 0;
        int end = inputString.length();
        if(inputString.contains("(")){
            start = inputString.indexOf("(") + 1;
            for (int i = start; i < inputString.length() ; i++) {
                if(inputString.charAt(i) == '('){
                    return flattenParenthese(inputString.substring(i,inputString.length()));
                }else if (inputString.charAt(i) == ')'){
                    end = i;
                    break;
                }
            }

        }
        return inputString.substring(start, end);
    }

    private boolean hasOperand(String substring){
        if(substring.contains("^") || substring.contains("*") || substring.contains("/") || substring.contains("+")
                || substring.contains("-")){
            return true;
        }
        return false;
    }

    private String[] getOperandsArray(String inputString, String operator){
        String[] operationArray = new String[4];
        operationArray[2] = operator;
        int operatorIndex = inputString.indexOf(operator);
        int start = 0;
        int endExclusive = 0;
        for (int i = operatorIndex - 1; i >= 0; i--) {
            if(i == 0) {
                start = 0;
            }else if (hasOperand(inputString.substring(i, operatorIndex))) {
                start = i + 1;
                break;
            }
        }

        for (int i = operatorIndex + 1; i < inputString.length() ; i++) {
            if(hasOperand(inputString.substring(operatorIndex + 1,i))){
                endExclusive = i - 1;
                break;
            } else if( i == inputString.length() - 1){
                endExclusive = inputString.length();
            }
        }
        operationArray[0] = inputString.substring(start, operatorIndex);
        operationArray[1] = inputString.substring(operatorIndex + 1,endExclusive);
        operationArray[2] = Integer.toString(start);
        operationArray[3] = Integer.toString(endExclusive);

        return operationArray;
    }

}
