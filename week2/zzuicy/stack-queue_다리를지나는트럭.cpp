#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Truck
{
    int startTime = 0;
    int weight = 0;
};

int solution(int bridge_length, int weight, vector<int> truck_weights)
{
    int truckCount = truck_weights.size();
    if (truckCount == 1)
        return bridge_length + 1;

    int seconds = 0;
    int currentWeight = 0;
    queue<Truck> bridge;

    for (int i = 0; i < truckCount; i++)
    {
        int truckWeight = truck_weights[i];
        if (!bridge.empty() && bridge.front().startTime + bridge_length == seconds)
        {
            currentWeight -= bridge.front().weight;
            bridge.pop();
        }
            
        bool isReady = currentWeight + truckWeight <= weight && bridge.size() <= bridge_length;
        if (isReady)
        {
            seconds++;
        }
        else
        {
            int lastTruckStartTime = 0;
            while (!isReady)
            {
                lastTruckStartTime = bridge.front().startTime;
                currentWeight -= bridge.front().weight;
                bridge.pop();

                isReady = currentWeight + truckWeight <= weight && bridge.size() <= bridge_length;
            }

            seconds = lastTruckStartTime + bridge_length;
        }
        
        if (i == truckCount - 1)
            break;
        
        bridge.push({seconds, truckWeight});
        currentWeight += truckWeight;
    }

    return seconds + bridge_length;

}