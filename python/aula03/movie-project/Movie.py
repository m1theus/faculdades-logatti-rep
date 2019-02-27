from Avaliacao import Avaliacao


class Movie:
    def __init__(self, id: str, name: str, genre: str):
        self.id = id
        self.name = name
        self.genre = genre
        self.avaliacao = Avaliacao()
