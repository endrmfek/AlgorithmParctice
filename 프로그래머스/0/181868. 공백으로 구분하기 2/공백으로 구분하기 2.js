function solution(my_string) {
    const answer = []
    
    my_string.split(' ').forEach(v => {
        if(v !== '') {
            answer.push(v)
        }
    })
    
    return answer
}