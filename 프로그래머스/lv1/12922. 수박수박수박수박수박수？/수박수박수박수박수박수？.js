function solution(n) {
    let result;
    let save=[];
    for(let i=1; i<n+1;i++){
        if(i%2==0){
            save.push("박")
        }else{
            save.push("수")
        }
    }
    result=save.join("")
    return result;
}