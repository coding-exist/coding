from collections import defaultdict
def make_total_list_with_sort(total_dict):
    res = []
    for i in total_dict:
        res.append([i,total_dict[i]])
    res.sort(key=lambda x: x[1], reverse=True)
    return res

def solution(genres, plays):
    answer = []
    total = defaultdict(int)
    part = defaultdict(list)
    
    for idx,(g,p) in enumerate(zip(genres, plays)):
        total[g] += p
        part[g].append([p,idx])

    total_list = make_total_list_with_sort(total)

    for i in part:
        part[i].sort(key=lambda x: x[1])
        part[i].sort(key=lambda x: x[0], reverse=True)

    for category,total_count in total_list:
        idx_list = [i[1] for i in part[category][:2]]
        answer.extend(idx_list)

    return answer
print(solution(["classic", "pop", "classic", "classic", "pop"]	,[500, 600, 150, 800, 2500]	))