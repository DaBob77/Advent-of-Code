file = open("Input/09.txt", "r")
input = ""
expanded = ""
output = 0



for aline in file:
    input = aline

expanded = list(expanded)

for i in range(len(input)):
    if i % 2 == 0:
        for j in range(int(input[i])):
            expanded.append([str(i//2), input[i]])
    else:
        for j in range(int(input[i])):
            expanded.append(['.', input[i]])

for i in range(len(expanded) - 1, 0, -1):
    print(i)
    if expanded[i][0] != '.':
        for j in range(len(expanded)):
            if j < i:
                if expanded[j][0] == '.':
                    available = True
                    for x in range(int(expanded[i][1])):
                        if expanded[j + x][0] == '.':
                            continue
                        else:
                            available = False
                            break
                    if available:
                        for x in range(int(expanded[i][1])):
                            expanded[j + x][0] = expanded[i - x][0]
                            expanded[i - x][0] = "."
            else:
                break

for i in range(len(expanded)):
    if expanded[i][0] != ".":
        output += int(expanded[i][0]) * i

print(output)