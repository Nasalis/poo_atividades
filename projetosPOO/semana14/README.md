# Whatsapp

1. ### O que é?  
    O código refere-se a uma aplicação da atividade que pode ser verificada através do seguinte link:
    [Whatsapp](https://github.com/qxcodepoo/arcade/blob/master/base/026/Readme.md).
    Resumo geral:  
    Esse projeto tem como objetivo simular algumas ações do aplicativo Whatsapp, como criar usuários, criar grupos, adicionar ou remover membros contidos nos grupos de conversa, bem como enviar mensagens, de forma que gere notificações ao lado do nome do grupo em que as mensagens foram enviadas.

2. ### Como fez?
    Para a execução e conclusão desse projeto foi necessário criar seis (6) classes, sendo elas: **class Whatsapp**, **class Chat**, **class User**, **class Msg**, **class Inbox** e **class Notify**. Dentre elas, as duas últimas citadas herdam os métodos da class-pai Conta.
    A classe principal - a que contém a main de todo projeto - é a ```class Whatsapp```, responsável pela inicialização do código sem estrutura interativa (apesar de saber construí-la como feito nos projetos anteriores); e armazenar em dois TreeMap's os usuários cadastros no sistema, assim como todos os grupos de chats. Temos os métodos e suas respectivas funções na seguinte tabela:  

    | Métodos    | Funções  |
    | :-------   | :------- |
    | verifyUser | verifica se um usuário existe | 
    | verifyChat | verifica se um chat existe |
    | createUser | cria um usuário para o sistema
    | createChat | cria um grupo de conversa |
    |createNotifyChats | cria notificações nos chats para cada usuário que recebe as mensagens
    | allUsers   | retorna todos os usuários cadastrados 
    | getChatsUser | retorna todos os grupos que um usuário está inserido |
    | getUsersChat | retprma todos os usuários de um grupo específico |
    | getNotifyUser | retorna as notificações de um usuário |
    | addByInvite | um usuário adiciona outro em um grupo que ele seja membro |
    | removeUserChat | remove um usuário de um grupo |
    | sendMessage | um usuário envia mensagem para um grupo |
    | readMessageUser | um usuário ler as mensagens não lidas |
    
    -------  


    A ```class Chat``` armazena o seu id, as caixas de mensagens, assim como os usuários contidos em um grupo de chat em específico.  
    Já a ```class User``` armazena o id de um usuário, os grupos que ele é membro e um List com as notificações de cada grupo se elas existirem.  
    Quanto a ```class Msg``` ela tem como objetivo apenas armazenar o conteúdo da mensagem enviada e o id do usuário que a enviou.  
    A ```class Inbox``` armazena um objeto do tipo User e um List com todas as mensagens enviadas até então em um determinado chat - grupo.  
    Por último, a ```class Notify``` que somente contém o id do chat que há alguma notificação e a quantidade de mensagens não lidas pelo usuário.
    

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Tive dificuldade em implementar o método de envio de mensagem, pois fiquei confuso quanto no gerenciamento de notificações.

5. ### Tempo estimado
    Em torno de 5 horas.