# TCP-Etapa-3

A inserção de dados iniciais é feita diretamente no banco de dados1, e o cadastro de novos dados ainda não será
implementado nesta versão da aplicação. Os seguintes dados são armazenados no sistema, e devem ser carregados
no início da aplicação:

  • Usuário: que possui id, nome de usuário, estado, categorias de produto de interesse.
  • Produto: que possui id, nome, solicitante (que é um usuário), grupo de avaliação, categoria de produto.
  • Grupo de Avaliação: que possui nome, produtos submetidos, membros do comitê de avaliação (que são
  usuários).

A aplicação deve ter três funcionalidades, descritas a seguir.

#Alocação	de	Produtos a	Membros	do	Comitê	de	Avaliação
  1. Usuário (um coordenador do comitê de avaliação) solicita ao sistema a alocação de produtos a membros do
  comitê de avaliação.
  2. Sistema solicita para qual Grupo de Avaliação deve ser feita a alocação (para a qual não foi feita alocação
  ainda), e quantos avaliadores (membros do comitê de avaliação) devem ser alocados para cada produto, que
  deve ser um número entre 2 e 5.
  3. Usuário informa os dados solicitados.
  4. Sistema faz a alocação dos produtos realizando o seguinte algoritmo
  a. Sistema inicializa um conjunto de alocação com todos produtos do Grupo de Avaliação
  b. Sistema escolhe o produto com menor id do conjunto
  c. Sistema selecionada membros do comitê de avaliação como candidatos, que devem atender os
  seguintes critérios
  i. membro que é o solicitante da avaliação do produto ou que pertence ao mesmo estado que
  o solicitante da avaliação é excluído
  ii. membro cujas categorias de produto de interesse não inclui o tópico relacionado ao produto
  é excluído
  iii. membro que já foi alocado para avaliar o produto é excluído
  d. Sistema ordena os membros candidatos pelo número de produtos já alocados a eles até o momento,
  em ordem crescente (considerar apenas o Grupo de Avaliação em questão). O id do usuário é
  utilizado como critério de desempate (usuário com menor id é antecessor de usuário com maior id).
  e. Sistema atribui a avaliação do produto ao primeiro membro da lista.
  f. Sistema exclui o produto atribuído do conjunto de alocação, e volta ao passo “b” caso o conjunto de
  produtos ainda não esteja vazio.
  g. Caso os produtos já tenham o número de avaliadores informados pelo usuário, o algoritmo termina.
  Caso contrário, voltar ao passo “a”.
  5. Sistema salva a alocação realizada, e exibe para o usuário uma lista dos produtos do Grupo de Avaliação e os
  seus respectivos avaliadores, e um log do processo de alocação da seguinte forma:
    a. Iniciando alocação.
    b. Produto id X alocado ao avaliador id Y
    c. [...]
    d. Fim da Locação.

#Atribuição	de	Notas	a	Produtos
  1. Usuário solicita informar uma nota a um produto, e sistema exibe a lista de produtos.
  2. Usuário seleciona um produto, e sistema exibe a lista de avaliadores
  3. Usuário seleciona um avaliador.
  4. Sistema solicita uma nota entre -3 e 3 para o produto, e usuário informa.
  5. Sistema armazena a nota informada, relacionando ela com o avaliador e com o produto.
  
#Seleção	de	Produtos
  1. Usuário solicita ao sistema relatório de produtos com qualidade aceitável.
  2. Sistema solicita a seleção de um Grupo de Avaliação, e usuário informa.
  3. Caso o Grupo de Avaliação não tenha sido alocado ou haja avaliações (notas) não recebidas para aquele
  Grupo de Avaliação, o sistema emite alerta.
  4. Caso contrário, sistema calcula a média das notas dos avaliadores e exibe os produtos em duas listas
  a. Artigos cuja média de notas é >= 0, aparecem na lista de produtos com qualidade aceitável, em
  ordem decrescente
  b. Artigos cuja média de notas é < 0, aparecem na lista de produtos com qualidade não aceitável, em
  ordem crescente
