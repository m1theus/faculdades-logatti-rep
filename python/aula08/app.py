from flask import Flask, render_template, request
import pymongo
import json

app = Flask(__name__)
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["mydatabase"]
mycol = mydb["person"]


@app.route('/')
@app.route('/<name>')
def index(name=None):
    return render_template('index.html', name=name)

@app.route('/person', methods=['POST'])
def save_person():
    data = json.loads(request.data)
    db_status = mycol.insert_one(data)
    return '{"success": true}'

@app.route('/person', methods=['GET'])
def findAll_person(): 
    return 'Hi'