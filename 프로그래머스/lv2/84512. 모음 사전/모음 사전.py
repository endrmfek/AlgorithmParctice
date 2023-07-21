def solution(word):
    answer = 0
    vowels = "AEIOU"
    bucket = []
    def dfs(length, data, depth):
        bucket.append(data)
        
        if depth == 5:
            return
        
        for i in range(length):
            dfs(length, data + vowels[i], depth+1)
    
    dfs(len(vowels), "", 0)
    
    return bucket.index(word)