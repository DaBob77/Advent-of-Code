file = open("Input/05.txt", "r")
count = 0
rules = []
updates = []
finalList = []
output = 0


def checkUpdate(update, rule1, rule2):
    if update.index(rule1) < update.index(rule2):
        return True
    return False


for aline in file:
    aline = aline.strip()
    if "|" in aline:
        temp = aline.split("|")
        rules.append(temp[0])
        rules.append(temp[1])
    elif "," in aline:
        updates.append(aline.split(","))


filtered_updates = []
for update in updates:
    isCorrect = True
    for i in range(0, len(rules), 2):
        if rules[i] in update and rules[i+1] in update:
            if not checkUpdate(update, rules[i], rules[i+1]):
                isCorrect = False
                break
    if not isCorrect:
        filtered_updates.append(update)
updates = filtered_updates

print(updates)

for update in updates:
    isCorrect = False
    while not isCorrect:
        isCorrect = True

        for i in range(0, len(rules), 2):
            if rules[i] in update and rules[i+1] in update:
                rule1Index = update.index(rules[i])
                rule2Index = update.index(rules[i+1])

                if rule1Index > rule2Index:
                    update[rule1Index], update[rule2Index] = update[rule2Index], update[rule1Index]
                    count += 1
                    isCorrect = False

        if isCorrect:
            break

    middleIndex = len(update) // 2
    output += int(update[middleIndex])
    print(update)

print(output)