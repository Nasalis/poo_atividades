# Souls' Collector

- O projeto desenvolvido possui como objetivo estruturar um código iterativo no qual o usuário incorpora a posição de um Coletor de Almas de uma determinada especialização de colheita já determinado pelo algoritmo, contudo as decisões a serem escolhidas relacionados a absorção de alma ou abandoná-la, além de armazená-las para lançar feitiços posteriormente. A em torno de uma variação de quatro tipos de almas a serem coletadas e, no momento em que essa ação é executada, o usuário poderá verificar as informações a respeito do Coletor.   
    Caso nenhuma alma seja coletada, as informações serão a seguinte:
    - **Amount souls:** 0/200;
    - **Leftovers:** 0;
    - **Type Collector:** demon;
    - **Souls info:** null;

    Caso contrário, se houver uma alma coletada, teremos a seguinte estrutura, por exemplo:
    - **Amount souls:** 0/200;
    - **Leftovers:** 0;
    - **Type Collector:** demon;
    - **Souls info:**
        - **Amount souls:** 20;
        - **Name:** Nahru Barshkman;
        - **Nature Souls:** demon;
        - **Info:**  
            'Nos interiores do submundo das Cavernas de Ighorah jazem as mais bestiais criaturas abandonadas pelos Criadores,naquelas cujo sangue enfraquece a terra e as águas e perturba a consciência dos homens tais como os pesadelos que atormentam os que vagam noturnamente pelas mentes.De almas robustas e algooz da Criação, nenhuma mente sã as desejam vagando pelo mundo'--- Heroghito, Historiador, 457 a.C..    

- Desde o início do desenvolvimento o trabalho realizado individualmente;  
- Portanto, para a execução desse projeto foi criador dois arquivos _.java_ a fim de atingir a sua execução, sendo o _Demons.java_ utilizado para criar o vetor que armazena as informações dos tipos de almas a serem coletadas e o arquivo principal, _SoulsCollect.java_ para a execução de toda as outras lógicas envolvidas. Além disso, foram criadas três classes: _Collector_, _EnemySouls_ e _SoulsList_ a fim relacionar as informações entre si. Foi desenvolvido 6 métodos e dois construtores no arquivo principal. A classe principal é a responsável por manter a interatividade com o código.
- Aprendi a manipular informações de outro arquivo e unindo elas a um vetor para criar uma aleatoriedade quanto as ocorrências de possibilidade de coleta dos tipos de alma pelo Coletor utilizando, para isso, a classe Random.
- Tempo estimado: 5 horas.