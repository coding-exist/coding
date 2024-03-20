def solution(s):
    answer = True
    
    stack = []
    for i in s:
        if(i==')'): # 닫는 괄호일때 
            if(len(stack) == 0 or stack.pop(-1) != '('): #스택에서 추출한뒤 쌍이 맞는지 비교
                answer = False
                break
        else:
            stack.append(i)
        
    return answer and len(stack) == 0