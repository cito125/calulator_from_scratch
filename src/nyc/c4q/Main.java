package nyc.c4q;

import sun.jvm.hotspot.oops.Array;
import sun.jvm.hotspot.types.basic.BasicNarrowOopField;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;

public class Main {


    public static void main(String[] args) {
	// write your code here
        Calculator cal = new Calculator();
//        String[] yo = "dang bro ( (".split(" ");
//        List<String> b = new ArrayList<>(Arrays.asList(yo));
//        System.out.println(b);
//        System.out.println(b.removeAll(Collections.singleton("(")));
//        System.out.println(b);
//            String[] yo = getFactArray("3+2!");
//        for (int i = 0; i < yo.length; i++) {
//            System.out.println(yo[i]);
//        }

    }


    static String makeNice(String inputString){
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

    static String exponent(String a, String b, String isANegative, String isBNegative){
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

    static String multiply(String a, String b, String isANegative, String isBNegative){
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

    static String divide(String a, String b,String isANegative, String isBNegative){
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

    static String add(String a, String b, String isANegative, String isBNegative){
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

    static String subtract(String a, String b, String isANegative, String isBNegative){
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

    static String exp(String a,String b, String isANegative, String isBNegative){
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

    static String factorial(String a){
        Double numa = Double.parseDouble(a);
        double result = mathFact(numa);
        return Double.toString(result);
    }

    static Double mathFact(Double a) {
        if (a <= 0) {
            if (a == Math.round(a)) {
                return 1.0;

            }else{
                return Math.sqrt(3.14159265359);
            }
        }

        return a * mathFact(a - 1);
    }

    static String sine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }

        double result = Math.sin(numa);
        return Double.toString(result);
    }

    static String cosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.cos(numa);
        return Double.toString(result);
    }

    static String tangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.tan(numa);
        return Double.toString(result);
    }

    static String arcSine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.asin(numa);
        return Double.toString(result);
    }

    static String arcCosine(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.acos(numa);
        return Double.toString(result);
    }

    static String arcTangent(String a, String isANegative){
        double numa = Double.parseDouble(a);
        boolean isANeg = Boolean.valueOf(isANegative);
        if(isANeg){
            numa = numa * -1;
        }
        double result = Math.atan(numa);
        return Double.toString(result);
    }

    static String pI(){
        double result = 3.14159265359;
        return Double.toString(result);
    }

    static String euler(){
        double result = 2.71828182846;
        return Double.toString(result);
    }


    static String calculate(String inputString) {
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
        if (inputString.contains(pi)) {
            String operatedString = inputString.replaceAll(pi, pI());
            return calculate(operatedString);
        }
        if (inputString.contains(e)) {
            String operatedString = inputString.replaceAll(e, euler());
            return calculate(operatedString);
        }
        if (inputString.contains(openParentheses)) {
            if (inputString.contains(closeParentheses)) {
                String toReplace = "(" + flattenParenthese(inputString) + ")";
                String replacement = calculate(flattenParenthese(inputString));
                String operatedString = inputString.replace(toReplace, replacement);
                return calculate(operatedString);
            } else {
                String toReplace = "(" + flattenParenthese(inputString);
                String replacement = calculate(flattenParenthese(inputString));
                String operatedString = inputString.replace(toReplace, replacement);
                return calculate(operatedString);
            }
        }else if(inputString.contains(fact)){
            String[] thisCalculation = getFactArray(inputString);
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = inputString.substring(start,end) + "!";
            String replacement = factorial(thisCalculation[0]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(sin)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = sin + inputString.substring(start,end);
            String replacement = sine(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(cos)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = cos + inputString.substring(start,end);
            String replacement = cosine(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(tan)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = tan + inputString.substring(start,end);
            String replacement = tangent(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(arcSin)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = arcSin + inputString.substring(start,end);
            String replacement = arcSine(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(arcCos)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = arcCos + inputString.substring(start,end);
            String replacement = arcCosine(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(arcTan)){
            String [] thisCalculation = getTrigOpearndArray(inputString,"n");
            int start = Integer.parseInt(thisCalculation[1]);
            int end = Integer.parseInt(thisCalculation[2]);
            String toReplace = arcTan + inputString.substring(start,end);
            String replacement = arcTangent(thisCalculation[0],thisCalculation[3]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(exponent)){
            String[] thisCalculation = getOperandsArray(inputString,exponent);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = exponent(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
            String operatedString = inputString.replace(toReplace,replacement);
            return calculate(operatedString);

        }else if(inputString.contains(exp)){
            String[] thisCalculation = getOperandsArray(inputString,exp);
            int start = Integer.parseInt(thisCalculation[2]);
            int end = Integer.parseInt(thisCalculation[3]);
            String toReplace = inputString.substring(start,end);
            String replacement = exp(thisCalculation[0],thisCalculation[1],thisCalculation[4],thisCalculation[5]);
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

    private static boolean isNegNum(String inputString){
        if(inputString.charAt(0) == '-'){
            String searchForOperand = inputString.substring(1,inputString.length());
            if(hasOperand(searchForOperand) || hasTrigOperand(searchForOperand)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    private static String flattenParenthese(String inputString){
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

    static boolean hasOperand(String substring){
        if(substring.contains("^") || substring.contains("*") || substring.contains("/") || substring.contains("+")
                || substring.contains("-") || substring.contains("E") || substring.contains("!")){
            return true;
        }
        return false;
    }

    static boolean hasTrigOperand(String substring){
        if( substring.contains("n") || substring.contains("a") ||substring.contains("s") || substring.contains("c")
                || substring.contains("t")){
            return true;
        }
        return false;
    }

    static String[] getFactArray(String inputString){
        String[] operationArray = new String[3];
        int end = inputString.indexOf("!");
        int start = 0;
        for (int i = end; i > 0 ; i--) {
            if(hasOperand(inputString.substring(i ,end))
               || hasTrigOperand(inputString.substring(i ,end))
               ){
                    start = i +1;
                    break;
                }

            }
        operationArray[0] = inputString.substring(start,end);
        operationArray[1] = Integer.toString(start);
        operationArray[2] = Integer.toString(end);

        return operationArray;
    }

    static String[] getTrigOpearndArray(String inputString, String operator){
        String[] operationArray = new String[4];
        int operatorIndex = inputString.indexOf(operator);
        boolean isNumberNegative = false;
        int whereToStartSecondLoop = 1;
        if(inputString.charAt(operatorIndex + 1) == '-'){
            isNumberNegative = true;
            whereToStartSecondLoop = 2;
        }

        int start = operatorIndex + whereToStartSecondLoop;
        int endExclusive = 0;

        for (int i = operatorIndex + whereToStartSecondLoop ; i < inputString.length() ; i++) {
            if(hasOperand(inputString.substring(operatorIndex + whereToStartSecondLoop ,i))
                    || hasTrigOperand(inputString.substring(operatorIndex + whereToStartSecondLoop ,i))
                    ){
                endExclusive = i - 1;
                break;
            } else if( i == inputString.length() - 1){
                endExclusive = inputString.length();
            }
        }
        operationArray[0] = inputString.substring(start, endExclusive);
        operationArray[1] = Integer.toString(operatorIndex + 1);
        operationArray[2] = Integer.toString(endExclusive);
        operationArray[3] = Boolean.toString(isNumberNegative);


        return operationArray;
    }


    static String[] getOperandsArray(String inputString, String operator){
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
            }else if (hasOperand(inputString.substring(i, operatorIndex)) || hasTrigOperand(inputString.substring(i,operatorIndex))) {
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
            if(hasOperand(inputString.substring(operatorIndex + whereToStartSecondLoop ,i))
             || hasTrigOperand(inputString.substring(operatorIndex + whereToStartSecondLoop ,i))
                    ){
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
