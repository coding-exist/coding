from collections import defaultdict
def solution(clothes):
    answer = 1
    clothes_dict = defaultdict(int)
    for name, category in clothes:
        clothes_dict[category] += 1
    
    for i in clothes_dict:
        answer *= clothes_dict[i] + 1

    return answer-1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	))