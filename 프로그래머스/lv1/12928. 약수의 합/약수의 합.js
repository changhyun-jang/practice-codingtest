function solution(n) {
    let save=[];
    let result=0;
    for (let i=1; i<n+1;i++){
        if(n%i==0){
            save.push(i);
        }
    }
    for (let num of save){
        result+=num;
    }
    return result;
}