# Cadastro - Agência 2

1. ### O que é?  
    O código refere-se a uma aplicação da atividade que pode ser verificada através do seguinte link:
    [Cadastro](https://github.com/qxcodepoo/arcade/blob/master/base/013/Readme.md).
    Resumo geral:  
    O projeto desenvolvido a seguir trata-se de uma extensão de uma atividade anterior, [Tarifas](https://github.com/qxcodepoo/arcade/blob/master/base/007/Readme.md), que compõe a primeira fase cujos resultados eram alcançados através do uso dos conhecimentos em ArrayList estudados durante as aulas. Nessa segunda parte, todavia, o diferencial concentra-se na utilização de Heranças a fim de alcançar resultados semelhantes da atividade anterior a qual focava em criar uma agência bancária com seus clientes e efeutar operações de depósito, saque e transferência.

2. ### Como fez?
    Para a execução e conclusão desse projeto foi necessário criar cinco (5) classes, sendo elas: **class Agencia**, **class Cliente**, **class Conta**, **class ContaCorrente**, **class ContaPoupanca**. Dentre elas, as duas últimas citadas herdam os métodos da class-pai Conta.
    A classe principal - a que contém a main de todo projeto - é a ```class Agencia```, responsável pela inicialização do código com a estrutura interativa de forma que ainda possa tratar os possíveis erros durante a execução do conteúdo através do ```try catch```, de armazenar em dois ArrayList's os clientes e as contas cadastradas no sistema, além de adicioná-los e atualizar os saldos em suas contas registradas.  
    A ```class Cliente``` tem unicamente como papel conter o id do usuário - cliente - e um ArrayList como conteúdo objetos do tipo *ContaCorrente* e *ContaPoupanca*.  
    Em relação a ```class Conta```, temos o id do cliente e da conta e o seu saldo atual, além de ser responsável pelas operações relacionadas a depósito, saque e transferência entre as contas. As classes herdadas de si, como a ```class ContaCorrente``` relaciona o saldo com uma tarifa mensal constante de valor 20 a ser aplicada a cada atualização na conta, enquanto a ```class ContaPoupanca``` há um rendimento constante de 1% a ser adicionado no saldo final.
    

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Sem muita dificuldade em aplicar os conhecimentos no código e melhorando o trabalhando de desenvolvimento dos códigos com herança.

5. ### Tempo estimado
    Em torno de 1 hora.