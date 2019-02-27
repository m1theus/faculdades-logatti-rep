from pip._vendor.distlib.compat import raw_input
from random import randint

from Avaliacao import Avaliacao
from Movie import Movie

movie_list = []

menu = True


def create(nome, genero):
    filme: Movie = Movie(str(randint(100, 1000)), nome, genero)
    movie_list.append(filme)


def list():
    print("---------------")
    print("Lista de Filmes")
    for movie in movie_list:
        print(movie.id + " - " + movie.name + " - " + movie.genre)


def delete(id):
    for item in movie_list:
        if item.id == id:
            movie_list.remove(item)
            break

def create_avaliacao(movie_id, descricao):
    avaliacao: Avaliacao = Avaliacao()
    avaliacao.id = str(randint(100, 1000))
    avaliacao.descricao = descricao
    for item in movie_list:
        if item.id == movie_id:
            item.avaliacao = avaliacao
            break

def create_relatorio():
    text = []
    for filme in movie_list:
        text.append(filme.name + ' - ' + filme.avaliacao.descricao + "\n")
    file = open("relatorio_filme.txt", "w")
    file.writelines(text)
    file.close()

while menu:
    print("""
    1.Inserir Filme
    2.Listar Filme
    3.Excluir Filme
    4.Inserir Avaliacão
    5.Imprimir Relatorio
    6.Sair
    """)
    menu = raw_input("Informe uma opção.")
    if menu == "1":
        nome = raw_input("Informe o nome do filme: ")
        genero = raw_input("Informe o genero do  filme: ")
        create(nome, genero)
        menu = True
    elif menu == "2":
        list()
        menu = True
    elif menu == "3":
        id = raw_input("Informe o id do filme: ")
        delete(id)
        menu = True
    elif menu == "4":
        movie_id = raw_input("Informe o id do filme: ")
        descricao = raw_input("Informe a avaliação:  ")
        create_avaliacao(movie_id, descricao)
        menu = True
    elif menu == "5":
        create_relatorio()
        menu = True
    elif menu == "6":
        menu = False
