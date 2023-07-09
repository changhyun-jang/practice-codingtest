import java.io.*;
import java.util.ArrayList;

public class sol_add_10828 {
    static int Top=-1;
    static ArrayList<Integer> stack= new ArrayList<>();
    static int result=0;
    public static void main(String[] args) throws IOException {
        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String command;
            command=br.readLine();
            String save[]=new String[2];
            switch(command){
                case "top" :
                    System.out.println(top());
                    break;
                case "size" :
                    System.out.println(size());
                    break;

                case "empty" :
                    System.out.println(empty());
                    break;

                case "pop" :
                    System.out.println(pop());
                    break;

                default:
                    save=command.split(" ");
                    push(Integer.parseInt(save[1]));
                    break;

            }
        }
    }
    static void push(int n){
        stack.add(n);
        Top+=1;
    }
    static int pop(){
        if(Top==-1){
            return -1;
        }else {
            result=stack.get(Top);
            stack.remove(Top);
            Top-=1;
            return result;
        }
    }
    static int size(){
        return Top+1;
    }
    static int empty(){
        if(Top==-1){
            return 1;
        }else{
            return 0;
        }
    }
    static int top(){
        if(Top==-1){
            return -1;
        }else {
            result=stack.get(Top);
            return result;
        }
    }

}
