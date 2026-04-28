
public class StringToInt {

    public static int String_To_Int(String s) throws Exception {
        if (s.length() == 0) {
            return 0;
        } else {
            int num = 0;
            char digit = s.charAt(s.length() - 1);
            switch (digit) {
                case '0' ->
                    num = 0;

                case '1' ->
                    num = 1;

                case '2' ->
                    num = 2;

                case '3' ->
                    num = 3;

                case '4' ->
                    num = 4;

                case '5' ->
                    num = 5;

                case '6' ->
                    num = 6;

                case '7' ->
                    num = 7;

                case '8' ->
                    num = 8;

                case '9' ->
                    num = 9;
                default ->
                    throw new Exception("String has characters");
            }

            return num + 10 * String_To_Int(s.substring(0, (s.length() - 1)));
        }
    }
}
