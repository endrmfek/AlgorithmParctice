from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque()
    time = 0 
    hap = 0
    
    for i in range(len(truck_weights)):
        truck = truck_weights[i]
        
        while True:
            if not bridge:
                bridge.append(truck)
                time += 1
                hap += truck
                break;
            elif len(bridge) == bridge_length:
                hap -= bridge.popleft()
            else:
                if hap + truck <= weight:
                    bridge.append(truck)
                    hap += truck
                    time += 1
                    break;
                else:
                    bridge.append(0)
                    time += 1
    
    return time + bridge_length