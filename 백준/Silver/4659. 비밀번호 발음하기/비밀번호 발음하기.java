import java.util.Scanner;

public class Main {
    static char[] comStr = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            if(str.equals("end")){
                break;
            }
            boolean check = false;
            for (char ch : comStr) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }
            if (check) {
                int countM = 0;
                int countC = 0;
                char remember = '1';
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (remember == c && remember != 'e' && remember != 'o') {
                        check = false;
                        break;
                    }
                    remember = c;
                    boolean checkWord = false;
                    for (char ch : comStr) {
                        if (ch==c) {
                            checkWord = true;
                            break;
                        }
                    }
                    if(checkWord) {
                        countC = 0;
                        countM++;
                    }else{
                        countM = 0;
                        countC++;
                    }
                    if (countM == 3 || countC == 3) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println("<" + str + ">" + " is acceptable.");
            } else {
                System.out.println("<" + str + ">" + " is not acceptable.");
            }
        }
    }
}
