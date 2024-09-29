function solution(arr, delete_list) {
    return arr.filter((v,i) => !delete_list.includes(v))
}