from copy import deepcopy

file = open("Input/06.txt", "r")
ogPuzzle = []
curPuzzle = []
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
dir = directions[0]
dirIterator = 0
count = 0



for aline in file:
    aline = aline.strip()
    temp = []
    for char in aline:
        temp.append(char)
    ogPuzzle.append(temp)



def checkPos():
    for x in range(len(curPuzzle)):
        for y in range(len(curPuzzle[x])):
            if curPuzzle[x][y] == "^":
                return int(x), int(y)


for i in range(len(ogPuzzle)):
    for j in range(len(ogPuzzle[i])):
        curPuzzle = deepcopy(ogPuzzle)
        if curPuzzle[i][j] == "#" or curPuzzle[i][j] == "^":
            continue
        else:
            curPuzzle[i][j] = "O"
        print("X:", i, "Y:", j)
        dir = directions[0]
        dirIterator = 0
        tracing = False
        startTracePos = None

        while True:
            pos = checkPos()
            newX = pos[0] + dir[0]
            newY = pos[1] + dir[1]

            if 0 <= newX < len(curPuzzle) and 0 <= newY < len(curPuzzle[0]):
                if curPuzzle[newX][newY] == '#' or curPuzzle[newX][newY] == "O":
                    dirIterator += 1
                    dir = directions[dirIterator % 4]
                else:
                    if curPuzzle[newX][newY] == 'x':
                        if tracing != True:
                            tracing = True
                            startTracePos = (newX, newY)
                        elif startTracePos == (newX, newY):
                            for x in curPuzzle:
                                print(x)
                            count += 1
                            break
                    else:
                        tracing = False

                    curPuzzle[newX][newY] = curPuzzle[pos[0]][pos[1]]  # Place character in new position
                    curPuzzle[pos[0]][pos[1]] = "x"

            else:
                break



print(count)
file.close()