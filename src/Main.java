
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число:");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String s = String.valueOf(num);

        String[] signs = new String[] {"","+","-","*","/"};
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                            for (int f = 0; f < 5; f++) {
                                for (int t = 0; t < 5; t++) {
                                    String result = "";
                                    ArrayList<String> signsInAnswer = new ArrayList<String>();
                                    signsInAnswer.add(signs[a]);
                                    signsInAnswer.add(signs[b]);
                                    signsInAnswer.add(signs[c]);
                                    signsInAnswer.add(signs[d]);
                                    signsInAnswer.add(signs[e]);
                                    signsInAnswer.add(signs[f]);
                                    signsInAnswer.add(signs[t]);

                                    result = s.charAt(0) + signs[a] +  s.charAt(1);
                                    result += signs[b] +  s.charAt(2);
                                    result += signs[c] +  s.charAt(3);
                                    result += signs[d] +  s.charAt(4);
                                    result += signs[e] +  s.charAt(5);
                                    result += signs[f] +  s.charAt(6);
                                    result += signs[t] +  s.charAt(7);

                                    ArrayList<Double> numbers = new ArrayList<Double>();
                                    for (int i=0; i<8;i++){
                                        numbers.add(Double.valueOf(s.charAt(i)-48));
                                    }

                                    for (int k=0; k<signsInAnswer.size();k++){
                                        if(signsInAnswer.get(k)==""){
                                            numbers.set(k,numbers.get(k)*10+numbers.get(k+1));
                                            numbers.remove(k+1);
                                            signsInAnswer.remove(k);
                                            k-=1;
                                        }
                                    }

                                    for (int k=0; k<signsInAnswer.size();k++){
                                        if(signsInAnswer.get(k)=="*"){
                                            numbers.set(k,numbers.get(k)*numbers.get(k+1));
                                            numbers.remove(k+1);
                                            signsInAnswer.remove(k);
                                            k-=1;
                                        }else if (signsInAnswer.get(k)=="/"){
                                            numbers.set(k,numbers.get(k)/numbers.get(k+1));
                                            numbers.remove(k+1);
                                            signsInAnswer.remove(k);
                                            k-=1;
                                        }

                                    }

                                    Double ans = numbers.get(0);
                                    for (int k=0; k<signsInAnswer.size();k++){
                                        if(signsInAnswer.get(k)=="+"){
                                            ans +=numbers.get(k+1);
                                        }else {
                                            ans -=numbers.get(k+1);
                                        }
                                    }

                                    if (Math.abs(ans - 100)< 0.0001){
                                        System.out.println(result + "=100");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
