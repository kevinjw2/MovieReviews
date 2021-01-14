import pandas as pd
import sys

def readFile(filename):
    #file = open(filename, 'r')
    #file.readline() #skip column names

    data = pd.read_csv(filename, sep=',')
    data = data.fillna('null')

    output = "USE personalMovieRecs;\n"
    for index, record in data.iterrows():
        outputLine = "INSERT INTO movie(Title, Director, Duration, ReleaseYear, LeadActor, LeadActress, Genre) VALUES ("
        outputLine += processDataElement(record['Title']) + ','
        outputLine += processDataElement(record['Director']) + ','
        outputLine += processDataElement(record['Length']) + ','
        outputLine += processDataElement(record['Year'], str) + ','
        outputLine += processDataElement(record['Actor']) + ','
        outputLine += processDataElement(record['Actress']) + ','
        outputLine += processDataElement(record['Subject'])
        outputLine += ');'

        output += outputLine + '\n'

    return output

def processDataElement(elem, expected=None):
    if elem == 'null':
        return elem
    elif type(elem) is int or type(elem) is long:
        if expected == str:
            return '\"' + str(elem) + '\"'
        return str(elem)
    elif type(elem) is float:
        return str(int(elem))
    else:
        return '\"' + elem + '\"'

if __name__ == "__main__":
    filename = sys.argv[1]
    output = readFile(filename)
    outputFile = open('data.sql', 'w')
    outputFile.write(output)
    #print(output)
