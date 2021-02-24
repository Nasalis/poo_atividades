# Contato

- O projeto realizado apresenta como finalidade registrar os números de um **único** contato em sua agenda telefônica a informar a operadora e o número logo após, sendo precedidos pelo nome. Além disso, o código implementou a funcionalidade de remover um número através de sua posição em um Array (informada ao usuário) e um comando para que possa exibir a lista desses números adicionados. 

- O projeto foi desenvolvido através dos ensinamentos repassados pelo professor David Senna em sua aula a respeito de Arrays. Através disso, o código procura respeitar os requisitos definidos pelo próprio projeto durante suas implementações (funcionalidade dos métodos, variáveis e interatividade). Nesse ínterim, separo, de forma breve, o que compõe e executa a ação de cada comando no código:
    - Interatividade:
        - Para manter a interatividade durante a exeução do código, a variável _contato_ do tipo _Contatos_ foi criada para que possa receber os dados que correspondem ao nome, operadora e ao número, sendo esses dois últimos explicados posteriormente. Todos correspondendo a _Strings_ em razão de simplificar a manipulação de seus conteúdos.
    - Comando para criar contato:
        - Foi criado a partir do método _void criarContato_ definido para registrar o nome do contato desejado e, portanto, adicionar os seus respectivos números. Para que o processo seja iniciado de fato, o método recebe um parâmetro do tipo _String_ através do comando **new + nome de registro**. Por exemplo:  
        >```new Senna```
    - Comando para adicionar número:
        - Através do método _boolean adicionarNumero_ deverá ser repassado o conteúdo de um parâmetro do tipo _Telefone_ que deverá conter o nome da operadora e o número para que possa ser registrado. Nesse ponto temos a interação com a _class Telefone_ para que as informações sejam repassadas entre as classes.  
        O comando para interagir com esse método é __number + operadora + número__. Segue em seguida o exemplo:
        > ```number tim 89162356```
    - Comando validar número:
        - Na etapa para que possa ser adicionado um número, o conteúdo em questão deverá corresponder a um formato específico antes do seu registro, isto é, sem a presença de caracteres alfabéticos, tanto consoantes quanto vogais, sejam maiúsculas ou minúsculas. O método _boolean validarNumero_ verificará caractere por caractere da String a fim de conferir a validação.
    - Comando remover número:
        - Através da posição do Array indicada no vetor com os números registrados poderá escolher um conteúdo para que seja removido. Dessa forma, se tivermos 3 números e excluímos o que tiver na posição 1, o que outrora ocupava a posição posterior corresponderá a posição do anterior, e assim por diante. Método responsável: _boolean removerNumero_.  
        Para executae essa ação, faça **remover + valor da posição escolhida**. Exemplo:  
        > ```remover 2```
    - Comando exibir número:
        - Esse comando exibirá no terminal o nome do contato e um vetor com informações contendo a posição, a operadora e o número válido. Método responsável é o _void exibirContato_. Digite apenas "show". Para sair da execução do código, digite "sair".
- Em âmbito geral, a atividade foi realizada individualmente.
- Durante o processo de aprendizado aprendi melhor sobre como manipular Arrays com uma interação entre classes em um código interativo, além de conhecer melhor os métodos relacionados aos próprios Arrays e Strings cujos resultados de busca foram incrementados no código para que se aproximasse o máximo da formatação dos requisitos.
- Tempo estimado de 3 dias.