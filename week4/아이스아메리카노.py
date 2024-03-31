def solution(money):
    
    a = divmod(money, 5500)[0]
    b = money - 5500 * a
    return [a, b]