function my_solution(arr) {
    //50이상 짝수 -> %2
    //50미만 홀수 -> *2
    
    return arr.map(v => {
        if(v >= 50 && v % 2 === 0) return v / 2
        if(v < 50 && v%2 === 1) return v*2
        return v
    })
}

function solution(arr) {
    return arr.map(num => {
        if(num >= 50 && !(num % 2)) return num / 2;
        if(num < 50 && num % 2) return num * 2;
        return num;
    })
}