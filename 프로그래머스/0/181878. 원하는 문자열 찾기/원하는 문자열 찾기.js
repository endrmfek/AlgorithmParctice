function solution(myString, pat) {
    myString = myString.toLowerCase()
    pat = pat.toLowerCase()
    console.log(myString, pat)
    return +myString.includes(pat)
}