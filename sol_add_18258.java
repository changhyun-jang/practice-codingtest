import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class sol_add_18258 {
    static ArrayList<Integer> queue=new ArrayList<>();
    static int Back=0;
    static int Front=0;
    static int save=0;
    public static void main(String[] args) throws IOException {
        int Count=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Count=Integer.parseInt(br.readLine());
        for (int i=0; i<Count; i++){
            String command=br.readLine();
            String arr[]=new String[2];
            switch(command){
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                default:
                    arr=command.split(" ");
                    push(Integer.parseInt(arr[1]));
                    break;
            }
        }
    }
    static void push(int n){
        queue.add(Back,n);
        Back+=1;
    }
    static int pop(){
        if(queue.isEmpty()){
            return -1;
        }else{
            save=queue.get(Front);
            queue.remove(Front);
            Back-=1;
            return save;
        }
    }
    static int size(){
        return Back-Front;
    }
    static int empty(){
        if(queue.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
    static int front(){
        if(queue.isEmpty()){
            return -1;
        }else{
            return queue.get(Front);
        }
    }
    static int back(){
        if(queue.isEmpty()) {
            return -1;
        }else{
            return queue.get(Back-1);
        }
    }
}
