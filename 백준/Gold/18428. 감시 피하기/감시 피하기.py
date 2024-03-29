from itertools import combinations

n = int(input())
board = []
teacher = []
spaces = []

for i in range(n):
  board.append(list(input().split()))
  for j in range(n):
    if board[i][j] == 'T':
      teacher.append((i,j))
      
    if board[i][j] == 'X':
      spaces.append((i,j))

def watch(x,y,d):
  if d == 0:
    while y >=0:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      y -=1

  if d == 1:
    while y<n:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      y += 1

  if d == 2:
    while x>=0:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      x -= 1

  if d==3:
    while x<n:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      x += 1

def process():

  for x , y in teacher:

    for i in range(4):
      
      if watch(x,y,i):
        return True
      
  return False

find = False
for data in combinations(spaces, 3):

  for x , y in data:
    board[x][y] = 'O'

    if not process():
      find= True
      break;
    
  for x, y in data:
    board[x][y] = "X"

if find:
  print("YES")
else:
  print("NO")