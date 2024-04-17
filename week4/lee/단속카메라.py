def solution(routes):
    answer = 0
    routes.sort(key=lambda x:x[1]) # 진출시간 기준으로 정렬

    location = -30001 # 
    for start, end in routes:
        if(location < start): # 카메라 설치해야하는 경우
            answer += 1
            location = end
    return answer

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	))