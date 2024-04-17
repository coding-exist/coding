def solution(triangle):
    answer = 0
    dp = [[0 for j in range(i+1)] for i in range(len(triangle))]
    # print(dp)
    for idx,i in enumerate(dp):
        if idx == 0:# 맨처음은 그냥 넣어주기
            dp[idx][0] = triangle[0][0]
            continue

        for idxj, j in enumerate(i):
            if idxj == 0:#처음
                dp[idx][idxj] = dp[idx-1][0]+triangle[idx][idxj]
            elif idxj == len(i)-1:# 마지막
                dp[idx][idxj] = dp[idx-1][idxj-1]+triangle[idx][idxj]
            else:
                dp[idx][idxj] = max(dp[idx-1][idxj-1], dp[idx-1][idxj]) + triangle[idx][idxj]


    return max(dp[-1])

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	))