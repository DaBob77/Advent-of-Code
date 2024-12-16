file = open("04.txt")
puzzle = []
count = 0

for aline in file:
    puzzle.append(aline.strip())

def check(row, column, vertDir, horizDir):
    global puzzle
    current = ""
    for char in range(3):  # count += check 3 characters
        try:
            current += puzzle[row + char * vertDir][column + char * horizDir]
        except IndexError:
            return 0
    return 1 if current == "MAS" or current == "SAM" else 0




for i in range(len(puzzle)):
    for j in range(len(puzzle[i])):
        if puzzle[i][j] == "A":
            if check(i-1, j-1, 1, 1) == 1: #Check top left down to bottom right
                count += check(i - 1, j + 1, 1, -1) #Bottom left to top right


print(count)
file.close()