/*
-- sudo코드
static boolean[] visited;
static int answer;

(main)
visited초기화
BFS(begin,words)


(BFS)
Queue선언
Queue에 begin삽입
while(queue가 빌때까지) {
    now에 queue.poll();
    for(words길이) {
        if(visited[i] == false) {
            몇개의 단어를 가지고 있는지 확인하는 변수 count선언
            for(begin길이) {
                if(단어가 있으면) count ++;
            }
            if(count == 2면) {
                queue에 삽입
                visited[i] == true;
            }
        }
    }
}
*/

import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;
        boolean check = false;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                check = true;
            }
        }
        if(check) {
            BFS(begin, target, words);
        } else {
            answer = 0;
        }
        return answer;
    }
    
    public static void BFS(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> depth = new LinkedList<Integer>();
        queue.offer(begin);
        depth.offer(0);
        while(!queue.isEmpty()) {
            String[] now = queue.poll().split("");
            int nowDepth = depth.poll();
            answer = nowDepth;
            if(now.equals(target)) {
                break;
            }
               
            for(int i = 0; i < words.length; i++) {
                if(visited[i]==false) {
                    String[] temp = words[i].split("");
                    int count = 0;
                    for(int j = 0; j<now.length; j++) {
                        if(temp[j].contains(now[j])) {
                            count++;
                        }
                    }
                    if(count==words[i].length()-1) {
                        queue.offer(words[i]);
                        depth.offer(nowDepth+1);
                        visited[i] = true;
                    }
                    if(count==words[i].length()) {
                        answer = nowDepth+1;
                        return;
                    }
                }
            }
        } 
    }   
}