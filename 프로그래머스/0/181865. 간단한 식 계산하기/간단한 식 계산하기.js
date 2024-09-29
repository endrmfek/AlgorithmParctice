const op = {
    '+' : (a,b) => a+b,
    '-' : (a,b) => a-b,
    '*' : (a,b) => a*b
}

function solution(binomial) {
    const arr = binomial.split(' ')
    return op[arr[1]](+arr[0],+arr[2])
}