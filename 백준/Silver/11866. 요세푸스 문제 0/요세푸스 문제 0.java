import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        Deque<Integer> queue=new LinkedList<>();
        String command=br.readLine();
        int count=1;
        int save;
        String []command2=new String[2];
        command2=command.split(" ");
        for(int i=1; i<Integer.parseInt(command2[0])+1;i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            if(queue.size()==1){
                bw.write(String.valueOf(queue.pop()));
                break;
            }
            save=queue.pop();
            if(count==Integer.parseInt(command2[1])){
                bw.write(String.valueOf(save)+", ");
                count=1;

            }else{
                queue.add(save);
                count++;
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
