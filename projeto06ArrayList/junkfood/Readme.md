# Junk Food

1. ### O que é?  
    A ideia do projeto procura replicar ações de uma máquina de Junkfood desde o inserimento de informações dos alimentos a serem inseridos, bem como a sua quantidade - esta por sua vez que respeita o limite criado para a máquina previamente - e os seus valores de compra. A máquina conterá um número _n_ de espirais em que será armazenado um alimento diferente, da mesma forma uma quantidade _m_ do mesmo produto a ser inserido nela. O algoritmo ainda contém um cálculo de troco e a possibilidade de recriar a máquina como todo ao iniciá-la novamente.

2. ### Como fez?
    Para tal elaboração, o código contém em torno de três classes - ```class Espiral```, ```class Maquina``` e a ```class JunkFood``` sendo a principal por conter o método de _main_ de todo o processo em que ocorrerá a interatividade com o código, uma vez configurados os 8 comandos gerais de toda a aplicação, sendo eles: **init**, **set**, **limpar**, **dinheiro**, **troco**, **comprar**, **show**, **end**; correspondendo, dessa forma, a ideia proposta pelo diagrama no repositório do curso no github.

    Na ```class Espiral``` somente as respectivas variáveis de um determinado produtom, um ```constructo```r e o método ```toString()``` a fim de formatar a saída separando as informações das variáveis por ":", pois assim garantindo o resultado de ```nome : qtd : preco```.

    Já na ```class Máquina``` há a concentração de todos os métodos responsáveis pela aplicação interativa por conter a variável ```ArrayList<Espiral> espirais``` que conterá as informações dos objetos do tipo Espiral adicionados, além do controle do saldo do cliente durante a compra/venda de um produto.
 
3. ### Com quem fez?
    O trabalho foi realizado e auxiliado com minha colega de outra turma.
4. ### O que aprendeu e dificuldades?
    Reconheci a melhor legibilidade do código através do switch, pois impede a presença encadeada de if e else's com a abertura e fechamento de chaves. Como dificuldade foi a correção de alguns bugs que tomaram um pouco do tempo.

5. ### Tempo estimado
    Em torno de 3 horas.