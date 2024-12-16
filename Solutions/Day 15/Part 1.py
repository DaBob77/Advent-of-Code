file = open("Input/15.txt", "r")
robotPos = ()
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
        elif map[newPos[0]][newPos[1]] == "O":
            if push(direction, newPos):
                map[newPos[0]][newPos[1]] = "@"
                map[pos[0]][pos[1]] = "."
                return newPos




    return pos 


def push(move, pos):
    newPos = pos[0] + move[0], pos[1] + move[1]
    if 0 <= newPos[0] < len(map) and 0 <= newPos[1] < len(map[0]):
        if map[newPos[0]][newPos[1]] == "O":
            if push(move, newPos) == False:
                return False
        if map[newPos[0]][newPos[1]] == "#":
            return False
        else:
            map[newPos[0]][newPos[1]] = "O"
            map[pos[0]][pos[1]] = "."
            return True
    


readMoves = False
for aline in file:

    if aline == "\n":
        readMoves = True
        continue
    if not readMoves:
        map.append(list(aline.strip()))
    else:
        moves += aline.strip()



for i in range(len(map)):
    for j in range(len(map[i])):
        if map[i][j] == "@":
            robotPos = (i, j)




for i in range(len(moves)):
    robotPos = (step(moves[i], robotPos))


for i in range(len(map)):
    for j in range(len(map[i])):
        if map[i][j] == "O":
            count += 100 * i + j

print(count)