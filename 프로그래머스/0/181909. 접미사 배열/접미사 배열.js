function solution(my_string) {
    return [...my_string].map((v,i) => my_string.slice(i)).sort()
    
}