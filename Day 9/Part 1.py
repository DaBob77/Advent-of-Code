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
            expanded.append(str(i//2))
    else:
        for j in range(int(input[i])):
            expanded += '.'

for i in range(len(expanded) - 1, 0, -1):
    if expanded[i] != '.':
        for j in range(len(expanded)):
            if j < i:
                if expanded[j] == '.':
                   expanded[j] = expanded[i]
                   expanded[i] = "."
                   break
            else:
                break


for i in range(len(expanded)):
    if expanded[i] != ".":
       output += int(expanded[i]) * i

print(output)