import json
import re
import codecs

socios = []
empresas = []
dados_formatado = []
dados = []
relatorios = []
TIPO_PF = '01'
TIPO_PJ = '02'

def get_socio_qualificacao(qualificacao):
       pdf = open('aula04/qualificacao-socio.txt', 'r')
       for line in pdf.readlines():
               if qualificacao == line[0:2]:
                       return str(line[3::].strip())

def create_info(dado, tipo_dado):
        if tipo_dado == TIPO_PJ:
                json_relatorio = '{"cnpj": "null", "socio": "null", "qualificacao_socio": "null"}'
                info_relatorio = json.loads(json_relatorio)
                info_relatorio["cnpj"] = dado[3:17]
                info_relatorio["socio"] = dado[33:182]
                info_relatorio["qualificacao_socio"] = get_socio_qualificacao(dado[31:33])
                str_relatorio = "CNPJ: " + info_relatorio["cnpj"] + " | " + "SOCIO: " + info_relatorio["socio"] + " | " + "QUALIFICACAO DO SOCIO: " + str(info_relatorio["qualificacao_socio"]) + "\n"
                relatorios.append(str_relatorio)

def create_empresas(dado):
    dado = dado[16:166]
    if len(dado) <= 150:
        dado = dado + '\n'
        empresas.append(dado)

def create_socios(dado):
    dado = dado[33:182]
    if len(dado) <= 150:
        dado = dado + '\n'
        socios.append(dado)

file = open('aula04/SociosAC.txt', 'r')
dados = file.readlines()
for line in dados:
    create_info(line.strip(), line[0:2])
    tipo_dado = line[0:2]
    if tipo_dado == TIPO_PF:
        create_empresas(line.strip())
    elif tipo_dado == TIPO_PJ:
        create_socios(line.strip())
file.close()

file = codecs.open('aula04/socios.txt', 'w', 'utf-8')
file.writelines(socios)
file.close()

file = codecs.open('aula04/empresas.txt', 'w', 'utf-8')
file.writelines(empresas)
file.close()

file = codecs.open('aula04/relatorio_info.txt', 'w', 'utf-8')
file.writelines(relatorios)
file.close()
