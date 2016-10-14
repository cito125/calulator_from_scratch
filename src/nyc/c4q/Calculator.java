package nyc.c4q;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Created by andresarango on 10/8/16.
 */
public class Calculator {


    /**
     * makeNice takes inputString and inserts multiplication symbols, *, where multiplication is implied by parentheses.
    * ex. --> input = "3(5)" ->makeNice(input) -> return "3*(5)"
     * ex, --> input = "3" ->makeNice(input) -> return "3"
    */
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

    /**
    * exponent takes four string arguments -> a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * a is the number to be exponentiated and, b, is the power, a, will be raised to. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. -> exponent("1","2","true","false") -> return "1.0"
    * */

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

    /**
    * multiply takes four string arguments -> a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * a and b are the numbers to be multiplied. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. -> multiply("1","2","true","false") -> return "-2.0"
    * */

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

    /**
    * divide takes four string arguments -> a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * a is the numerator and b is the denominator. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. -> divide("1","2","true","false") -> return "-0.5"
    * */

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

    /**
    * add takes four string arguments -> a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * a and b are the numbers to be added. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. -> add("1","2","true","false") -> return "1.0"
    * */

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

    /**
    * subtract takes four string arguments -> a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * b is subtracted from a. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. -> subtract("1","2","true","false") -> return "-3.0"
    * */

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

    /**
    * exp takes four string arguments ->a, b, isANegative, isBNegative. a and b must be parseable double strings
    * isANegative and isBNegative must be parseable boolean strings.
    * a is the base multiplied by 10 raised to the b power. isANegative and isBNegative indicate
     * a, and/or, b being negative
     * ex. exp("1","2","true","false") -> return "-100.0"
    * */

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

    /**
    * sine takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns sin(a) where a is in radians. isANegative indicates a being negative
     * ex. sine("0","false") -> return "0.0"
    * */

