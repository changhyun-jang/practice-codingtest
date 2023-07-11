    import java.io.*;
    import java.util.LinkedList;

    public class Main {
        static LinkedList<Integer> queue=new LinkedList<>();
        static int Back=0;
        static int Front=0;
        static int save=0;
        static int last=0;
        public static void main(String[] args) throws IOException {
            int Count=0;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Count=Integer.parseInt(br.readLine());
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i=0; i<Count; i++){
                String command=br.readLine();
                String arr[]=new String[2];
                switch(command){
                    case "front":
                        bw.write(String.valueOf(front()));
                        bw.newLine();
                        break;
                    case "back":
                        bw.write(String.valueOf(back()));
                        bw.newLine();
                        break;
                    case "pop":
                        bw.write(String.valueOf(pop()));
                        bw.newLine();
                        break;
                    case "size":
                        bw.write(String.valueOf(size()));
                        bw.newLine();
                        break;
                    case "empty":
                        bw.write(String.valueOf(empty()));
                        bw.newLine();
                        break;
                    default:
                        arr=command.split(" ");
                        push(Integer.parseInt(arr[1]));
                        break;
                }
            }
            bw.flush();
        }
        static void push(int n){
            queue.add(Back,n);
            last=n;
            Back+=1;
        }
        static int pop(){
            if(queue.isEmpty()){
                return -1;
            }else{
                save=queue.peek();
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
                return queue.peek();
            }
        }
        static int back(){
            if(queue.isEmpty()) {
                return -1;
            }else{
                return queue.peekLast();
            }
        }
    }
