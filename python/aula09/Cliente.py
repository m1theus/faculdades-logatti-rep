class Cliente:
    def __init__(self):
        self._id
        self._nome
        self._telefone
        self._endereco
        self._estado
        self._data_nascimento

    def get_id(self):
        return self._id

    def set_id(self, id):
        self._id = id

    def get_nome(self):
        return self._nome

    def set_nome(self, nome):
        self._nome = nome

    def get_telefone(self):
        return self._telefone

    def set_telefone(self, telefone):
        self._telefone = telefone

    def get_endereco(self):
        return self._endereco
    
    def set_endereco(self, endereco):
        self._endereco = endereco

    def get_estado(self):
        return self._estado
    
    def set_estado(self, estado):
        self._estado = estado

    def get_data_nascimento(self):
        return self._data_nascimento

    def set_data_nascimento(self, nascimento):
        self._data_nascimento = nascimento