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

    private String exponent(String a, String b, String isANegative, String isBNegative){
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = Math.pow(numa,numb);
        return Double.toString(result);
    }

    private String multiply(String a, String b, String isANegative, String isBNegative){
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = numa * numb;
        return Double.toString(result);
    }

    private String divide(String a, String b,String isANegative, String isBNegative){
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = numa/numb;
        return Double.toString(result);
    }

   private String add(String a, String b, String isANegative, String isBNegative){
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = numa + numb;
        return Double.toString(result);
    }

   private String subtract(String a, String b, String isANegative, String isBNegative){
        if( a.equalsIgnoreCase("")){
            double numb = Double.parseDouble(b);
            return Double.toString(0 - numb);
        }
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = numa - numb;
        return Double.toString(result);
    }

   private String exp(String a,String b, String isANegative, String isBNegative){
        boolean isANeg = Boolean.valueOf(isANegative);
        boolean isBNeg = Boolean.valueOf(isBNegative);
        double numa = Double.parseDouble(a);
        double numb = Double.parseDouble(b);
        if(isANeg){
            numa = numa * -1;
        }
        if(isBNeg){
            numb = numb * -1;
        }
        double result = numa * Math.pow(10, numb);
        return Double.toString(result);
    }

   private String sine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }

        double result = Math.sin(numa);
        return Double.toString(result);
    }

   private String cosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.cos(numa);
        return Double.toString(result);
    }

   private String tangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.tan(numa);
        return Double.toString(result);
    }

   private String arcSine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.asin(numa);
        return Double.toString(result);
    }

   private String arcCosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.acos(numa);
        return Double.toString(result);
    }

   private String arcTangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.atan(numa);
        return Double.toString(result);
    }

   private String pI(String isANegative){
        double result = 3.14159265359;
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            result = result * -1;
        }
        return Double.toString(result);
    }

   private String euler(String isANegative){
        double result = 2.71828182846;
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            result = result * -1;
        }
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
        String sin = "sin";
        String cos = "cos";
        String tan = "tan";
        String arcSin = "arcsin";
        String arcCos = "arccos";
        String arcTan = "arctan";
        String pi = "pi";
        String e = "e";
        String exp = "E";
        String fact = "!";

        if (inputString.contains(openParentheses)){
            if(inputString.contains(closeParentheses)){
                String toReplace = "(" + flattenParenthese(inputString) + ")";
                String replacement = calculate(flattenParenthese(inputString));
                String operatedString = inputString.replace(toReplace,replacement);
                return calculate(operatedString);
            }else{
                String toReplace = "(" + flattenParenthese(inputString);
                String replacement = calculate(flattenParenthese(inputString));
                String operatedString = inputString.replace(toReplace,replacement);
                return calculate(operatedString);
            }
        }else if(inputString.contains(exponent)){
            String[] thisCalculation = getOperandsArray(inputString,exponent);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = exponent(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(multiplication)){
            String[] thisCalculation = getOperandsArray(inputString,multiplication);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = multiply(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(divide)){
            String[] thisCalculation = getOperandsArray(inputString,divide);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = divide(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(add)){
            String[] thisCalculation = getOperandsArray(inputString,add);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = add(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);
        }else if(inputString.contains(subtract)){
            String[] thisCalculation = getOperandsArray(inputString,subtract);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            if(isNegNum(toReplace)){
                return toReplace;
            }
            String replacement = subtract(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);
        }
        return inputString;
    }

    private boolean isNegNum(String inputString){
        if(inputString.charAt(0) == '-'){
            String searchForOperand = inputString.substring(1,inputString.length());
            if(hasOperand(searchForOperand)){
                return false;
            }else{
                return true;
            }
        }
        return false;
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
        String[] operationArray = new String[6];
        int operatorIndex = inputString.indexOf(operator);
        if(operatorIndex == 0 && operator.equals("-") && inputString.substring(operatorIndex + 1,inputString.length()).contains("-")){
            operationArray = getOperandsArray(inputString.substring(operatorIndex + 1,inputString.length()), operator);
            operationArray[3] = Integer.toString(Integer.parseInt(operationArray[3]) + 1);
            operationArray[4] = Boolean.toString(true);
            return operationArray;
        }
        int start = 0;
        int endExclusive = 0;
        boolean isFirstNumberNegative = false;
        boolean isSecondNumberNegative = false;
        int whereToStartSecondLoop = 1;
        // 4-5+2
        for (int i = operatorIndex - 1; i >= 0; i--) {
            if(i == 0) {
                start = 0;
                break;
            }else if (hasOperand(inputString.substring(i, operatorIndex))) {
                if(inputString.charAt(i) == '-' ){
                    if(i == 0){
                        isFirstNumberNegative = true;
                        start = 1;
                        break;
                    }else if(Character.isDigit(inputString.charAt( i - 1))){
                        start = i + 1;
                        break;
                    }else{
                        isFirstNumberNegative = true;
                        start = i + 1;
                        break;
                    }
                } else {
                    start = i + 1;
                    break;
                }
            }
        }

        if(inputString.charAt(operatorIndex + 1 ) == '-'){
            isSecondNumberNegative = true;
            whereToStartSecondLoop = 2;
        }

        for (int i = operatorIndex + whereToStartSecondLoop ; i < inputString.length() ; i++) {
            if(hasOperand(inputString.substring(operatorIndex + whereToStartSecondLoop ,i))){
                endExclusive = i - 1;
                break;
            } else if( i == inputString.length() - 1){
                endExclusive = inputString.length();
            }
        }
        operationArray[0] = inputString.substring(start, operatorIndex);
        operationArray[1] = inputString.substring(operatorIndex + whereToStartSecondLoop,endExclusive);
        operationArray[2] = Integer.toString(start);
        operationArray[3] = Integer.toString(endExclusive);
        operationArray[4] = Boolean.toString(isFirstNumberNegative);
        operationArray[5] = Boolean.toString(isSecondNumberNegative);


        return operationArray;
    }

}
