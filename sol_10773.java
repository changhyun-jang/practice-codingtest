import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sol_10773 {
    public static void main(String[] args)throws IOException {
        Stack<Integer>stack=new Stack<>();
        int count=0;
        int result=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        count=Integer.parseInt(br.readLine());
        for(int i=0; i<count;i++){
            int command;
            command=Integer.parseInt(br.readLine());
            if(command==0){
                stack.pop();
            }else{
                stack.push(command);
            }
        }
        if(stack.empty()){
            System.out.println(result);
        }else{
            while(stack.empty()!=true){
                int num=stack.pop();
                result=result+num;
            }
            System.out.println(result);
        }
    }
}
