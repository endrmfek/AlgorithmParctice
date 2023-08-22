class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        #k개 리턴해라.
        #2중for문 아마 안될걸?
        #sort해도 될거같긴한데
        
        data = []
        for x,y in points:
            dist = x*x + y*y
            data.append((dist,[x,y]))
            
        data.sort()
        result = []
        for i in range(k):
            result.append(data[i][1])
        
        return result
            