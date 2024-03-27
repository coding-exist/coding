def solution(n, k):
    bonus = n // 10
    return (n * 12000) + ((k - bonus) * 2000)
# 양꼬치 1인분 12000
# 음료수 1개 2000
# 양꼬치 n인분 
# 음료수 k개
# (n * 12000) + (k * 2000)
# if divmod(k,10)[1] == 0 
# 
## 42.5점 왜틀린거여..?
#     a = 0
#   for i in range(n+1):
#       if divmod(i+1,10)[1] == 0:
#           a += 1
#   answer = (n * 12000) + (k * 2000) - (a * 2000)
#   return answer
