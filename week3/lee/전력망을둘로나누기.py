
def solution(n, wires): # 유니온 파인드로 풀었는데 왜 안되는지 모르겠음..
    def find(x):
        if(parents[x] != x):
            find(parents[x])
        return parents[x]
    
    def union(a, b):
        a = find(a)
        b = find(b)
        if a < b:
            parents[b] = a
        else:
            parents[a] = b

    answer = int(1e9)
    for idx, i in enumerate(wires):
        parents = [i for i in range(n+1)]
        for idx2,i2 in enumerate(wires):
            if(idx == idx2):
                continue
            else:
                union(i2[0], i2[1])
        sub1 = parents.count(find(i[0]))
        sub2 = parents.count(find(i[1]))
        answer = min(answer, abs(sub1-sub2))

    return answer

print(solution(4,[[1, 2], [1, 3], [1, 4]]	))