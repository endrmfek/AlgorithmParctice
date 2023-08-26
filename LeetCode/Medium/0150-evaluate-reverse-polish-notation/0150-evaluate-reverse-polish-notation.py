class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        #stack으로 풀면되는데?
        stack = []
        
        for token in tokens:
    
            if token == '+':
                b = int(stack.pop())
                a = int(stack.pop())
                result = a+b
                stack.append(result)
            elif token == '-':
                b = int(stack.pop())
                a = int(stack.pop())
                result = a-b
                stack.append(result)
            elif token == '*':
                b = int(stack.pop())
                a = int(stack.pop())
                result = a*b
                stack.append(result)
            elif token == '/':
                b = int(stack.pop())
                a = int(stack.pop())
                result = a/b
                stack.append(int(result))
            else:
                stack.append(token)
            
        
            
        
        return int(stack[0])
            
            
                
        