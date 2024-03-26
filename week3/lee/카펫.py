def solution(brown, yellow):
    answer = []
    yac= []
    for i in range(1,yellow+1): # yellow타일의 가로 세로 길이 리스트 [1,2,3,6] 바깥쪽 부터 짝짓기
        if yellow%i == 0:
            yac.append(i)

    for i in range(len(yac)//2+1): # 중간까지만 탐색
        if (yac[i]+2)*(yac[-1-i]+2)-yellow == brown: # 전체 넓이 - 노랑 = 갈색이면 
            answer.append(yac[-1-i]+2) # 가로 추가
            answer.append(yac[i]+2) # 세로 추가
            break
    return answer