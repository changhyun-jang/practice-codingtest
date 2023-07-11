import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int count=0;
        String command;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        count=Integer.parseInt(br.readLine());
        for (int i=0; i<count;i++){
            Stack<String> stack=new Stack<>();
            String []save;
            int count2=0;
            String result="NO";
            String save2="";
            command=br.readLine();
            save=command.split("");
            for(int j=save.length-1; j>-1;j--){
                stack.push(save[j]);
            }
            while(stack.empty()!=true){
                save2=stack.pop();
                if("(".equals(save2)){
                    count2=count2+1;
                }else{
                    count2=count2-1;
                }
                if(count2<0){
                    break;
                }
            }
            if(count2!=0){
                System.out.println(result);
            }else{
                result="YES";
                System.out.println(result);
            }
        }
    }
}
