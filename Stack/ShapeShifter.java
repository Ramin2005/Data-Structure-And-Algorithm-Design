
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class ShapeShifter {

    // infix to postfix:
    public static String inFixToPostFix(String inFixed, HashSet<String> operatorSet,
            Hashtable<String, Integer> operatorsPriorityTable) {

        // first adds a space to the left end right of all "(" and ")" 
        // after replace all spaces,tabs and next lines with one space
        // after remove spaces of the left and right
        String clone = inFixed
                .replaceAll("\\s*([()])\\s*", " $1 ")
                .replaceAll("\\s+", " ")
                .trim();

        // input check statement:
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
            else if (operatorSet.contains(token)) {

                if (valuesStack.isEmpty()) {

                    throw new InvalidDataInputException("Infixed string is invalid!");

                }

                // operators stack empty part:
                if (operatorsStack.empty()) {

                    operatorsStack.push(token);

                } // non-empty part:
                else {

                    String operatorsStackTop1 = operatorsStack.getLast();
                    String operatorsStackTop2 = null;

                    // high priority part:
                    if (priorityCheck(token, operatorsStackTop1, operatorsPriorityTable)) {

                        operatorsStackTop1 = operatorsStack.pop();
                        String temp1 = valuesStack.pop();
                        String temp2 = valuesStack.pop();

                        String temp3 = temp2 + " " + temp1 + " " + operatorsStackTop1;

                        valuesStack.push(temp3);

                        operatorsStackTop1 = token;
                        if (!operatorsStack.isEmpty()) {

                            operatorsStackTop2 = operatorsStack.getLast();

                        }
                        operatorsStack.push(token);

                        // check for next stack operator priority 
                        while (operatorsStackTop2 != null) {
                            if (priorityCheck(operatorsStackTop1, operatorsStackTop2, operatorsPriorityTable)) {

                                operatorsStackTop1 = operatorsStack.pop();
                                operatorsStackTop2 = operatorsStack.pop();
                                temp1 = valuesStack.pop();
                                temp2 = valuesStack.pop();

                                temp3 = temp2 + " " + temp1 + " " + operatorsStackTop2;

                                valuesStack.push(temp3);

                                if (!operatorsStack.isEmpty()) {

                                    operatorsStackTop2 = operatorsStack.getLast();

                                } else {

                                    operatorsStackTop2 = null;

                                }

                                operatorsStack.push(operatorsStackTop1);

                            } else {

                                operatorsStackTop2 = null;

                            }
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
            Hashtable<String, Integer> operatorsPriorityTable) {

        int newOperatorPriority = operatorsPriorityTable.get(newOperator);

        if (topOperator.equals("(")) {

            return false;

        } else {

            return operatorsPriorityTable.get(topOperator) >= newOperatorPriority;

        }
    }

}
