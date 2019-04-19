def counting_sort(lista, inicio, fim):
    copia = lista[:]
    maximo = max(copia)
    ocorrencias = [0] * (maximo + 1)

    for i in range(len(copia)):
        ocorrencias[copia[i]] += 1
    
    for i in range(len(ocorrencias) - 1):
        ocorrencias[i + 1] += ocorrencias[i]

    resultado = [None] * len(lista)

    for i in range(fim, inicio - 1, -1):
        elemento = lista[i]
        ocorrencias[elemento] -= 1
        resultado[ocorrencias[elemento]] = elemento
    
    for i in range(len(resultado)):
        lista[i] = resultado[i]

lista = [1,1,1,1,1,1,1,1,0]#[4,1,8,3,3,3,3,3,3,1,8,7,123,32,58,83]
counting_sort(lista, 0, len(lista) - 1)
print lista