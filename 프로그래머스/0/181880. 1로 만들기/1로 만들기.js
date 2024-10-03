function divide(number, count) {
    if(number === 1) return count
    
    if(number % 2 === 0) return divide(number / 2, count +1)
    else return divide((number-1)/2, count+1)
}

function solution(num_list) {
    return num_list.map(v => divide(v,0)).reduce((acc, val) => acc+ val, 0)
}

