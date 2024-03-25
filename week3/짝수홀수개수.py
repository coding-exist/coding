def solution(num_list):
    answer = []
    a, b = 0, 0
    for i in num_list:
        if i%2 == 0:
            a += 1
        else:
            b += 1
    answer.insert(0, a)
    answer.append(b)
    return answer
# 오호...

# def solution(num_list):
#   answer = [0,0]
#   for n in num_list:
#      answer[n%2]+=1
#   return answer