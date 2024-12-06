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
    if aline[0] < 1176:
        rules.append(aline[1][0:2])
        rules.append(aline[1][3:5])
    elif aline[0] > 1177:
        temp = []
        temp.append(aline[1])
        for i in temp:
            i = i.strip()
            updates.append(i.split(","))

for update in updates:
    isCorrect = True
    for i in range(0, len(rules), 2):
        if rules[i] in update and rules[i+1] in update:
            if checkUpdate(update, rules[i], rules[i+1]) == False:
                isCorrect = False
                break
    if isCorrect:
        updates.remove(update)

for update in updates:
    isCorrect = False
    for i in range(0, len(rules), 2):
        if not isCorrect:
            if rules[i] in update and rules[i+1] in update:
                #do some sorting
                isCorrect = checkUpdate(update, rules[i], rules[i+1])
        else:
            #find middle number, add to ouputd


        
print(updates)