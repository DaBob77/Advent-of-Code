list1 = []
list2 = []
file = open("01.txt", "r")
lowestID1 = None
lowestID2 = None
output = 0

for aline in file:
    line = aline.split()
    list1.append(line[0])
    list2.append(line[1])


list1.sort()
list2.sort()

for i in range(len(list1)):
    instances = 0
    for j in range(len(list2)):
        if list1[i] == list2[j]:
            instances += 1
    output += int(list1[i]) * instances


print(output)
