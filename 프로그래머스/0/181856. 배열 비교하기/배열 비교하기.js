function solution(arr1, arr2) {
    if (arr1.length > arr2.length) {
        return 1
    } else if (arr1.length < arr2.length) {
        return -1
    } else {
        const hap1 = arr1.reduce((acc,val) => acc + val , 0)
        const hap2 = arr2.reduce((acc,val) => acc + val , 0)
        
        if( hap1 > hap2) return 1
        else if (hap1 < hap2) return -1
        else return 0
    }
}