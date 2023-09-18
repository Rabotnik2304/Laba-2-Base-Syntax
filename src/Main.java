
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String s;
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        s = String.valueOf(num);

        getSignsNumbers(new Integer[]{0, 0, 0, 0, 0, 0, 0},0);
    }
    public static void getSignsNumbers(Integer[] signsNumbers, int recursionDepth){
        if (recursionDepth==7){
            calc(signsNumbers);
            return;
        }
        for (int i = 0; i<5;i++){
            signsNumbers[recursionDepth] = i;
            getSignsNumbers(signsNumbers,recursionDepth+1);
        }
    }
    public static void calc(Integer[] signsNumbers)
    {

        String[] signs = new String[]{"", "+", "-", "*", "/"};

        String result = "";
        ArrayList<String> signsInAnswer = new ArrayList<String>();
        for (int g=0;g<7;g++){
            signsInAnswer.add(signs[signsNumbers[g]]);
        }

        result = String.valueOf(s.charAt(0));
        for (int h=0;h<7;h++){
            result += signsInAnswer.get(h) + s.charAt(h+1);
        }

        ArrayList<Double> numbers = new ArrayList<Double>();
        for (int i = 0; i < 8; i++) {
            numbers.add(Double.valueOf(s.charAt(i) - 48));
        }

        for (int k = 0; k < signsInAnswer.size(); k++) {
            if (signsInAnswer.get(k) == "") {
                numbers.set(k, numbers.get(k) * 10 + numbers.get(k + 1));
                numbers.remove(k + 1);
                signsInAnswer.remove(k);
                k -= 1;
            }
        }

        for (int k = 0; k < signsInAnswer.size(); k++) {
            if (signsInAnswer.get(k) == "*") {
                numbers.set(k, numbers.get(k) * numbers.get(k + 1));
                numbers.remove(k + 1);
                signsInAnswer.remove(k);
                k -= 1;
            } else if (signsInAnswer.get(k) == "/") {
                numbers.set(k, numbers.get(k) / numbers.get(k + 1));
                numbers.remove(k + 1);
                signsInAnswer.remove(k);
                k -= 1;
            }

        }

        Double ans = numbers.get(0);
        for (int k = 0; k < signsInAnswer.size(); k++) {
            if (signsInAnswer.get(k) == "+") {
                ans += numbers.get(k + 1);
            } else {
                ans -= numbers.get(k + 1);
            }
        }

        if (Math.abs(ans - 100) < 0.0001) {
            System.out.println(result + "=100");
        }
    }
}

