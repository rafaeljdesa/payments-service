# payments-service

Projeto responsável por calcular as opções de pagamento à vista ou parcelado do carrinho de compras.

## Tecnologias

- Java 17
- Spring Boot 2.7.5
- Maven

## Arquitetura

Foram utilizados conceitos da arquitetura hexagonal, que preza pelo baixo acoplamento da camada de domínio 
da aplicação com frameworks e tecnologias.

Camadas:

- **application** - responsável pelos componentes externos ao domínio aplicação e pela utilização de recursos do framework
  - **adapter** - responsável pela implementação de adaptadores aos recursos externos do domínio da aplicação (ex: REST controllers, mensageria, acesso à banco de dados...)
  - **config** - responsável pelas configurações da aplicação (ex: IoC para injeção de dependência, configurações externas, configurações do framework...)
- **domain** - responsável pela camada de domínio da aplicação
  - **exception** - responsável pelas exceções personalizadas do domínio da aplicação
  - **model** - responsável pelo modelo de domínio da aplicação
  - **ports** - responsável pela definição das interfaces que delimitam as fronteiras de entrada e saída do domínio da aplicação
  - **service** - responsável pelo serviço de domínio da aplicação

## Executando os testes

```console
mvn test 
```

## Executando o build da aplicação

```console
mvn clean package 
```

## Executando a aplicação

```console
java -jar ./target/payments-service-1.0.0.jar
```

## Contrato

POST - /payments/options/calculate

Payload:
```json
{
  "user": {
    "firstName": "Test",
    "lastName": "Test",
    "age": 30
  },
  "shoppingCart": {
    "items": [
      {
        "product": {
          "category": "DECOR",
          "title": "Product ABC",
          "price": 3000.00
        },
        "quantity": 1
      },
      {
        "product": {
          "category": "MOBILE_PHONE",
          "title": "Product ABC",
          "price": 3000.00
        },
        "quantity": 1
      }
    ]
  }
}
```

Response:

Status: 200 OK
```json
{
    "paymentOptions": {
        "paymentOptions": [
            {
                "numberOfInstallments": 1,
                "amount": 5700.00
            },
            {
                "numberOfInstallments": 2,
                "amount": 3030.00
            },
            {
                "numberOfInstallments": 3,
                "amount": 2020.00
            },
            {
                "numberOfInstallments": 4,
                "amount": 1530.00
            },
            {
                "numberOfInstallments": 5,
                "amount": 1224.00
            },
            {
                "numberOfInstallments": 6,
                "amount": 1020.00
            },
            {
                "numberOfInstallments": 7,
                "amount": 882.86
            },
            {
                "numberOfInstallments": 8,
                "amount": 772.50
            },
            {
                "numberOfInstallments": 9,
                "amount": 686.67
            },
            {
                "numberOfInstallments": 10,
                "amount": 618.00
            },
            {
                "numberOfInstallments": 11,
                "amount": 561.82
            },
            {
                "numberOfInstallments": 12,
                "amount": 515.00
            }
        ]
    }
}
```