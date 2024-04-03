def solution(my_string):
    list = []
    for i in my_string:
        if i in ['a', 'e', 'i', 'o', 'u']:
            continue
        list.append(i)
    return ''.join([str(x) for x in list])

# 