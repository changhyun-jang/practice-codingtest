import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String []command= br.readLine().split(" ");
        int node=Integer.parseInt(command[0]);
        int leaf=Integer.parseInt(command[1]);
        int total=0;
        int sum=(node-1)*2;
        ArrayList<Integer> Tree=new ArrayList<>();

        for (int i=0; i<node;i++){
            Tree.add(1);
            total+=1;
        }
        while(total<sum){
            for(int j=node-1; j>=leaf;j--){
                int save=Tree.get(j);
                Tree.set(j,save+1);
                total+=1;
                if (total==sum){
                    break;
                }
            }
        }

        for(int k=0; k<node;k++){
            int max_value=Collections.max(Tree);
            int save=Tree.get(k);
            int max_index=Tree.indexOf(max_value);
            if(Tree.get(k)!=0){
                Tree.set(k,save-1);
                Tree.set(Tree.indexOf(max_value),max_value-1);

                if(k==node-2){
                    bw.write(k+" "+(max_index+1));
                }else{
                    bw.write(k+" "+max_index);
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
