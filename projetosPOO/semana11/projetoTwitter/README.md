# Twitter

1. ### O que é?  
    O código refere-se a uma aplicação da atividade que pode ser verificada através do seguinte link:
    [Twitter](https://github.com/qxcodepoo/arcade/blob/master/base/025/Readme.md).
    Resumo geral:  
    O arquivo em questão implementa um modelo da rede social Twitter em que os usuários cadastrados podem seguir e serem seguidos por outros, assim como escrever mensagens para suas timelines de forma que que seja visível na própria e daqueles que o seguem. O projeto possui como foco o estudo da Associação Reflexiva.

2. ### Como fez?
    Foi criado exatamente três (3) classes em todo o código: **Tweet**, **User**, **Twitter**.  
    A primeira a ser citada, a ```class Tweet```, é responsável por armazenar o *id* da mensagem postada, o nome do usuário que a escreveu, o conteúdo e as pessoas que deram *like* na postagem em sua timeline. Para a questão da listagem de *likes*, há um método específico para a sua organização, o ```TreeMap<String,String> giveLike(String username)```, pois assim será adicionada ao toString() da classe com os nomes dos usuários ordenados.  
    A segunda, ```class User```, possui uma carga maior de variáveis como descrito no repositório do projeto, assim teremos o armazenamento do nome do usuário, a quantidade de mensagens não lidas, dois (2) *ArrayList* contendo os dados da própria timeline e dos próprios tweets; e três (3) *TreeMap's*, divididos em um responsável por organizar as mensagens da timeLine pelo *id* das mensagens, um para os seguidores e o último para as contas seguidas. Como métodos, teremos:  
     - ```void followUser(User other)```: que permite um usuário seguir a outro;
     - ```void unfollowUser(User other)```: retira um usuário em específico da lista de seguidos;
     - ```void twittar(Tweet tweet)```: adiciona uma mensagem na própria timeline e de seus seguidores;
     - ```void darLike(String username, int idTw)```: adiciona um usuário na lista de pessoas que gostaram de uma postagem;
     - ```TreeMap<Integer, Tweet> updateTimeLineOrdenered()```: atualiza o **TreeMap** da timeline;
     - ```void getTimeline()```: exibe a timeline;  
      
    Por último, a ```class Twitter``` é responsável por armazenar todos os usuários e mensagens postadas por eles no sistema, dessa forma ele os adiciona e chama os métodos para as ações de um usuário em específico chamado na main da aplicação, que por sua vez contém a estrutura do código que garante a interatividade com o código.

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Senti dificuldades em entender sobre a associação reflexiva, mas estudando melhor sobre.

5. ### Tempo estimado
    Em torno de 2 horas.