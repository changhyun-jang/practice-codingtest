import java.io.*;
import java.util.LinkedList;


public class sol_5397 {
    public static void main(String[] args) throws IOException {
        int time=0;
        String word="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        time=Integer.parseInt(br.readLine());
        for(int i=0;i<time; i++){
            String[] list2;
            list2= br.readLine().split("");
            LinkedList<String> list=new LinkedList<String>();
            int count=0;
            int len=0;
            len=list2.length;
            for(int j=0; j<len;j++){
                if("<".equals(list2[j])){
                    if(count==0){
                        continue;
                    }else{
                        count-=1;
                    }
                }else if(">".equals(list2[j])){
                    if(count==list.size()){
                        continue;
                    }else{
                        count+=1;
                    }
                }else if("-".equals(list2[j])){
                    if(count==0){
                        continue;
                    }else{
                        count-=1;
                        list.remove(count);
                    }
                }else{
                    list.add(count,list2[j]);
                    count+=1;
                }
            }
            word=String.join("",list);
            bw.write(word);
            bw.newLine();
            word="";
        }
        bw.flush();
        bw.close();
    }
}