from queue import PriorityQueue
def solution(operations):# 실패
    answer = []
    negative_que = PriorityQueue()
    positive_que = PriorityQueue()

    for i in operations:
        al, num = i.split(" ")
        num = int(num)

        if(al == "I"):
            if(num > 0):
                positive_que.put(-num)
            else:
                negative_que.put(num)
        else:
            if(negative_que.empty() and positive_que.empty()): continue

            if(num == -1):
                negative_que.get()
            else:
                positive_que.get()


    return answer

print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	))