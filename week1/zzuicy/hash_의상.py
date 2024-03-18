def solution(clothes):
    cloth_map = {}
    answer = 1

    for _, cloth_type in clothes:
        cloth_map[cloth_type] = cloth_map.get(cloth_type, 0) + 1

    for key in cloth_map:
        answer *= cloth_map[key] + 1  # 아무것도 안입는 경우 +1

    return answer - 1  # 모든 종류의 옷을 모두 안입은 경우 -1
