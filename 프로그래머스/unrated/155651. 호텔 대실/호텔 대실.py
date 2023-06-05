def timeToInt(time):
  hour = int(time[:2])
  minute = int(time[3:])
  return hour * 60 + minute

def solution(book_time):
  answer = 0
  minutes = [0] * (1440 + 10)

  for bookTime in book_time:
    start = timeToInt(bookTime[0])
    end = timeToInt(bookTime[1])
    minutes[start] += 1
    minutes[end+10] += -1

  total = 0
  for i in range(len(minutes)):
    total += minutes[i]
    minutes[i] = total

  return max(minutes)