# Agenda V2

1. ### O que é?  
    O algoritmo a seguir propõe simular as ações de adição e remoção de um ou mais contatos em uma agenda telefônica, assim como executar o processo de validação do número em questão, permitindo, portanto, somente aqueles cuja validade seja confirmada. Além disso, através do terminal há uma exibição dos contatos adicionados a conter a chave de identificação - o nome - e sua respectiva lista de números, estas descritas por um **id** e um **numero** que os identificam.

2. ### Como fez?
    A elaboração do código sustenta-se por 4 classes que apoiam os métodos de cada uma a fim de organizar e desenvolver os comandos de forma que haja uma divisão de tarefas em vez de somente uma única class responsável por todas as atividades e interações. Desse modo, compreende-se não somente a relevância da interação entre classes, bem como as referências e construções de novos métodos.
    Na classe _AgendaComplete_ há os métodos principais utilizados que executam os comandos objetivados que possui uma única variável ```ArrayList<ContatoTeste> contatos;``` responsável por armazenar as informações essenciais da aplicação, uma vez que, por conter valores do tipo ```ContatoTeste```, que se trata da class que apresenta capacidade de contê-los e utilizá-los para as aplicações desejadas. Justamente nessa class há a declaração das variáveis ```String name;``` e ```ArrayList<FoneTeste> numbers;```. Enquanto isso, a class ```FoneTeste``` contém as variáveis  ```String id;``` e ```String number;``` a fim de controlar as informações a respeito do número do contato.  

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Em torno da atividade não compreendi em como utilizaria o ```Arrays.asList(new Fone(id, fone)``` na utilização do método ```adicionarContato()```, uma vez que em uma List não é permitido adicionar ou remover valores, apenas modificar os já pré-inscritos durante a sua declaração. Decidi, portanto, realizar o trabalho através da declaração de ```ArrayList<FoneTeste>``` considerados mais versáteis já que seria capaz de executar as ações descritas anteriormente incapazes de realização na List. Gostaria de entender como seriam feitas utilizando o exemplo descrita na questão.

5. ### Tempo estimado
    Em torno de 5 horas por conta das tentativas de utilizar o ```Arrays.asList(new Fone(id, fone)```.