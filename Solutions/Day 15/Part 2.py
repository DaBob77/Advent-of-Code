
print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")

file = open("Input/15.txt", "r")
robotPos = ()
oldMap = []
map = []
moves = ""
directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
count = 0

def step(move, pos):
    if move == "v":
        direction = directions[0]
    elif move == ">":
        direction = directions[1]
    elif move == "^":
        direction = directions[2]
    elif move == "<":
        direction = directions[3]
    
    newPos = pos[0] + direction[0], pos[1] + direction[1]
    
    if 0 <= newPos[0] < len(map) and 0 <= newPos[1] < len(map[0]):
        if map[newPos[0]][newPos[1]] == ".":
            map[newPos[0]][newPos[1]] = "@"
            map[pos[0]][pos[1]] = "."
            return newPos
        elif map[newPos[0]][newPos[1]] == "[":
            if direction[0] == 0:
                if pushHoriz(direction, newPos, (newPos[0], newPos[1] + 1)):
                    map[newPos[0]][newPos[1]] = "@"
                    map[pos[0]][pos[1]] = "."
                    return newPos
            else:
                if pushVert(direction, newPos, (newPos[0], newPos[1] + 1)):
                    map[newPos[0]][newPos[1]] = "@"
                    map[pos[0]][pos[1]] = "."
                    return newPos
        elif map[newPos[0]][newPos[1]] == "]":
            if direction[0] == 0:
                if pushHoriz(direction, (newPos[0], newPos[1] - 1), newPos):
                    map[newPos[0]][newPos[1]] = "@"
                    map[pos[0]][pos[1]] = "."
                    return newPos
            else:
                if pushVert(direction, (newPos[0], newPos[1] - 1), newPos):
                    map[newPos[0]][newPos[1]] = "@"
                    map[pos[0]][pos[1]] = "."
                    return newPos
    return pos 


def pushHoriz(move, lPos, rPos):
    newLPos = lPos[0] + move[0], lPos[1] + move[1]
    newRPos = rPos[0] + move[0], rPos[1] + move[1]
    if 0 <= newLPos[0] < len(map) and 0 <= newLPos[1] < len(map[0]) and 0 <= newRPos[0] < len(map) and 0 <= newRPos[1] < len(map[0]):
        newLChar = map[newLPos[0]][newLPos[1]]
        newRChar = map[newRPos[0]][newRPos[1]]
        if (newLChar == "]" and move == (0, -1)):
            if pushHoriz(move, (newLPos[0], newLPos[1] - 1), (newRPos[0], newRPos[1] - 1)) == False:
                return False
        elif (newRChar == "[" and move == (0, 1)):
            if pushHoriz(move, (newLPos[0], newLPos[1] + 1), (newRPos[0], newRPos[1] + 1)) == False:
                return False
        if newLChar == "#" or newRChar == "#":
            return False
        else:

            map[newLPos[0]][newLPos[1]] = "["
            map[newRPos[0]][newRPos[1]] = "]"
            map[lPos[0]][lPos[1] - move[1]] = "."
            map[rPos[0]][rPos[1] - move[1]] = "."
            return True
        
def pushVert(move, lPos, rPos):
    newLPos = lPos[0] + move[0], lPos[1] + move[1]
    newRPos = rPos[0] + move[0], rPos[1] + move[1]
    if 0 <= newLPos[0] < len(map) and 0 <= newLPos[1] < len(map[0]) and 0 <= newRPos[0] < len(map) and 0 <= newRPos[1] < len(map[0]):
        newLChar = map[newLPos[0]][newLPos[1]]
        newRChar = map[newRPos[0]][newRPos[1]]
        if newLChar == "[" and newRChar == "]":
            if pushVert(move, newLPos, newRPos) == False:
                return False
        elif newLChar == "]" and newRChar == "[":
            lBox = pushVert(move, (newLPos[0], newLPos[1] - 1), (newLPos[0], newLPos[1]))
            rBox = pushVert(move, (newRPos[0], newRPos[1]), (newRPos[0], newRPos[1] + 1))
            if lBox == False and rBox == False:
                return False
            elif lBox == False:
                pushVert((-move[0], 0), (newRPos[0], newRPos[1]), (newRPos[0], newRPos[1] + 1))
            elif rBox == False:
                pushVert((-move[0], 0), (newLPos[0] - 1, newRPos[1] - 2), (newLPos[0] - 1, newRPos[1] - 1))
                return False
        elif newRChar == "[":
            if pushVert(move, (newLPos[0], newLPos[1] + 1), (newRPos[0], newRPos[1] + 1)) == False:
                return False
        elif newLChar == "]":
            if pushVert(move, (newLPos[0], newLPos[1] - 1), (newRPos[0], newRPos[1] - 1)) == False:
                return False

        
        if newLChar == "#" or newRChar == "#":
            return False
        else:
            map[newLPos[0]][newLPos[1]] = "["
            map[newRPos[0]][newRPos[1]] = "]"
            map[lPos[0]][lPos[1]] = "."
            map[rPos[0]][rPos[1]] = "."
            return True
    




readMoves = False
for aline in file:

    if aline == "\n":
        readMoves = True
        continue
    if not readMoves:
        oldMap.append(list(aline.strip()))
    else:
        moves += aline.strip()

for i in range(len(oldMap)):
    map.append([])
    for j in range(len(oldMap)):
        if oldMap[i][j] == "@":
            map[i].append("@")
            map[i].append(".")
        elif oldMap[i][j] == "O":
            map[i].append("[")
            map[i].append("]")
        else:
            map[i].append(oldMap[i][j])
            map[i].append(oldMap[i][j])



for i in range(len(map)):
    for j in range(len(map[i])):
        if map[i][j] == "@":
            robotPos = (i, j)




for i in range(len(moves)):
    robotPos = (step(moves[i], robotPos))


for i in range(len(map)):
    for j in range(len(map[i])):
        if map[i][j] == "[":
            count += 100 * i + j
            print(i, j, count)

for i in range(len(map)):
    print("".join(map[i]))

print(count)