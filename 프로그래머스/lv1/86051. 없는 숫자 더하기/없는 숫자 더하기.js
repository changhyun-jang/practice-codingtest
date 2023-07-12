function solution(numbers) {
    let diff=[1,2,3,4,5,6,7,8,9]
    let result=0;
    for(let i of diff){
        if (numbers.includes(i)){
            continue;
        }else{
            result+=i;
        }
    }
    return result;
}