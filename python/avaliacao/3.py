text = []

def create_file():
    output = open('./avaliacao/output.txt', 'w', encoding = 'utf-8')
    output.writelines(text)
    output.close()

file = open('avaliacao\\arquivo.txt', 'r', encoding = 'utf-8')
for linha in file.readlines():
    linha = linha.split(' ')
    text.append((f'O(a) {linha[0]} conhece {linha[1]} linguagens de programação.'))
file.close()
create_file()