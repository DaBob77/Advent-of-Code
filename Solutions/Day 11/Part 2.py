file = open("Input/11.txt", "r")
puzzle = []
newPuzzle = []


def blink():
    for i in range(len(puzzle)):
        if puzzle[i] == 0:
            newPuzzle.append(1)
        elif len(str(puzzle[i])) % 2 == 0:
            current = str(puzzle[i])
            middleIndex = len(current) //2
            newPuzzle.append(int(current[:middleIndex]))
            newPuzzle.append(int(current[middleIndex:]))
        else:
            newPuzzle.append(puzzle[i] * 2024)

def sort():
    puzzle.sort()
    print(puzzle)
    sortedPuzzle = []
    for i in range(len(puzzle)):
        for j in range(i + 1, len(puzzle)):
            if puzzle[i] == puzzle[j]:
                for k in sortedPuzzle:
                    if k[0] == puzzle[i]:
                        k[1] += 1
                        break
                else:
                    sortedPuzzle.append([puzzle[i], 2])
                    break
        else:
            sortedPuzzle.append([puzzle[i], 1])    
    print(sortedPuzzle)
    return sortedPuzzle


for aline in file:
    puzzle = aline.split()

puzzle = list(map(int, puzzle))



for i in range(6):
    newPuzzle = []
    sort()
    blink()
    puzzle = newPuzzle.copy()

print(newPuzzle)
print(len(newPuzzle))
