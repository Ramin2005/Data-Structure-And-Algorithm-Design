public class BaseConverter {

    public static void main(String[] args) {
        System.out.print(BaseCon(11, 3));
    }

    public static String BaseCon(int n, int base) {
        int reminder = n % base;
        if (n / base > 0)
            return BaseCon(n / base, base) + reminder;
        else return (reminder + "");
    }
}
