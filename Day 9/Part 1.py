file = open("Input/09.txt", "r")
input = ""
expanded = ""
output = 0



for aline in file:
    input = aline


for i in range(len(input)):
    if i % 2 == 0:
        for j in range(int(input[i])):
            expanded += str(i//2)
    else:
        for j in range(int(input[i])):
            expanded += '.'
print(expanded)

expanded = list(expanded)
for i in range(len(expanded) - 1, 0, -1):
    print(i)
    if expanded[i] != '.':
        for j in range(len(expanded)):
            if expanded[j] == '.':
                expanded[j] = expanded[i]
                expanded[i] = "."
                break

expanded = "".join(expanded)
print(expanded)

for i in range(len(expanded)):
    if expanded[i] != '.':
        output += int(expanded[i]) * i

print(output)