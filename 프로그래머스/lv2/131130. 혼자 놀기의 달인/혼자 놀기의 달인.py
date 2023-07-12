def solution(cards):
    answer = []
    visited = [False] * len(cards)
    for i in range(len(cards)):
        temp = []
        while cards[i] not in temp and not visited[i]:
            temp.append(cards[i])
            visited[i] = True
            i = cards[i] - 1
        answer.append(temp)
    answer.sort(key=len)
    
    
    return len(answer[-1]) * len(answer[-2])