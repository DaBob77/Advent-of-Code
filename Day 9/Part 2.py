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
    if expanded[i][0] != '.':
        for j in range(len(expanded)):
            if j < i:
                if expanded[j][0] == '.' and expanded[i][1] == expanded[j][1]:
                    print(expanded[i], expanded[j])
                    expanded[j][0] = expanded[i][0]
                    expanded[i][0] = "."
                    break
            else:
                break

for i in range(len(expanded)):
    if expanded[i][0] != ".":
        output += int(expanded[i][0]) * i

print(output)