# Ancoradouro

1. ### O que é?  
    A ideia criada e adaptada ao código em questão procura criar um sistema de um Ancoradouro a fim de registrar diferentes tipos de navios (cinco ao todo), cujos perfis contêm informações únicas a respeito de suas principais características, além de permitir uma interação com a aplicação, dessa forma a criação do nome do navio, bem como o código de identificação, há total liberdade de projeção e execução. Um aspecto ímpar entre os návios concentra-se nas ações disponíveis para um deles, isto é, cada navio contém uma ou mais interações distintas dos restantes. Há desde funcionalidades simples, como transportar passageiros, até de cálculo do peso do petróleo a ser transportada por um petroleiro. 

2. ### Como fez?
    Ao todo foram criados 4 arquivos no intuito de garantir uma melhor legibilidade do código e organizar as funcionalidades na finalidade de evitar arquivos muito extensos com aglutinação de classes e métodos em um único espaço compartilhado.
    Dentro do arquivo principal (main) temos a presença de uma interface e três classes. Entre estas temos a ```class Ship```, que define a constituição principal presente em todos os navios; ```class CargoShip``` que resultará na definição dos tipos  e o ```class Ancoradouro``` responsável pela interação com o código, além de conter um ```TreeMap``` que armazena todos os navios registrados.
    No arquivo *TypesShips.java* conterá um **enum** com as informações das siglas referentes a cada tipo. No arquivo *InfoShip.java* haverá a ```class InfoShip``` responsável pelo perfil com informações únicas para cada navio, além de conter a class para cada tipo de navio.
    Por fim, o arquivo *Products.java* que conterá o arquivo para o armazenamento de produtos do navio graneleiro.
    As funcionalidades e como executá-las são explicadas pelo próprio código em um curta menu criado logo após que a aplicação é executada, servindo de auxílio a quem estiver testando.

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Aprendi melhor como o uso do extends coloca o código ainda mais complexo em relação a herança. Tive dificuldade em compreender algumas relações criadas durante o meu código e acredito que muita coisa poderia ser reduzida...

5. ### Tempo estimado
    Em torno de 2 dias