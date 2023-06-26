def solution(arr):
    answer = 0
    arr.sort(reverse=True)
    lcm = arr[0]
    
    def findGcd(big, small):
        if small == 0:
            return big
        return findGcd(small, big%small)
    
    for i in range(1,len(arr)):
        lcm = (lcm * arr[i]) // findGcd(lcm, arr[i])
        
    return lcm