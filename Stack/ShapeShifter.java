
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

        for (int i = 0; i < tokenized.length; i++) {
            String token = tokenized[i];

            if (token.equals("(")) {

                operatorsStack.push(token);

            } else if (token.equals(")")) {

            } else if (operatorSet.contains(token)) {

                if (operatorsStack.empty()) {

                    operatorsStack.push(token);

                } else {

                    String operatorsStackTop1 = operatorsStack.getFirst();
                    String operatorsStackTop2 = null;

                    if (priorityCheck(token, operatorsStackTop1, operatorsPriorityTable)) {

                        operatorsStackTop1 = operatorsStack.pop();
                        String temp1 = valuesStack.pop();
                        String temp2 = valuesStack.pop();

                        String temp3 = temp2 + " " + temp1 + " " + operatorsStackTop1;

                        valuesStack.push(temp3);

                        operatorsStackTop1 = token;
                        if (!operatorsStack.isEmpty()) {

                            operatorsStackTop2 = operatorsStack.getFirst();

                        }
                        operatorsStack.push(token);

                        

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
