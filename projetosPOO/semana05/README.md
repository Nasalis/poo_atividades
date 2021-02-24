# Tarifas

1. ### O que é?  
    O projeto Tarifas apresenta um sistema que procura simular as ações executáveis em uma conta bancária, desde a criação de uma conta em uma agência até o manuseio dos valores adicionados ou retirados, assim como a intervenção do inserimento de tarifas. Em suma, as decisões passíveis de controle pelo usuário concentram em um conjunto com 10 elementos:   
    -  _Sair_ para interromper o funcionamento do algoritmo);
    - _Abrir uma conta_ para que o usuário possa manipular suas informações a partir da criação de uma conta na agência;
    - _Depositar_ que adicionará uma quantia não negativa em sua conta a ser armazenada no saldo;
    - _Débito_, a indicação do valor cobrado e retirado da conta do usuário na agência;
    - _Tarifa_, valor a indicar o custo das mercadorias, isto é, taxas ou impostos alfendegários;
    - _Saque_ cuja função simula a retirada de uma quantia do saldo, desde que não ultrapasse o valor total.
    - _Extornar_ para creditar um valor anteriormente debitado;
    - _Extrato Específico_ a fim de obter uma quantia desejada de extratos a partir da última posição na lista;
    - _Extrato Total_ que apresenta uma lista de elementos contidos em um ArrayList com todos os extratos realizados pelo dono da conta;
    - _Exibir_ cuja finalidade limita-se somente em indicar o número da conta e o saldo total;

2. ### Como fez?
    A constituição do algoritmo baseia-se na interação entre três classes. A principal, **Tarifas**, que contém a _main_ do projeto em que reúne o conjunto de linhas de código responsáveis em manter a interatividade com o código. A segunda, denominada de **Conta** com três variáveis - _float_ saldo, _int_ numero e  _ArrayList<'Operacao'>_ extrato - as quais manipulam os dados no discorrer da utilização da conta. E o terceiro chamado de **Operacao** em que armazenará os dados das ações efetuadas pelo dono da conta em três variáveis totais - _String_ descricao, _float_ valor, _float_ saldo - para indicar que ação foi realizada, o valor da quantidade usada e o saldo da conta total modificado com essa atividade.
    - Interatividade: 
        - A classe **Tarifas**, como mencionado, manterá a interatividade de todo o código, mas para isso é necessário a criação de uma variável do tipo Contas que, por consequinte, sustenta a mobilidade em diferentes condições de acordo com o valor de entrada digitado pelo usuário no ciclo `while(true)`.
    - Comando abrirConta: 
        - Para tal ativação desse comando, o usuário deverá digitar "abrirConta" + o valor o qual corersponderá a variável _int numero_, pois assim permitindo a manipulação da conta através dos outros métodos. Caso a conta seja válida, a mensagem apresentada no terminal será "-> Nova conta aberta", se ocorrer o contrário então surgirá "-> Conta invalida" A título de exemplificação:  
            - ``abrirConta 200``
    - Comando depositar:
        - Com a criação da conta na agência, o comando depositar receberá como entrada o respectivo nome do ação + o valor a ser depositado. Com isso, a quantia digitada será repassada como parâmetro para o método ``public void depositar(float deposito)``, assim armazenando os dados do tipo **Operacao** no ArrayList _extrato_ e aumentando na variável _saldo_. Para exemplificar o comando a ser digitado:
            - ``depositar 100``  

        A partir daqui a estrutura de funcionalidade será semelhante, sendo o valor repassado como parâmetro para os seu respectivo método a partir do comando digitado. Para exemplificar todos, listarei apenas o comando e o método de cada.

    - Comando debito:
        - Método: ``public void debito(float debito)``
        - Comando: nome do comando + quantia. Exemplo: ``debito 20``

    - Comando tarifa:
        - Método: ``public void tarifa(float tarifa)``
        - Comando: nome do comando + quantia. Exemplo: ``tarifa 20``

    - Comando saque:
        - Método: ``public void saque(float saque)``
        - Comando: nome do comando + quantia. Exemplo: ``saque 20``
        
    - Comando extornar:
        - Método: ``public void extornar(int pos)``
        - Comando: nome do comando + quantia. Exemplo: ``extornar 2``
    - Comando extratoN:
        - Método: ``public void extratoEspecifico(int qtd)``
        - Comando: nome do comando + quantia. Exemplo: ``extratoN 4``
    - Comando extratoT:
        - Método: `` public void extratoTotal()``
        - Comando: nome do comando + quantia. Exemplo: ``extratoT``

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Através do projeto consegui aprender um novo recurso de testes ao utilizar ``try e catch`` no método ``public void extornar(int pos)``, pois precisava verificar uma condição caso o valor digitado da posição encontrava-se inexistente, o que causava um erro de runtime chamado **IndexOutOfBoundsException**.
    Como dificuldade menciono a dificuldade de inicializar uma variável sem que o valor inicial dela interfira no restante do código para manter ela certamente mais interativa, contudo é algo que estou estudando e analisando a melhor opção. A que encontrei foi tentar criar um método em que o valor acrescentado a ela seja independente do Construtor; contudo é algo ainda a ser analisado.

5. ### Tempo estimado
    Em torno de duas horas.