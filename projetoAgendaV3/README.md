# Agenda V3

1. ### O que é?  
    O código a seguir adiciona dois novos métodos para o projeto de simulação de uma Agenda telefônica, sendo eles: adicionar um contato a lista de favoritos (````void bookMark(String id)````) e deletá-lo quando o usuário desejar ```void unBookMark(String id)```. Os métodos da versão anterior foram aprimorados de modo a respeitar a utilização do ```TreeMap```, bem como corrigir problemas de funcionamento que afetavam a performance do código  e causava _bugs_. 

2. ### Como fez?
    Além das e classes incrementadas, a classe que utilizava o ```compareTo``` foi retirado, uma vez que o ```TreeMap``` ordena os valores automaticamente. A variável contatos, antes como ```ArrayList``` , passou a ser do tipo ``` TreeMap```, assim como a variável bookmarks que armazenará todos os contatos considerados favoritos, que inclusive são representados com um símbolo de *@* no terminal pelo método ```toString()``` caso a variável ```starred``` tenha o seu valor booleano como true; pois o contrário a representação se dará por um simples **-**.

3. ### Com quem fez?
    O trabalho foi realizado individualmente.
4. ### O que aprendeu e dificuldades?
    Consegui aprender o uso de Map com TreeMap e não senti dificuldade em implentar as funcionalidades pedidas pela atividade.

5. ### Tempo estimado
    Em torno de 1 horas e 30 minutos.