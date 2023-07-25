import functools

def solution1(numbers):
    numbers = list(map(str, numbers))
    
    #numbers 원소는 0이상 1000이하입니다.
    numbers.sort(key = lambda x : x*3 , reverse = True)
    
    return str(int(''.join(numbers)))

def solution(numbers):
    
    def comparator(a, b):
        t1 = a+b
        t2 = b+a
        
        return (int(t1) > int(t2)) - (int(t2) - int(t1))
    
    n = list(map(str, numbers))
    n = sorted(n, key=functools.cmp_to_key(comparator), reverse=True)
    return str(int(''.join(n)))
    


