
idade = input('Informe sua idade: ')
if int(idade) == 18:
    print('Você tem {0} anos.'.format(idade))
elif int(idade) > 18:
    print('Você tem {0} anos, você é maior de idade.'.format(idade))
elif int(idade) < 18:
    print('Você tem {0} anos, você é menor de idade.'.format(idade))