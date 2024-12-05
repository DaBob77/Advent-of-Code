file = open("04.txt")
puzzle = []
count = 0

for aline in file:
    puzzle.append(aline.strip())

def check(row, column, horizDir, vertDir):
    global puzzle
    current = ""
    for char in range(4):  # count += check 4 characters
        try:
            current += puzzle[row + char * vertDir][column + char * horizDir]
        except IndexError:
            return 0
    return 1 if current == "XMAS" else 0




for i in range(len(puzzle)):
    for j in range(len(puzzle[i])):
        if puzzle[i][j] == "X":
            count += check(i, j, 1, 0) #Right
            count += check(i, j, -1, 0) #Left
            count += check(i, j, 0, 1) #Down
            count += check(i, j, 0, -1) #Up
            count += check(i, j, 1, 1) 
            count += check(i, j, 1, -1 ) 
            count += check(i, j, -1, 1)
            count += check(i, j, -1, -1)

print(count)
file.close()