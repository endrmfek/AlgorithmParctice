def solution(n):
    answer = []
    def hanoi(n, from_pos, base, to_pos):
        if n == 1:
            answer.append([from_pos, to_pos])
            return

        # n-1개를 (to_pos)를 거쳐 (base)도착점 으로 가야지
        hanoi(n-1, from_pos, to_pos, base)
        # 1개짜리 (가장 큰거 옮겨)
        answer.append([from_pos, to_pos])
        #base에 있는거 to로 옮겨
        hanoi(n-1, base, from_pos, to_pos)
    
    hanoi(n,1,2,3)
    return answer