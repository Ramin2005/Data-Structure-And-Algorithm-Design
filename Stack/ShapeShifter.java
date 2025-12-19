
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ShapeShifter {

    // infix to postfix:
    /**
     *
     * Converts any infix string to postfix string.
     *
     * @param String - Infixed string
     * @param HashSet - HashSet of operators
     * @param HashMap - HashMap of priority of operators
     * @return String - Returns postfixed string
     * @throws InvalidDataInputException - If have invalid data in input
     */
    public static String inFixToPostFix(String inFixed, HashSet<String> operatorsSet,
            HashMap<String, Integer> operatorsPriorityTable) throws InvalidDataInputException {

        // input check statement:
        if (operatorsSet.isEmpty()) {

            throw new InvalidDataInputException("Operator set must have at least one element!");

        } else if (operatorsSet.size() != operatorsPriorityTable.size()) {

            throw new InvalidDataInputException("Operators set and operators priority table must be has same size!");

        } else {

            for (String operator : operatorsSet) {

                try {

                    operatorsPriorityTable.get(operator);

                } catch (Exception e) {

                    throw new InvalidDataInputException(e.getMessage());

                }
            }

        }

        // taking ready input for tokenize
        String clone = inFixed
                .replaceAll("\\s*([()])\\s*", " $1 ")
                // first adds a space to the left end right of all "(" and ")" 
                .replaceAll("\\s+", " ")
                // after replace all spaces,tabs and next lines with one space
                .trim();
        // after remove spaces of the left and right

        // help data structures:
        String[] tokenized = clone.split(" ");

        Stack<String> operatorsStack = new Stack<>();
        Stack<String> valuesStack = new Stack<>();

        // priority making:
        for (String token : tokenized) {
            // ( part
            if (token.equals("(")) {

                operatorsStack.push(token);

            } // ) part
            else if (token.equals(")")) {

                String operatorsStackTop = operatorsStack.pop();

                while (!operatorsStackTop.equals("(")) {

                    if (valuesStack.isEmpty()) {

                        throw new InvalidDataInputException("Infixed string is invalid!");

                    }
                    String temp1 = valuesStack.pop();

                    if (valuesStack.isEmpty()) {

                        throw new InvalidDataInputException("Infixed string is invalid!");

                    }
                    String temp2 = valuesStack.pop();

                    String temp3 = temp2 + " " + temp1 + " " + operatorsStackTop;

                    valuesStack.push(temp3);
                    operatorsStackTop = operatorsStack.pop();

                }

            } // operator part:
            else if (operatorsSet.contains(token)) {

                if (valuesStack.isEmpty()) {

                    throw new InvalidDataInputException("Infixed string is invalid!");

                }

                // operators stack empty part:
                if (operatorsStack.empty()) {

                    operatorsStack.push(token);

                } // non-empty part:
                else {

                    String operatorsStackTop1 = operatorsStack.getLast();

                    // high priority part:
                    if (priorityCheck(token, operatorsStackTop1, operatorsPriorityTable)) {

                        operatorsStackTop1 = operatorsStack.pop();
                        if (valuesStack.isEmpty()) {

                            throw new InvalidDataInputException("Infixed string is invalid!");

                        }
                        String temp1 = valuesStack.pop();

                        if (valuesStack.isEmpty()) {

                            throw new InvalidDataInputException("Infixed string is invalid!");

                        }
                        String temp2 = valuesStack.pop();

                        String temp3 = temp2 + " " + temp1 + " " + operatorsStackTop1;

                        valuesStack.push(temp3);

                        operatorsStackTop1 = token;
                        if (!operatorsStack.isEmpty()) {

                            String operatorsStackTop2 = operatorsStack.getLast();

                            // check for next stack operator priority 
                            if (priorityCheck(operatorsStackTop1, operatorsStackTop2, operatorsPriorityTable)) {

                                operatorsStackTop2 = operatorsStack.pop();
                                if (valuesStack.isEmpty()) {

                                    throw new InvalidDataInputException("Infixed string is invalid!");

                                }
                                temp1 = valuesStack.pop();

                                if (valuesStack.isEmpty()) {

                                    throw new InvalidDataInputException("Infixed string is invalid!");

                                }
                                temp2 = valuesStack.pop();

                                temp3 = temp2 + " " + temp1 + " " + operatorsStackTop2;

                                valuesStack.push(temp3);
                                operatorsStack.push(operatorsStackTop1);

                            }

                        } else {

                            operatorsStack.push(token);

                        }

                    } // low priority part:
                    else {

                        operatorsStack.push(token);

                    }

                }

            } // value part: 
            else {

                valuesStack.push(token);

            }
        }

        // take ready for output:
        while (!operatorsStack.isEmpty()) {

            if (valuesStack.isEmpty()) {

                throw new InvalidDataInputException("Infixed string is invalid!");

            }
            String temp1 = valuesStack.pop();

            if (valuesStack.isEmpty()) {

                throw new InvalidDataInputException("Infixed string is invalid!");

            }
            String temp2 = valuesStack.pop();

            String temp3 = temp2 + " " + temp1 + " " + operatorsStack.pop();

            valuesStack.push(temp3);
        }

        // output check statement:
        String out = valuesStack.pop();

        if (!valuesStack.isEmpty()) {

            throw new InvalidDataInputException("Infixed string is invalid!");

        }
        return out;
    }

    private static boolean priorityCheck(String newOperator, String topOperator,
            HashMap<String, Integer> operatorsPriorityTable) {

        int newOperatorPriority = operatorsPriorityTable.get(newOperator);

        if (topOperator.equals("(")) {

            return false;

        } else {

            return operatorsPriorityTable.get(topOperator) >= newOperatorPriority;

        }
    }

    // postfixed to infix
    /**
     *
     * Converts any postfix string to infix string.
     *
     * @param String - Postfixed string
     * @param HashSet - HashSet of operators
     * @return String - Returns infixed string
     * @throws InvalidDataInputException - If have invalid data in input
     */
    public static String postFixToInFix(String postFixed, HashSet<String> operatorsSet) {

        // input check statement:
        if (operatorsSet.isEmpty()) {

            throw new InvalidDataInputException("Operator set must have at least one element!");

        }

        // taking ready input for tokenize
        String clone = postFixed
                .replaceAll("\\s*([()])\\s*", " $1 ")
                // first adds a space to the left end right of all "(" and ")" 
                .replaceAll("\\s+", " ")
                // after replace all spaces,tabs and next lines with one space
                .trim();
        // after remove spaces of the left and right

        // help data structures:
        String[] tokenized = clone.split(" ");

        Stack<String> help = new Stack<>();

        for (String token : tokenized) {

            if (operatorsSet.contains(token)) {

                if (help.isEmpty()) {

                    throw new InvalidDataInputException("Postfix string is invalid!");

                }
                String temp1 = help.pop();

                if (help.isEmpty()) {

                    throw new InvalidDataInputException("Postfix string is invalid!");

                }
                String temp2 = help.pop();

                String temp3 = String.format("(%s %S %s)", temp2, token, temp1);

                help.push(temp3);

            } else {

                help.push(token);

            }

        }

        String out = help.pop();

        if (!help.isEmpty()) {

            throw new InvalidDataInputException("Postfix string is invalid!");

        }

        return out;
    }

    // postfixed to infix
    /**
     *
     * Converts any postfix string to infix string.
     *
     * @param String - Postfixed string
     * @param HashSet - HashSet of operators
     * @return String - Returns infixed string
     * @throws InvalidDataInputException - If have invalid data in input
     */
    public static String preFixToInFix(String preFixed, HashSet<String> operatorsSet) {

        // input check statement:
        if (operatorsSet.isEmpty()) {

            throw new InvalidDataInputException("Operator set must have at least one element!");

        }

        // taking ready input for tokenize
        String clone = preFixed
                .replaceAll("\\s*([()])\\s*", " $1 ")
                // first adds a space to the left end right of all "(" and ")" 
                .replaceAll("\\s+", " ")
                // after replace all spaces,tabs and next lines with one space
                .trim();
        // after remove spaces of the left and right

        // help data structures:
        String[] tokenized = clone.split(" ");

        Stack<String> help = new Stack<>();

        for (int i = tokenized.length - 1; i > -1; i--) {

            String token = tokenized[i];

            if (operatorsSet.contains(token)) {

                if (help.isEmpty()) {

                    throw new InvalidDataInputException("Postfix string is invalid!");

                }
                String temp1 = help.pop();

                if (help.isEmpty()) {

                    throw new InvalidDataInputException("Postfix string is invalid!");

                }
                String temp2 = help.pop();

                String temp3 = String.format("(%s %S %s)", temp1, token, temp2);

                help.push(temp3);

            } else {

                help.push(token);

            }

        }

        String out = help.pop();

        if (!help.isEmpty()) {

            throw new InvalidDataInputException("Postfix string is invalid!");

        }

        return out;
    }

    //test method
    public static void main(String[] args) {
        String temp1 = "e a b + c * d ^ + ";
        String temp2 = "e +  ((a + b) * c) ^ d";
        String temp3 = "x - y - z * (a + b)";
        String temp4 = "+ b / * a c d";

        HashSet<String> op = new HashSet<>();
        HashMap<String, Integer> pr = new HashMap<>();

        op.add("+");
        pr.put("+", 1);
        op.add("-");
        pr.put("-", 1);
        op.add("*");
        pr.put("*", 2);
        op.add("/");
        pr.put("/", 2);
        op.add("^");
        pr.put("^", 3);

        clearConsole();
        System.out.println(inFixToPostFix(temp3, op, pr));
        System.out.println(postFixToInFix(inFixToPostFix(temp2, op, pr), op));
        System.out.println(inFixToPostFix(postFixToInFix(temp1, op), op, pr));
        System.out.println(postFixToInFix(temp1, op));
        System.out.println(preFixToInFix(temp4, op));

    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error trying to clear console.");
        }
    }
}
