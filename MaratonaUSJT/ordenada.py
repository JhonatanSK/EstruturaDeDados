# A entrada consiste em N+1 linhas. A primeira contém um inteiro N que indica a quantidade de
# valores na coleção (1 ≤ N ≤ 100). Cada uma das N linhas a seguir contém um único número inteiro
# que pertence à coleção cuja ordenação deseja-se verificar

qtd = int(input(""))
while(qtd <= 0):
    qtd = int(input(""))
vetor = []

for x in range(0, qtd, 1):
    valor = input("")
    vetor.append(valor)

aux = 0
valor = ""
for x in range(0, qtd, 1):

    if(aux > int(vetor[x])):
        valor = "fora de ordem"
        break
    elif (aux < int(vetor[x])):
        valor = "em ordem"
    aux = int(vetor[x])

print("")
print(valor)




        