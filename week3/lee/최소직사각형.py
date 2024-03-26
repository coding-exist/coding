def solution(sizes):
    answer = 0
    max_list = []
    min_list = []
    # 반복문 돌면서 큰값은 max_list, 작은 값은 min_list에 넣어주면서 마지막에는 각 리스트의 최대값을 곱합
    for w,h in sizes:
        if(w>h):
            max_list.append(w)
            min_list.append(h)
        else:
            max_list.append(h)
            min_list.append(w)
    
    return max(max_list)*max(min_list)

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]	))