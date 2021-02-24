# Agiota

1. ### O que é?  
    O código desenvolvido busca produzir o sistema cuja funcionalidade exibe o histórico de negociações de empréstimos do agiota Ptolomeu, dessa forma auxiliando quando ao registro dos clientes, gerenciamento dos saldo pessoal e dos seus devedores, assim como permitir identificar o valor limite do empréstimo de cada negociação. Além disso, há funcionalidade de "expulsar o cliente da cidade" no bem entender de Ptolomeu ao considerar que o indivíduo em dívida não quite a sua dívida com o valor indicado do dinheiro emprestado.

2. ### Como fez?
    Há uma criação de 3 classes responsáveis por manipular o conteúdo dos clientes, das transações e do Ptolomeu, sendo a classe relacionada ao agiota como a principal por conter o gerenciamento de todo o sistema em questão. Desse modo, as classes citadas são: ```Cliente```, ```Transaction```, ```Agiota```. A primeira é encarregada de armazenar o nome do cliente, o valor atual do empréstimo a ser recebido e o limite que Ptolomeu poderá emprestá-lo. Já em relação a segunda ```class```, haverá o valor do cliente, contudo armazenando o **id**, responsável por indicar o valor posicional da operação na lista, e conterá o valor emprestado a ser somado com o valor atual do empréstimo da ```class Cliente```. Enquanto isso, a última ```class``` conterá dois ```Map``` que objetivam armazenar o histórico de clientes adicionados no sistema e o das transações, além disso possui o valor de posicionamento na lista e o saldo do agiota. Além disso, os métodos ```void addClient(String codename, float limit)```, ```void lend(String codename, float value)```, ```void receive(String codename, float value)```, ```void kill(String codename)```, ```boolean verifyClient```.

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Consegui aprender o uso de Map com HashMap, assim como a utilização dos métodos apresentados durante a aula do dia 25/01/2021 e o uso de forEach para percorrer um vetor. Como dificuldade foi só um problema quanto ao erro _java.util.ConcurrentModificationException_ durante o momento que quis percorrer e modificar um ```map``` ao mesmo tempo.

5. ### Tempo estimado
    Em torno de 2 horas 30 minutos.