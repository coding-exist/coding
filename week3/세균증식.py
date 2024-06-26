def solution(n, t):
    return n * (2**t)

# 세균 1시간에 2배 증식
# 처음 세균 n마리
# 경과 시간 t
# 2 * (1 + 1) = 4
# 2 * (2 * 2) = 8
# (n * (t*2)) * 2

# (7 * (15*2)) * 2

# n=7
# n*2 를 t만큼
# 처음 7 * (1*1) = 7
# 1시간7 * (1*1) = 14 => 7 * 2
# 2시간7 * (2*2) = 28 => 7 * 4
# 15시간7 * (15*15) = 
# n * (2**t)
# 7 * 2**15
# n=6
# 처음 6
# 6 * 1
# 1시간 12
# 6 * 2
# 2시간 24
# 6 * 4
# 6 * (2**2)


# n=5
# 처음 5
# 5*1
# 1시간
# 10 5 * 2
# 2시간
# 5 * (2**2) 20
# 3시간
# n * (2**t)
# 40 5 * (2**3)
