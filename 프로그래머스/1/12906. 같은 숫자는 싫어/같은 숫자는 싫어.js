function solution(arr)
{
    const stack = []
    stack.push(arr[0])
    for(let i=1; i<arr.length; i++) {
        if(stack[stack.length-1] === arr[i]) {
            continue;
        }
        stack.push(arr[i])
    }
    return stack
}