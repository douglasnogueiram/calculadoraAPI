Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://lblflgf89j.execute-api.us-east-1.amazonaws.com/dev/'


Scenario: Deve retornar acesso n�o autorizado
Given path 'avengers', 'anyid'
When method get
Then status 401



