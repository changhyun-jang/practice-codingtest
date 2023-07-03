import java.util.Scanner;

public class sol_14405 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();
        String result="NO";

        if(str.contains("pi")||str.contains("ka")||str.contains("chu")){
            str=str.replace("pi","1");
            str=str.replace("ka","1");
            str=str.replace("chu", "1");
        }
        str=str.replace("1", "");
        if(str.length()==0){
            result="YES";
        }
        System.out.print(result);
    }
}