   private String sine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }

        double result = Math.sin(numa);
        return Double.toString(result);
    }

    /**
    * cosine takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns cos(a) where a is in radians. isANegative indicates a being negative
     * ex. cos("0","false") -> return "1.0"
    * */

   private String cosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.cos(numa);
        return Double.toString(result);
    }

    /**
    * tangent takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns tan(a) where a is in radians. isANegative indicates a being negative
     * ex. tan("0","false") -> return "0.0"
    * */

   private String tangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.tan(numa);
        return Double.toString(result);
    }

    /**
    * arcSine takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns asin(a) where a is in radians. isANegative indicates a being negative
     * ex. arcSine("0","false") -> return "0.0"
    * */

   private String arcSine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.asin(numa);
        return Double.toString(result);
    }

    /**
    * arcCosine takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns acos(a) where a is in radians. isANegative indicates a being negative
     * ex. arcCosine("1","false") -> return "0.0"
    * */

   private String arcCosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.acos(numa);
        return Double.toString(result);
    }

    /**
    * arcTangent takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns atan(a) where a is in radians. isANegative indicates a being negative
     * ex. arcTangent("0","false") -> return "0.0"
    * */

   private String arcTangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.atan(numa);
        return Double.toString(result);
    }

    /**
    * pI takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns pi approximated to 10 digits. isANegative indicates a being negative
     * ex. pi("false") -> return "3.14159265359"
    * */

   private String pI(String isANegative){
        double result = 3.14159265359;
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            result = result * -1;
        }
        return Double.toString(result);
    }


    /**
    * euler takes two string arguments -> a, isANegative. a must be a parseable double string.
    * isANegative must be a parseable boolean string.
    * this function returns e approximated to 10 digits. isANegative indicates a being negative
     * ex. euler("false") -> return "2.71828182846"
    * */
   private String euler(String isANegative){
        double result = 2.71828182846;
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            result = result * -1;
        }
        return Double.toString(result);
    }

    /**
     *Takes input string in the form of mathematical expressions and returns the result as a string.
     *
     * The primary purpose of calculate is to find operations in the correct order of PEMDAS, perform the found
     * operation on the corresponding operands, and then replace the portion of the string containing the operation and
     * operands with the result. This new string is then passed into calculate in a recursive process. Once the string
     * contains no more of operands used by calculate, the resulting string is returned.
     *
     * EXAMPLE.
     * For the expression "(2-3)*4" calculate will first see an open parentheses. The flatten function
     * will be called on this statement, which finds the innermost parentheses in the inputString. In this case flatten
     * will return "2-3". "2-3" is then passed into calculate to be calculated.
     *
     * calculate will see the subtraction operand and call the function getOperands array, which returns a string array
     * of length[6] containing the operands, signs of operands, and start and end index of substring in the input string
     * containing those operators and operands. The operands and operand signs are then passed to the subtract function
     * and the result, "-1" is returned. "-1" then replaces "(2-3)" in the original string "(2-3)*4", resulting in "-1*4".
     *
     * The "-1*4" is then passed into calculate. calculate will see the multiplication operand and call the function
     * getOperands array, which returns a string array of length[6] containing the operands, signs of operands, and
     * start and end index of substring in the input string containing those operators and operands. The operands and
     * operand signs are then passed to the multiply function and the result, "-4" is returned. "-4" then replaces
     * "-1*4" in the original string "-1*4", resulting in "-4".
     *
     * The resulting "-4" is then passed into calculate where it isrecognized as a string without operands, and the
     * calculate returns "-4" to what originally called calculate.
     *
     *
     *ex. calculate("3+2") -> return "5"
     * ex. calculate("3+(3-2)") -> return "4"
     * ex. calculate("(2-3)*4") -> return "-4"
     * */

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

    /**
     * isNegNum checks if the input string is a negative number by checking if any operands are in the string after the
     * first minus sign, inputString.charAt(0). Brittle, will be inaccurate if negative number starts after 0 index in
     * the input string.
     * */

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

    /**
     * flattenParenthese finds the innermost parentheses by continuously searching for the righmost openParentheses in the
     * inputString. flattenParenthese finds the leftmost open parenthese first and then searches the substring to the
     * right of this open parentheses for any other open parentheses.
     *
     * If an open parentheses is found, flattenParentheses is called on the substring to the right of that open
     * parentheses.
     *
     * If an open parentheses is not found, flatten parentheses finds the index of the first closing parentheses
     * following the open parentheses and returns the substring of the inputString using the start, end indexes.
     *
     * ex. flattenParenthese("3-4") -> return "3-4"
     *      flattenParenthese("(3-4)") -> return "3-4"
     *      flattenParenthese("5*(3-4)") -> return "3-4"
     * */

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


    /**
     * hasOperand takes a string and returns true if the inputString contains any PEMDAS operands. Otherwise, returns
     * false.
     *
     * ex. hasOperand("2-3") -> return true
     *      hasOperand("2") ->return false
     *      hasOperand("-2") -> return true
     * */

    private boolean hasOperand(String substring){
        if(substring.contains("^") || substring.contains("*") || substring.contains("/") || substring.contains("+")
                || substring.contains("-")){
            return true;
        }
        return false;
    }

    /**
     * getOperandsArray take in two strings. the inputString is parsed for the index of the passed in operator string.
     * getOperands then returns a string array of length six with:
     * - The first element containing the operand to the left of the operator in the input string
     * - The second element containing the operand to the right of the operator in the input string
     * - The second and third elements correspond to the start and end index of the inputString substring that contains
     *   the operator and operands.
     * - The fourth and fifth element hold strings indicating if the the first and second operands are negative numbers,
     *   respectively,
     *  ex. getOperandsArray("2-3","-") -> return {"2","3","0","3","false","false"}
     *  ex. getOperandsArray("20*-3","-") -> return {"20","3","0","5","false","true"}
     * */

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
