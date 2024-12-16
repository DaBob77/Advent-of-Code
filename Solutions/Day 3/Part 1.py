file = open("03.txt")
text = ""
startIndex = 0
endIndex = -1
enabled = True
result = 0
for aline in file:
    for i in aline:
        text = text + i


while startIndex != -1:
    startIndex = text.find("mul(", startIndex + 1)
    if startIndex != -1:
        endIndex = text.find(")", startIndex + 1, startIndex + 12)
        current = ""
        num1 = ""
        num2 = ""
        curNum = 1
        for i in range(startIndex, endIndex + 1):
            current = current + text[i]
            if text[i] == ",":
                curNum = 2
            if text[i].isdigit():
                if curNum == 1:
                    num1 = num1 + text[i]
                else:
                    num2 = num2 + text[i]
        if current:
            print(current)
            print(num1)
            print(num2)
            result += int(num1) * int(num2)

print(result)
file.close()