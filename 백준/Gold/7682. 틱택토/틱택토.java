import java.util.*;

public class Main {
    static String[] split;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String temp = sc.next();
            if (temp.equals("end")) {
                break;
            }
            int countX = 0;
            int countO = 0;
            split = temp.split("");
            check = new boolean[2];
            for (int i = 0; i < 9; i++) {
                if (split[i].equals("X")) countX++;
                if (split[i].equals("O")) countO++;
            }

            if (countX < 3) System.out.println("invalid");
            else {
                //꽉 찼을 때
                if (countX == 5 && countO == 4) {
                    checkRow();
                    checkCol();
                    checkD();
                    if (!check[1]) {
                        System.out.println("valid");
                    } else {
                        System.out.println("invalid");
                    }
                } else {
                    // X가 이길때
                    if (countX - countO == 1) {
                        checkRow();
                        checkCol();
                        checkD();
                        if (check[0] && !check[1]) {
                            System.out.println("valid");
                        } else {
                            System.out.println("invalid");
                        }
                    }
                    // Y가 이길때
                    else if (countX - countO == 0) {
                        checkRow();
                        checkCol();
                        checkD();
                        if (!check[0] && check[1]) {
                            System.out.println("valid");
                        } else {
                            System.out.println("invalid");
                        }
                    } else {
                        System.out.println("invalid");
                    }
                }
            }
        }
    }

    private static void checkD() {
        if (split[0].equals(split[4]) && split[0].equals(split[8])) {
            if (split[0].equals("X")) check[0] = true;
            if (split[0].equals("O")) check[1] = true;
        }
        if (split[2].equals(split[4]) && split[2].equals(split[6])) {
            if (split[2].equals("X")) check[0] = true;
            if (split[2].equals("O")) check[1] = true;
        }
    }

    private static void checkCol() {
        for (int i = 0; i < 3; i++) {
            if (split[i].equals(split[i + 3]) && split[i].equals(split[i + 6])) {
                if (split[i].equals("X")) check[0] = true;
                if (split[i].equals("O")) check[1] = true;
            }
        }
    }

    private static void checkRow() {
        for (int i = 0; i < 9; i += 3) {
            if (split[i].equals(split[i + 1]) && split[i].equals(split[i + 2])) {
                if (split[i].equals("X")) check[0] = true;
                if (split[i].equals("O")) check[1] = true;
            }
        }
    }
}
