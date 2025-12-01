file = open("Input/10.txt", "r")
puzzle = []
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
count = 0

def checkNext(value, currentX, currentY):
    values = []
    for i in directions:
        nextY = currentY + i[0]
        nextX = currentX + i[1]
        
        if 0 <= nextY < len(puzzle) and 0 <= nextX < len(puzzle[0]): 

            next = puzzle[nextY][nextX]
            if next - value == 1:
                values.append((nextY, nextX))
    if values != []:
        return
    return None



for aline in file:
    temp = []
    for char in aline:
        if char != "\n":
            temp.append(char)
    puzzle.append(temp)

temps = []
for i in puzzle:
    temp = list(map(int, i))
    temps.append(temp)

puzzle = temps

for y in range(len(puzzle)):
    for x in range(len(puzzle[y])):
        if puzzle[y][x] == 0:
            value = puzzle[y][x]
            pos = (y, x)
            values = checkNext(value, pos[1], pos[0])
            checkNext(value, pos[1], pos[0])


                    


for i in range(len(puzzle)):
    print(puzzle[i])

print(count)