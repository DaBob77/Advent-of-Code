file = open("Input/12.txt", "r")
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
puzzle = []
map = []
letters = []


def checkPerimeter(letter, y, x):
    count = 0
    for i in directions:
        nextY = y + i[0]
        nextX = x + i[1]
        if not (0 <= nextY < len(puzzle) and 0 <= nextX < len(puzzle[0]) and puzzle[nextY][nextX] == letter):
            count += 1
    return count


for aline in file:
    puzzle.append(aline.strip())

for i in range(len(puzzle)):
    for j in range(len(puzzle)):
        letter = puzzle[i][j]
        if letter not in letters:
            letters.append(letter)

for letter in letters:
    for i in range(len(puzzle)):
        for j in range(len(puzzle)):
            if puzzle[i][j] == letter:
                
            

        