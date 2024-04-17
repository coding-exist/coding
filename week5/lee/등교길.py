def solution(m, n, puddles):
    answer = 0
    dp = [[[int(1e9),1] for i in range(m)] for j in range(n)]
    
    # for i in dp:
    #     print(i)

    dp[0][0] = [0,1]

    for i in range(n):
        for j in range(m):
            if i==0 and j==0: continue
            if([i+1,j+1] in puddles):
                continue
            if(0<=i-1<n and 0<=j-1<m):
                if(dp[i-1][j][0] == dp[i][j-1][0]):
                    dp[i][j] = [dp[i][j-1][0]+1, dp[i][j-1][1]+dp[i-1][j][1]]
                else:
                    dp[i][j] = [min(dp[i][j-1][0], dp[i-1][j][0])+1 ,1]
            else:
                if(0<=i-1<n):
                    dp[i][j] = [dp[i-1][j][0] + 1, 1]
                elif 0<=j-1<m:
                    dp[i][j] = [dp[i][j-1][0] + 1, 1]
            # for q in dp:
            #     print(q)
            # print()
    return dp[-1][-1][1]

print(solution(4,3,[[2, 2]]	))