print('Olá Mundo!')

print('\n\n---------')
print('Exemplo 1:')
for item in [3,4,5,6,7] :
    print(item)

print('\n\n---------')
print('Exemplo 2:')
for x in [1,2]:
    print (x)
    break

else:
    print('else')

print('\n\n---------')
print('Exemplo 3:')
break_executado = False
for x in [1,2]:
    print(x)
    if(True):
        break_executado = True
        break

print('\n\n---------')
print('Exemplo 4:')
if(break_executado):
    print('else')
for letras in 'eXXcript':
    print('ciclo:', letras)

print('\n\n---------')
print('Exemplo  5:')
linguagens = ['C', 'Python', 'Lua', 'Cobol', 'Pascal', 'C++']
for lingua in linguagens:
    print('Linguagem contida na variável "lingua" neste ciclo: ', lingua)

print('\n\n---------')
print('Exemplo 6:')
for item in range(10):
    print(item)

print('\n\n---------')
print('Exemplo 7:')
for item in range(9, -1, -1):
    print(item)

print('\n\n---------')
print('Exemplo 8:')
i = 1
while i < 6:
    print(i)
    i += 1

print('\n\n---------')
print('Exemplo 9:')
i = 1
while i < 6:
    print(i)
    if i == 3:
        break
    i +=  1

print('\n\n---------')
print('Exemplo 10:')
x = int(1)
y = int(2.8)
z = int('3')

x = float(1)
y = float(2.8)
z = float('3')
w = float ('4.2')

x = str('s1')
y = str(2)
z = str(3.0)

print('\n\n---------')
print('Exemplo 11:')
a = 'Hello, World!'
print(a[1])

b = 'Hello, World!'
print(b[2:5])

a = 'Hello, World!'
print(a.lower())

a = 'Hello, World!'
print(a.upper())

a = 'Hello, World!'
print(a.replace('H', 'J'))

a = 'Hello, World!'
print(a.split(','))

print('\n\n---------')
print('Exemplo 12:')
thislist = ['apple', 'banana', 'cherry']
thislist.append('orange')
print(thislist)

thislist = ['apple', 'banana', 'cherry']
thislist.insert(1, 'orange')
print(thislist)

thislist = ['apple', 'banana', 'cherry']
thislist.remove('banana')
print(thislist)

thislist = ['apple', 'banana', 'cherry']
thislist.pop()
print(thislist)

thislist = ['apple', 'banana', 'cherry']
del thislist[0]
print(thislist)

thislist = ['apple', 'banana', 'cherry']
thislist.append('orange')
print(thislist)

thislist = ['apple', 'banana', 'cherry']
thislist.clear()
print(thislist)

print('\n\n---------')
print('Exemplo 13:')
print('Criando arquivo...\n')
arq = open('exemplo_13.txt', 'w')
texto = []
texto.append('Lista de Alunos\n')
texto.append('----\n')
texto.append('João da Silva\n')
texto.append('José Lima\n')
texto.append('Maria das Dores')
arq.writelines(texto)
print('Arquivo criado com sucesso!')
arq.close()

arq = open('exemplo_13.txt', 'r')
texto = arq.read()
print(texto)
arq.close()

arq = open('exemplo_13.txt', 'r')
texto = arq.readlines()
for linha in texto:
    print(linha)
arq.close()

print('\n\n---------')
print('Exemplo 14:')
palavras = ['chocolate', 'biscoito', 'cafe', 'suco', 'feijao', 'arroz']
palavras_ordenadas = sorted(palavras)
print(palavras_ordenadas)

print('\n\n---------')
print('Atividade 2:')
print('Criando arquivo...')
fileWrite = open('lista.txt', 'w')
texto = []
texto.append('Gol\n')
texto.append('Uno\n')
texto.append('Palio\n')
texto.append('Up!\n')
texto.append('Clio\n')
texto.append('Golf\n')
fileWrite.writelines(texto)
print('Arquivo criado com sucesso!')
fileWrite.close()

print('\n\n---------')
print('Lendo arquivo...')
fileRead = open('lista.txt', 'r')
texto = fileRead.readlines()
for linha in texto :
    print(linha)

listaOrdenada = sorted(texto)
print('\n\nOrdenação')
print('\n----------')
for linha in listaOrdenada :
    print(linha)

print('\n\nOrdenação inversa')
print('\n----------')
i = len(listaOrdenada) - 1
while i > -1:
    print(texto[i])
    i -= 1

print('\n\nOrdenação Com Numeração')
print('\n---------')
for i, linha in enumerate(listaOrdenada, start=1) :
    print (i, '-', linha)
fileRead.close()



