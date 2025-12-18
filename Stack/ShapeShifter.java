
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class ShapeShifter {

    // infix to postfix:
    public static String inFixToPostFix(String inFixed, HashSet<String> operatorSet,
            Hashtable<String, Integer> operatorsPriorityTable) {
        if (operatorSet.size() != operatorsPriorityTable.size()) {

            throw new InvalidDataInputException("Operators set and operators priority table must be has same size!");

        } else {

            for (String operator : operatorSet) {

                try {

                    operatorsPriorityTable.get(operator);

                } catch (Exception e) {

                    throw new InvalidDataInputException(e.getMessage());

                }
            }

        }

        String[] tokenized = inFixed.split(" ");

        Stack<String> operatorsStack = new Stack<>();
        Stack<String> valuesStack = new Stack<>();

        for (String token : tokenized) {

            if (token.equals("(")) {

                operatorsStack.push(token);

            } else if (token.equals(")")) {

            } else if (operatorSet.contains(token)) {

                if (operatorsStack.empty()) {

                    operatorsStack.push(token);

                } else {

                    String operatorsStackTop1 = operatorsStack.pop();
                    String operatorsStackTop2 = "";

                    if (priorityCheck(token, operatorsStackTop1, operatorsPriorityTable)) {

                        String temp1 = valuesStack.pop();
                        String temp2 = valuesStack.pop();

                        String temp3 = temp2 + " " + temp1 + " " + operatorsStackTop1;

                        valuesStack.push(temp3);

                        operatorsStackTop1 = token;
                        operatorsStack.push(token);

                        while (!operatorsStack.isEmpty() && ){

                        }

                    } else {

                        operatorsStack.push(operatorsStackTop1);
                        operatorsStack.push(token);

                    }



                }

            } else {

                valuesStack.push(token);

            }

        }

        return null;
    }

    private static boolean priorityCheck(String newOperator, String topOperator,
            Hashtable<String, Integer> operatorsPriorityTable) {

        int newOperatorPriority = operatorsPriorityTable.get(newOperator);

        if (topOperator.equals("(")) {

            return false;

        } else {

            return operatorsPriorityTable.get(topOperator) >= newOperatorPriority;

        }
    }
}
