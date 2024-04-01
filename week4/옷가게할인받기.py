def solution(price):
    if price < 100000:
        return price
    elif 100000 <= price and 300000 > price:
        return int(price -price * 0.05)
    elif 300000 <= price and 500000 > price:
        return int(price -price * 0.1)
    elif 500000 <= price:
        return int(price - price * 0.2)
