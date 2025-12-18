
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class ShapeShifter {

    // infix to postfix:
    public static String inFixToPostFix(String inFixed, HashSet<String> operatorSet, Hashtable<String, Integer> priority) {
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

                    String operatorsStackTop = operatorsStack.pop();

                    if (0) {

                        operatorsStack.push(token);

                    } else {

                    }

                }

            } else {

                valuesStack.push(token);

            }

        }

        return null;
    }
}
