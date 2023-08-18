class MyQueue:

    def __init__(self):
        self.mainStack = []
        self.subStack = []

    def push(self, x: int) -> None:
        if not self.mainStack:
            self.mainStack.append(x)
            
        else: # 데이터가 들어있으면? 1,2,3을 차례로 넣었으면 stack에는 3,2,1로 들어가있어야돼.
            
            for data in self.mainStack[::-1]: # 1,2,3
                self.subStack.append(data)
            self.mainStack.clear()
            self.mainStack.append(x)
                
            for data in self.subStack[::-1]: # 3,2,1
                self.mainStack.append(data)
            self.subStack.clear()

    def pop(self) -> int:
        e = self.mainStack[-1]
        self.mainStack.pop()
        return e
        

    def peek(self) -> int:
        return self.mainStack[-1]

    def empty(self) -> bool:
        return False if self.mainStack else True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()