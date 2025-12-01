list1 = []
list2 = []
file = open("01.txt", "r")
lowestID1 = None
lowestID2 = None
mismatch = 0

for aline in file:
    line = aline.split()
    list1.append(line[0])
    list2.append(line[1])


list1.sort()
list2.sort()

for i in range(len(list1)):
    mismatch += abs(int(list1[i]) - int(list2[i]))


print(mismatch)
