class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        #newInterval을 계속 바꿔보자.
        
        n = len(intervals)
        if n == 0:
            intervals.append(newInterval)
            return intervals
        
        ans = []
        for index, value in enumerate(intervals):
            start, end = value[0], value[1]
            if newInterval[1] < start:
                ans.append(newInterval)
                return ans + intervals[index:]
            elif end < newInterval[0]:
                ans.append([start,end])
            else:
                newInterval = [min(newInterval[0], start), max(newInterval[1],end)]
            
        ans.append(newInterval)
        return ans
        
        