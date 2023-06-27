def solution(begin, end):
    #n일때 n*2 n*3 n*4
    def getDiv(num):
        if num == 1:
            return 0
        elif num <= 3:
            return 1
        
        tmp = []
        #가장 큰 약수 구해야돼.
        #i로 나눴는데 나머지가 0이야? -> 그 몫이 가장 큰 약수
        for i in range(2, int(num**0.5) + 1):
            if num % i == 0:
                d = int(num/i)
                #천만 넘어가면 안됨.
                if d <= 10000000:
                    return d
                else:
                    tmp.append(i)
        #가장 큰거.
        if tmp:
            return tmp[-1]
        
        return 1
        
    answer = [getDiv(i) for i in range(begin, end+1)]
    return answer