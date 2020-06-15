qtd = int(input(""))
while(qtd <= 0):
    qtd = int(input(""))
vetor = []

def result(casa, visitante, total):
    if(total <= 4 and casa == visitante):
        return "sem graça"
    elif(total == 6 and casa == visitante):
	    return "emocionante"
    elif(casa > (visitante + 3) or visitante > (casa + 3)):
        return "goleada"
    return "normal"

for x in range(0, qtd, 1):
    
    partida = input("")

    casa = int(partida[0:1])
    visitante = int(partida[2:3])
    total = casa + visitante
    if(casa > 0 and visitante > 0):
        vetor.append(result(casa, visitante, total))
        


for x in range(0, qtd, 1):
    print (vetor[x])
