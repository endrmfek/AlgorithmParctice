#isupper() islower() isdigit() isalnum() isalpha()
#upper() lower()
#title() #capitalize()
def solution(s):
    answer = []
    for word in s.split(' '):
        answer.append(word.capitalize())    
        
    return ' '.join(answer)