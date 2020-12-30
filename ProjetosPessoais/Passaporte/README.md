## Validação

O seguinte projeto pessoal procura simular um sistema de registro de um conjunto de informações a fim de realizar o cadastro de um passaporte de um indivíduo em específico. Além disso, todos os registros serão armazenados em um ArrayList de forma que sejam disponíveis para exibição a cada momento que um novo cadastro seja realizado. Como forma de criar um dinamismo nos registros, estou procurando criar uma forma de estruturar um código de vigilância dos cadastros na finalidade de verificar se não há nenhuma suspeita criminosa nos indivíduos cadastrados. Atualizações a de serem feitas furutamente...


# Validação de Passaporte

1. ### O que é?  
    O projeto Validação procura simular o trabalho de um guarda de fronteira (você) no país fictício **Berloks** cujo Ministério da Defesa, por meio de um ultimato, restringiu a imigração exclusivamente àqueles nascidos no país que, porventura ou contratos trabalhistas, encontravam-se em território estrangeiro. Essa decisão ocorreu após uma declaração de guerra entre dois blocos econômicos poderosos no continente e o país pretende manter sua neutralidade Dessa forma, o seu objetivo é de cadastrar um número indefinido de indivíduos escolhidos por sua própria vontade a fim de compreender a funcionalidade do código, dessa forma permitindo maior liberdade em criar seus próprios indivíduos e testar as possibilidades de verificação de cadastro. Além disso, lembre-se: esse não é um trabalho individual. Há um guarda responsável por verificar os cadastros realizados e, se houver alguma suspeita, ele o avisará e, caso seja estrangeiro, o usuário e todos os seus dados serão removidos da lista de cadastro automaticamente. Aproveite a experiência!  
    Na estrutura do algoritmo teremos a presença de 3 classes, que são: Validação, Passaporte e Documentos. No total são 9 métodos e 3 construtores. As principais ações realizadas pelo guarda da fronteira são:    
    -  _Registrar_ para adicionar o nome e sobrenome do indivíduo. Esse é o comando inicial de toda aplicação e prévio para o próximo a seguir;
    - _Adicionar Informações_ aqui há um inserimento de 11 inputs, ou seja, 11 informações sobre o indivíduo cadastrado, sendo as 7 inicias relacionadas ao passaporte e as outras 4 são documentos pessoais.
    - _Exibir Lista_ o qual exibirá no terminal um array com as informações de todos os cadastros realizados até o último indivíduo cadastrado;
    - _Sair_, uma simples interrompição do código.
    

2. ### Como fez?
    O projeto, como mencionado anteriormente, possui 3 classes. A **Validação** contém a _clas main_ e as variáveis relacionadas ao nome e sobrenome, além de três ArrayList: um para documentos, outro para passaporte e o último para o nome completo. Nele ainda conterá grande parte das interações do código.  
    A segunda classe, **Passaporte**, contém 7 variáveis do tipo String, sendo elas:  
    - String dataNascimento;
    - String cor;
    - String genero;
    - String estadoCivil;
    - String pais;
    - String cidade;
    - String estado;
    
    Será nessa classe que ocorrerá os dois métodos de verifiação para validar o conteúdo das informações armazenadas pelo construtor.  
    A terceira, e última, a classe **Documentos** é formada 4 variáveis do tipo String, sendo elas:  
     - String identidade;
     - String cpf;
     - String tituloEleitor;
     - String servicoMilitar;  

    Essa, portanto, conterá o método para verificar os três primeiros documentos da lista acima e garantir a sua validade para a realização do cadastro.  

    - Comando Registrar: 
        - Para a execuçaõ desse comando, o usuário deverá digitar "registar" + o valor correspondente ao nome e ao sobrenome, ou seja, duas Strings. Somente assim será possível adicionar as informações do indivíduo e acionar outros comandos. Para exemplificar:  
            - ``registrar David Senna``
    - Comando Adicionar Informações:
        - Após registrar o nome e sobrenome, o comando a seguir deverá receber 11 informações a respeito desse indivíduo, pois assim haverá uma verificação do estado civil, idade, identidade, CPF, título de eleitor e do país de origem. Esse é o comando mais complexo, uma vez que se relaciona com vários métodos que interligam entre si a fim de causar a interação com o guarda responsável pela vigilância.  
        Caso o país registrado seja igual a **Berloks**, surgirá na tela:  
        ``Guarda: Continuemos o trabalho.``  
        Caso contrário, o método responsável por executar a inspeção será acionado, e então surgirá as seguintes mensagens no seu terminal, por exemplo:  
        ``Guarda: Um momento! Achamos que David Senna seja um estrangeiro de um país dos blocos econômicos. Faremos a inspeção``  
        ``Guarda: Nossa inspeção revelou que David Senna é um estrangeiro. Portanto removemos os seus dados do seu registro de passaporte. Obrigado por sua colaboração``  
        ``David Senna removido``

        As informações a serem digitadas seguem a ordem: ano de nascimento, cor da pele, gênero, estado civil, país, cidade, estado, identidade, CPF, título de eleitor e serviço militar. A exemplo de exemplificação da declaração do comando:
            - ``1980 branca masculino casado Brasil Quixadá Ceará 123123 2525 123123 obrigatório``  

    - Comando Exibir Lista:
        A partir desse comando será exibido um ArrayList contendo todas as informações até então armazenada. Digitando apenas "showAll" teremos a estrutura:  

        ``David Sena``  
        ``{ Data de Nascimento: 1980, Cor: branca, Genero: masculino, Estado Civil: casado, País: Brasil, Cidade: Quixadá, Estado: Ceará}``  
        ``[ Identidade: 123123, CPF: 2525, Titulo Eleitor: 123123, Servico Militar: obrigatório ]``

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Aprendi a interligar os métodos entre si de uma forma as informações contidas neles se interligassem e cooperassem de forma que possam ativar novas funcionalidades independentes de alguma ativação do usuário, mas respondendo as informações acrescentadas por eles em outros comandos a qual elas possam está interligadas.

5. ### Tempo estimado
    Em torno de três dias.