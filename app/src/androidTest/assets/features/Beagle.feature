# language: pt

@beagle
Funcionalidade: Realizar compras de café no aplicativo ITI
  Como usuário do aplicativo de cafés ITI
  Gostaria de visualizar as opçoes de café e selecionar o que desejo comprar
  Para realizar a compra do meu café

  Contexto:
    Dado que o usuario esteja na tela principal
    E o usuario inserir o login de acesso
    E o usuario clicar na opcao Entrar


 Cenario: Validar exibicao de cafes
   Entao tela de exibicao de cafes e visualizada com sucesso


 Esquema do Cenario: Selecao de cafes
   Dado o usuario clicar na opcao <cafe>
#   Quando a tela com o header <cafe> e devidamente apresentada
   Entao a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>
   E o botao Add To Cart e apresentado
#   E o botao Checkout e apresentado

   Exemplos:
   | cafe            | valor      | texto                                                                                                                             |
   | Espresso        | USD$ 4.35  | Blue Ridge Blend |
   | Choco Frappe    | USD$ 10.00 | A deliciously creamy Coffee Kick Frappé, topped with irresistible whipped cream and indulgent Coffee Drizzle. Perfect combination |
   | Caramel Frappe  | USD$ 10.50 | A deliciously creamy Coffee Kick Frappé, topped with irresistible whipped cream and indulgent Coffee Drizzle. Perfect combination |
   | Kick Frappe     | USD$ 12.75 | A deliciously creamy Coffee Kick Frappé, topped with irresistible whipped cream and indulgent Coffee Drizzle. Perfect combination |


  Esquema do Cenario: Adicionar cafe ao carrinho
    Dado o usuario clicar na opcao <cafe>
    E a tela com o header <cafe> e devidamente apresentada
    E a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>
    Quando o usuario clicar na opcao Add to Order
    Entao o cafe e adicionado com sucesso ao carrinho
    E a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>

    Exemplos:
      | cafe            | valor  | texto               |
      | Espresso        | $4.35  | Your order is ready |
      | Choco Frappe    | $10    | Your order is ready |
      | Caramel Frappe  | $10.50 | Your order is ready |
      | Kick Frappe     | $12.75 | Your order is ready |


  Esquema do Cenario: Comprar cafes diretamente do botao Checkout
    Dado o usuario clicar na opcao <cafe>
    E a tela com o header <cafe> e devidamente apresentada
    E a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>
    E o usuario clicar na opcao Checkout
    E a tela com o header Order Summary e devidamente apresentada
    E a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>
    Quando o usuario clicar na opcao Place The Order
    Entao a tela com o header Success e devidamente apresentada
    E a mensagem <mensagem> e apresentada

    Exemplos:
      | cafe            | valor  | texto               | mensagem                     |
      | Espresso        | $4.35  | Your order is ready | Compra realizada com sucesso |
      | Choco Frappe    | $10    | Your order is ready | Compra realizada com sucesso |
      | Caramel Frappe  | $10.50 | Your order is ready | Compra realizada com sucesso |
      | Kick Frappe     | $12.75 | Your order is ready | Compra realizada com sucesso |


  Esquema do Cenario: Comprar cafes atraves da tela de Order Summary
    Dado o usuario clicar na opcao Checkout
    E a tela com o header Order Summary e devidamente apresentada
    E a tela e apresentada com o nome <cafe>, valor <valor> e texto <texto>
    Quando o usuario clicar na opcao Place The Order
    Entao a tela com o header Success e devidamente apresentada
    E a mensagem <mensagem> e apresentada

    Exemplos:
      | cafe            | valor  | texto               | mensagem                     |
      | Espresso        | $4.35  | Your order is ready | Compra realizada com sucesso |
      | Choco Frappe    | $10    | Your order is ready | Compra realizada com sucesso |
      | Caramel Frappe  | $10.50 | Your order is ready | Compra realizada com sucesso |
      | Kick Frappe     | $12.75 | Your order is ready | Compra realizada com sucesso |