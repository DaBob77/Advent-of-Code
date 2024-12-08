from copy import deepcopy
count = 0

file = open("Input/08.txt", "r")
originalPuzzle = []
newPuzzle = []
antennas = []

def calcDist(x1, y1, x2, y2):
    return x2 - x1, y2 - y1


for aline in file:
    aline = aline.strip()
    temp = []
    for char in aline:
        temp.append(char)
    originalPuzzle.append(temp)

for x in range(len(originalPuzzle)):
    for y in range(len(originalPuzzle[x])):
        if originalPuzzle[x][y] != '.':
            antennas.append((originalPuzzle[x][y], x, y))


newPuzzle = deepcopy(originalPuzzle)
for i in range(len(antennas)):
    type = antennas[i][0]
    for j in range(i + 1, len(antennas)):
        if antennas[j][0] == type:
            print(antennas[i], antennas[j])
            dist = calcDist(antennas[i][1], antennas[i][2], antennas[j][1], antennas[j][2])
            print(dist)
            newX = 0
            newY = 0
            print("X:", newX, "Y:", newY)

            y = 1
            while True:
                newX = antennas[i][1] + dist[0] * y
                newY = antennas[i][2] + dist[1] * y
                if 0 <= newX < len(newPuzzle) and 0 <= newY < len(newPuzzle[0]):
                    newPuzzle[newX][newY] = "#"
                    y += 1
                else:
                    break

            y = -1
            while True:

                newX = antennas[i][1] + dist[0] * y
                newY = antennas[i][2] + dist[1] * y
                print("X:", newX, "Y:", newY)
                if 0 <= newX < len(newPuzzle) and 0 <= newY < len(newPuzzle[0]):
                    newPuzzle[newX][newY] = "#"
                    y -= 1
                else:
                    break

for i in range(len(newPuzzle)):
    print(newPuzzle[i])
    for j in newPuzzle[i]:
        if j != '.':
            count += 1

print(count)
