text = [];
file = open('file.txt', 'w')
text.append('Banana\n')
text.append('Orange\n')
text.append('Apple\n')
file.writelines(text)
file.close()
  
file = open('file.txt', 'r')
text = file.readlines()
for line in text:
    print(line)

print('\n\nSorted:\n')
i = len(text) - 1
while i > -1:
    print(text[i])
    i -= 1

file.close()
