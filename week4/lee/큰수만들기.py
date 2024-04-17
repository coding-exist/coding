def solution(number, k):
    answer = []

    for i in number:
        while k>0 and answer and answer[-1] < i: # 순서대로 돌아가면서 큰수가 나오면 앞에넣기
            answer.pop()
            k -= 1
        answer.append(i)
   
    return ''.join(answer[:len(answer)-k])

print(solution("332211"	,2))