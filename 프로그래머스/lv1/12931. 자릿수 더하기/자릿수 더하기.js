function solution(n)
{
    let num=String(n)
    let save=num.split("");
    result=0;
    for (let i of save){
        result+=Number(i)
    }
    return result;
}