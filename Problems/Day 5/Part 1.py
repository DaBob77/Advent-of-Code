file = open("Input/05.txt", "r")
count = 0
rules = []
updates = []
output = 0


def checkUpdate(update, rule1, rule2):
    if update.index(rule1) < update.index(rule2):
        
        return True
    return False


for aline in enumerate(file):
    if aline[0] < 21:
        rules.append(aline[1][0:2])
        rules.append(aline[1][3:5])
    elif aline[0] > 22:
        temp = []
        temp.append(aline[1])
        for i in temp:
            i = i.strip()
            updates.append(i.split(","))

for update in enumerate(updates):
    isCorrect = True
    for i in range(0, len(rules), 2):
        if rules[i] in update[1] and rules[i+1] in update[1]:
            if checkUpdate(update[1], rules[i], rules[i+1]) == False:
                isCorrect = False
                break
    if isCorrect:
        count += 1
        output += int(update[1][len(update[1]) // 2])
        
print(output)
print(count)