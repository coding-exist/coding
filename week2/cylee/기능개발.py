import math
def get_dueto_day(current_percent, per_percent):
    return math.ceil((100-current_percent) / per_percent)

def solution(progresses, speeds):
    answer = []
    limit_days = []
    for i in range(len(speeds)):
        # 소요일수 구하고
        limit_days.append(get_dueto_day(progresses[i], speeds[i]))

    pre = limit_days[0]
    count = 1
    for idx, i in enumerate(limit_days):
        # 다음이 같거나 작으면 카운팅
        if(idx ==0): continue
        if(i<=pre): count += 1
        else:
            answer.append(count)
            count = 1
            pre = i
    answer.append(count)
    
        
    return answer

print(solution([98,99,98]	,[1, 1,1]		))