# Souls' Collector

1. ### O que é?
O projeto segue a descrição da atividade no seguinte repositório: [Tamagotchi](https://github.com/qxcodepoo/arcade/blob/master/base/006/Readme.md) 

2. ### Como fez?
Foram criadas duas classes: ```class Bichinho``` e ```class Tamagoshi```.  
A primeira mencionada contém a seguinte lista de métodos privados responsáveis pelos status do Tamagotchi criado durante a execução do código:
- ```private int energia:``` quantidade de energia para o Tamagoshi fazer suas atividades
- ```private int minEnergia:``` quantidade mínima que ele pode recuperar em um descanso;
- ```private int subEnergia:``` energia gasta com as atividades;
- ```private int saciedade:``` valor que indica quando sente fome;
- ```private int limpeza:``` valor que mente o quão sujo ou limpo ele está;
- ```private int idade:``` o Tamagotchi pode morrer de velhice;
- ```private int energiaMax:``` quantidade máxima de energia;
- ```private int saciedadeMax:``` valor máximo para saciar a fome;
- ```private int limpezaMax:``` valor que indica limpeza total;
- ```private int idadeMax:``` tempo de vida;
- ```private int diamantes:``` diamantes ganhos durante o jogo;
- ```private boolean alive:``` indica se está vivo ou morto;
  
Para cada um desses status há um método específico que os administra de acordo com a dinâmica do jogo.  
E a classe ```class Tamagoshi``` é responsável unicamente em manter a interatividade do código;
- O trabalho foi realizado individualmente;  
- Aprendi a utilzação dos métodos getters e setters e como eles podem melhorar a legibilidade do código em projetos em que há uma presença de verbosidade maior;
- Tempo estimado: 1 hora.