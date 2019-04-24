import pymongo

myclient = pymongo.MongoClient('mongodb://localhost:27017')
mydb = myclient['mydb']
mytable = mydb['mytable']

my_dict = { 'fName': 'Matheus', 'lName': 'Martins' }

succes = mytable.insert_one(my_dict)
if succes.inserted_id is not None:
    print('Registro inserido com sucesso!')
    print(my_dict)