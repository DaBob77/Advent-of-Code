file = open("03.txt")
text = ""
startIndex = 0
endIndex = -1
enabled = True
result = 0
for aline in file:
    for i in aline:
        text = text + i
doPos = 0

while True:
    dontPos = text.find("don't()")
    if dontPos == -1:
        break

    doPos = text.find("do()", dontPos)
    if doPos == -1:
        break

    text = text[:dontPos] + text[doPos + 4:]
print(text)



while True:
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
    else:
        break

print(result)
file.close()