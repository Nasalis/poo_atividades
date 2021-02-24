# ContatoStar

1. ### O que é?  
    O código refere-se a uma aplicação da atividade que pode ser verificada através do seguinte link:
    [ContatoStar](https://github.com/qxcodepoo/arcade/blob/master/base/030/Readme.md).  
    De forma breve, o código desenvolvido trata-se de uma remodulação da atividade [Favoritos](https://github.com/qxcodepoo/arcade/blob/master/base/016/Readme.md), dessa vez aplicando os conhecimentos de Herança entre as classes. 

2. ### Como fez?
    Foram adicionadas as classes **ContatoPlus** e **AgendaPlus** com o objetivo de controlar os usuários que forem aderidos a lista de favoritos na agenda telefônica, dessa forma recebendo o símbolo diferencial descrito na atividade anterior - o *@* - quando chamasse o respectivo comando de exibição da lista de todos os contatos no terminal.  
    A classe **ContatoPlus** é responsável por identificar se um contato em específico contém a variável *starred* marcado com o valor **true**. Caso seja esse o caso, ele é direcionado a lista de contatos e recenbe o *@*. No contrário, é mantido na lista geral.  
    Já o **AgendaPlus** contém um ```TreeMap<String, ContatoPlus> bookmarks``` cuja funcionalidade dirigi-se unicamente em salvar os contatos favoritados. Além disso, essa classe possui duas funções: ```void bookMark(String id)``` e ```void ùnbookMark(String id)``` para favoritar e ao mesmo tempo retira o contato da lista de favoritos. 

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Consegui aprender e aplicar o uso de Herança numa recriação de código e as dificuldades vieram por conta da leitura no diagrama.

5. ### Tempo estimado
    Em torno de 1 hora e 20 minutos.