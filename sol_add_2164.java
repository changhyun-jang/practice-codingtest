import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sol_add_2164 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue= new LinkedList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        for(int i=1; i<num+1;i++){
            queue.add(i);
        }
        while(true){
            if(queue.size()==1){
                break;
            }
            int save;
           queue.poll();
           save= queue.poll();
           queue.offer(save);
        }
        System.out.println(queue.poll());
    }
}
