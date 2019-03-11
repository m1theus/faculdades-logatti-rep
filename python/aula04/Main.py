import re
socios = []
empresas = []
dados_formatada = []
dados = []

def create_info(dado):
    pass

def create_empresas(dado):
    dado = dado[16:166]
    dado = dado = dado.strip()
    if len(dado) <= 150:
        dado = dado + '\n'
        empresas.append(dado)

def create_socios(dado):
    dado = dado[33:182]
    dado = dado.strip()
    if len(dado) <= 150:
        dado = dado + '\n'
        socios.append(dado)

file = open('SociosAC.txt', 'r')
dados = file.readlines()
for line in dados:
    create_info(line)
    tipo_dado = line[0:2]
    if tipo_dado == '01':
        create_empresas(line)
    elif tipo_dado == '02':
        create_socios(line)
file.close()



file = open('socios.txt', 'w')
file.writelines(socios)
file.close()


file = open('empresas.txt', 'w')
file.writelines(empresas)
file.close()