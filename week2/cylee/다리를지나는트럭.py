def solution(bridge_length, weight, truck_weights):
    first = truck_weights.pop(0)
    total = first
    time = 1

    bridge = [0 for i in range(bridge_length-1)] + [first] # 첫번째 트럭이 이미 올라간 상황으로 가정
    while truck_weights or sum(bridge) != 0:
        time += 1
        each = bridge.pop(0) # 다리를 완전히 지나감
        
        total -= each # 지나간 무게를 빼줌
        if(truck_weights != []): # 남아있는 트럭이 있을때
            if(total+truck_weights[0] <= weight): # 올라갈 트럭 + 현재 다리에 있는무게 비교
                next = truck_weights.pop(0)
                bridge.append(next)
                total += next
            else: 
                bridge.append(0)

    return time

print(solution(2,10,[7,4,5,6]	))