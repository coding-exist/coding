def solution(my_string, n):
    list = []
    for i in my_string:
        list.append(i * n)
    return ''.join([str(x) for x in list])


# 