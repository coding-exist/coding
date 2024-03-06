from collections import defaultdict
def solution(participant, completion):
    answer = ''
    start = defaultdict(int)
    end = defaultdict(int)
    for i in participant:
        start[i] += 1
    for i in completion:
        end[i] += 1
    for i in participant:
        if(start[i] != end[i]):
            answer = i
            
    
    return answer