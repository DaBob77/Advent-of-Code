file = open("Input/16.txt", "r")
map = []
startPos = ()
endPos = ()
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
key = [">", "v", "<", "^"]
dirCount = 0
pos = (None, None)
count = 0

def step(pos): #Returns -1 if end, False if dead end, True if else
    for i in range(len(directions)):
        newPos = pos[0] + directions[i][0], pos[1] + directions[i][1]
        if 0 <= newPos[0] < len(map) and 0 <= newPos[1] < len(map[1]):
            if map[newPos[0]][newPos[1]] == "E":
                return -1
            if map[newPos[0]][newPos[1]] != ".":
                continue
            else:
                map[newPos[0]][newPos[1]] = key[i]
                return True, newPos
    return False

def reset():
    for i in range(len(map)):
        for j in range(len(map[i])):
            if map[i][j] == "v" or map[i][j] == "<" or map[i][j] == "^" or map[i][j] == ">":
                map[i][j] = "." 

for aline in file:
    map.append(list(aline.strip()))

for i in range(len(map)):
    for j in range(len(map[i])):
        if map[i][j] == "S":
            startPos = (i,  j)
        if map[i][j] == "E":
            endPos = (i, j)

pos = startPos
while pos != endPos:
    for i in range(count):
        result = step(pos)
        if result == -1:
            print("AOIJSDOIJASDOIJ")
            break
        elif result != False:
            pos = result[1]
        else:
            pos = startPos
            reset()
        for j in map:
            print("".join(j))
        input("Continue")
        
    count += 1


