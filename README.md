# Explorando Marte

Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto. Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmera embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.

A posição e direção de uma sonda são representadas por uma combinação de coordenadas x-y e uma letra representando a direção cardinal para qual a sonda aponta, seguindo a rosa dos ventos em inglês.

O planalto é divido numa malha para simplificar a navegação. Um exemplo de posição seria (0, 0, N), que indica que a sonda está no canto inferior esquerdo e apontando para o Norte.

Para controlar as sondas, a NASA envia uma simples sequência de letras. As letras possíveis são "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda ou direita, respectivamente, sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção.

Nesta malha o ponto ao norte de (x,y) é sempre (x, y+1).

Você deve fazer um programa que processe uma série de instruções enviadas para as sondas que estão explorando este planalto. O formato da entrada e saída deste programa segue abaixo.

A forma de entrada e saída dos dados fica à sua escolha.

### ENTRADA
A primeira linha da entrada de dados é a coordenada do ponto superior-direito da malha do planalto. Lembrando que a inferior esquerda sempre será (0,0).

O resto da entrada será informação das sondas que foram implantadas. Cada sonda é representada por duas linhas. A primeira indica sua posição inicial e a segunda uma série de instruções indicando para a sonda como ela deverá explorar o planalto.

A posição é representada por dois inteiros e uma letra separados por espaços, correpondendo à coordenada X-Y e à direção da sonda. Cada sonda será controlada sequencialmente, o que quer dizer que a segunda sonda só irá se movimentar após que a primeira tenha terminado suas instruções.

### SAÍDA
A saída deverá contar uma linha para cada sonda, na mesma ordem de entrada, indicando sua coordenada final e direção.

Exemplos de Entrada e Saída:
####Entrada de Teste:

5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Saída esperada:
1 3 N
5 1 E

## Build the project

Um pacote do projeto pode ser construído usando o Maven:

```
mvn clean package
```

E para executar em modo local:

```
java -jar target/nasa-0.0.1.jar
```

## Configuração em Docker

O projeto contém um arquivo Dockerfile baseado em uma imagem openjdk do projeto Alpine:

```
FROM openjdk:13-alpine
MAINTAINER elo7
COPY target/nasa-0.0.1.jar nasa-0.0.1.jar
ENTRYPOINT ["java","-jar","/nasa-0.0.1.jar"]
```

Para criar a imagem do nosso projeto, a partir do Dockerfile, usamos o comando 'docker build':

```
$ docker build --tag=elo7:latest .
```

E para subir a aplicação no container após a geração da imagem:

```
docker run -p8080:8080 elo7:latest
```

## Documentação da API

Para exibir a documentação da API usamos um implementação do OpenAPI, chamada Swagger.

Após subir o projeto, clique aqui [Swagger](http://localhost:8080/swagger-ui.html) para abrir essa documentação.

## Execução da sondas

O input de dados para a sondagem em Marte é através de um arquivo com o seguinte layout:
```
lxT lyT
xS1 yS1 dS1
movimentos de S1
xS2 yS2 dS2
movimentos de S2
.
.
.
xSn ySn dSn
movimentos de Sn

```
onde:
```
lxT: limite do terreno no eixo X
lyT: limite do terreno no eixo Y
xS: posição inicial da sonda no eixo X
yS: posição inicial da sonda no eixo Y
dS: direção da sonda (N, S, W, E)
movimentos: lista de movimentos possíveis da sonda in (L, R, M)
```

A saída gerada é um arquivo contendo as posições finais das sondas.
