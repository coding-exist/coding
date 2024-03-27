def solution(array, height):
    a = 0
    for i in array:
        if height < i:
            a += 1
    return a
# 
