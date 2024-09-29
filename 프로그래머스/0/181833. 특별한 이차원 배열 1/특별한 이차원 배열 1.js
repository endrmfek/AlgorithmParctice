function solution(n) {
    const answer = Array(n).fill(0).map((v,r) => {
        return Array(n).fill(0).map((v,c) => r === c ? 1 : 0)
    })
    return answer;
}