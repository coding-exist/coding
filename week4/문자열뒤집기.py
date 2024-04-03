def solution(my_string):
    list = []
    for i in my_string:
        list.insert(0, i)
    return ''.join([str(x) for x in list])