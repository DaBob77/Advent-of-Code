file = open("02.txt", "r")
count = 0

def checkSaftey(line):
    n = len(line)

    if int(line[0]) < int(line[1]):
        direction = 1
    elif int(line[0]) > int(line[1]):
        direction = -1
    else:
        return 1

    for i in range(n - 1):
        current = int(line[i])
        next = int(line[i + 1])

        if direction == 1:
            if not (current < next and 1 <= next - current <= 3):
                return i + 1
                
        elif direction == -1:
            if not (current > next and 1 <= current - next <= 3):
                return i + 1
    return "Safe"

for aline in file:
    levels = aline.split()
    if checkSaftey(levels) != "Safe":
        print(checkSaftey(levels))