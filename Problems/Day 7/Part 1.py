import itertools

# Read input file
file = open("Input/07.txt", "r")
puzzle = []

# Parse input
for line in file:
    temp = line.split()
    for i, item in enumerate(temp):
        if ":" in item:
            temp[0] = item.replace(":", "")
    puzzle.append(temp)
file.close()

total = 0


for line in puzzle:
    expected = int(line[0]) 
    numbers = [int(x) for x in line[2:]]
    initial = int(line[1])  
    found = False
    
    for operators in itertools.product(['+', '*'], repeat=len(numbers)):
        current = initial
        
        for num, operator in zip(numbers, operators):
            if operator == '+':
                current += num
            else:
                current *= num
                
        if current == expected:
            total += current
            found = True
            break
            
    if not found:
        print(line, "failed")

print("Final total:", total)