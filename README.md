Exercicio desenvolvido para o trabalho 2 da cadeira de Programação Orientada a Objetos
# Exercício de Avaliação 2
1. Enunciado geral:
A ACMEFun comercializa itens de audiovisual (blu-rays e games) e já possui dados de seu
acervo armazenados em arquivo-texto e deseja uma aplicação que faça o processamento de dados
deste acervo.
Você será responsável pelo desenvolvimento da aplicação.
O analista de sistemas gerou um diagrama de classes inicial, com alguns atributos, operações
e relacionamentos apresentados a seguir.
O analista definiu as seguintes operações da interface Cobravel:
• calculaPrecoVenda(): calcula e retorna o preço de venda de um item.
• calculaImposto(): calcula e retorna o valor de imposto de um item.
Sabe-se que será necessário haver subclasses da classe abstrata Audiovisual. Cada
subclasse possui informações adicionais específicas:
• BluRay: possui uma duração (em minutos).
• Game: possui uma categoria (que pode ser: ACAO, ESPORTE, ESTRATEGIA,
SIMULACAO ou RPG).
O método calculaPrecoVenda() depende da subclasse:
• BluRay:
(preço base x duração) / 100
• Game: é o preço base acrescido de um percentual sobre o preço base conforme a
categoria: 20% se for ACAO; 30% se for ESPORTE; 40% se for ESTRATEGIA; 50%
se for SIMULACAO ou 70% se for RPG.
O método calculaImposto() depende da subclasse:
• BluRay: 40% do valor do preço de venda.
• Game: 50% do valor do preço de venda.
O método executa() da classe App deve realizar a sequência de passos:
1. Ler audiovisuais: lê todos os dados de audiovisuais e escreve a quantidade de
itens carregados com sucesso no formato: 1;quantidade de itens
carregados
2. Escrever informações dos itens: escreve algumas informações para cada item
carregado com sucesso no sistema, no formato: 2;título;valor do preço
final;valor do imposto
3. Escrever quantos games RPG foram cadastrados: escreve a quantidade de
games da categoria RPG que foram carregados no sistema no formato:
3;quantidade de games RPG
4. Escrever o BluRay com imposto mais próximo da média: calcula a média dos
valores de imposto de BluRays carregados e escreve qual BluRay possui o valor
de imposto mais próximo da média calculada, no formato: 4:média dos valores
de impostos de BluRays;título do BluRay com imposto mais
próximo da média. Caso não haja BluRays, escreve no formato: 4:Nenhum
BluRay
A leitura de dados deverá ser realizada no arquivo dados.csv e a escrita de dados deverá ser
realizada no arquivo resultado.csv. Exemplos destes arquivos encontram-se no Apêndice.
