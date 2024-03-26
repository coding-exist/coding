from itertools import product
def solution(word):
    answer = 0
    al_list = ['A', 'E', 'I', 'O', 'U']
    total = []
    for i in range(1,6):
        for each in product(al_list, repeat=i): # 중복 허용해서 1~6뽑기
            total.append(''.join(each))
    total.sort()
    return total.index(word)+1

print(solution("AAAAE"))