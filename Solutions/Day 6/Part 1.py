file = open("Input/06.txt", "r")
puzzle = []
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
dir = -1, 0
dirIterator = 0
count = 0


for aline in file:
    aline = aline.strip()
    temp = []
    for char in aline:
        temp.append(char)
    puzzle.append(temp)

def checkPos():
    for x in range(len(puzzle)):
        for y in range(len(puzzle[x])):
            if puzzle[x][y] == "^":
                return int(x), int(y)

while True:
    pos = checkPos()
    newX = pos[0] + dir[0]
    newY = pos[1] + dir[1]
    if 0 <= newX < len(puzzle) and 0 <= newY < len(puzzle[0]):
        if puzzle[newX][newY] == '#':
            dirIterator += 1
            dir = directions[dirIterator % 4]
        else:
            puzzle[newX][newY] = puzzle[pos[0]][pos[1]]  # Place character in new position
            puzzle[pos[0]][pos[1]] = "x"
    else:
        break

for i in puzzle:
    print(i)
    for j in i:
        if j == "x" or j == "^":
            count += 1
print(count)
    