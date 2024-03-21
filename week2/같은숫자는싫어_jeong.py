def solution(arr):
    answer = []
    # 0 ~ 9
    # 중복 제거
    # 0 1 2 2 3 4
    # 순차적으로 보면서 선택적으로 아웃
    # 현재꺼와 다음꺼가 다르면 배열에 넣어
    # 근데 첫번째꺼는 무조건 들어가야겠지
    
    # 궁금: 왜 i 와 i-1 일까? i와 i+1 은 안되나?
    for i in range(len(arr)):
        if i == 0 or arr[i] != arr[i-1]:
            answer.append(arr[i])
            
    return answer
