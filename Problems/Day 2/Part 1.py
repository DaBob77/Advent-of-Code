file = open("02.txt", "r")
count = 0

for aline in file: #loops throuhg a file
    levels = aline.split()
    n = len(levels)

    if int(levels[0]) < int(levels[1]):
        direction = 1
    elif int(levels[0]) > int(levels[1]):
        direction = -1
    else:
        continue

    unsafe = False

    for i in range(n - 1): 
        current = int(levels[i])
        next = int(levels[i + 1])

        if direction == 1:
            if not (current < next and 1 <= next - current <= 3):
                unsafe = True
                break
                
        elif direction == -1:
            if not (current > next and 1 <= current - next <= 3):
                unsafe = True
                break
    if not unsafe:
        count += 1

print(count)
file.close()