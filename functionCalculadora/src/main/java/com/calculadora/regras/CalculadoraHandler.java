package com.calculadora.regras;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.calculadora.exception.CalculadoraNotFoundException;
import com.calculadora.lambda.response.HandlerResponse;
import com.calculadora.lambda.response.HandlerResponse.Builder;
import com.calculadora.service.Calculadora;

public class CalculadoraHandler implements RequestHandler<Calculadora, HandlerResponse>
{
  private Calculadora calculadoraResposta = new Calculadora();
  private String operacao;
  
  public CalculadoraHandler() {}
  
  public HandlerResponse handleRequest(Calculadora calculadora, Context context) {
    context.getLogger().log("[#] Calculadora, valor 1 = " + calculadora.getValor1());
    context.getLogger().log("[#] Calculadora, valor 2 = " + calculadora.getValor2());
    context.getLogger().log("[#] Calculadora, Opera��o = " + calculadora.getOperacao());
    
    operacao = calculadora.getOperacao();
    
    context.getLogger().log("[#] Opera��o que ser� validada = " + operacao);
    
    if (operacao.equals("+"))
    {
      context.getLogger().log("[#] Caiu na soma");
      calculadoraResposta.setResultado(calculadora.soma());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("-")) {
      context.getLogger().log("[#] Caiu na subtra��o");
      calculadoraResposta.setResultado(calculadora.subtrair());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("*")) {
      context.getLogger().log("[#] Caiu na multiplica��o");
      calculadoraResposta.setResultado(calculadora.multiplicar());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("/")) {
      if (calculadora.getValor2() == 0.0D) {
        throw new CalculadoraNotFoundException(
          "N�o � possivel fazer divis�o por 0!;-( Opera��o: " + calculadora.getOperacao());
      }
      
      context.getLogger().log("[#] Caiu na divis�o");
      calculadoraResposta.setResultado(calculadora.dividir());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else
    {
      throw new CalculadoraNotFoundException("Par�metros incorretos: " + calculadora.getOperacao());
    }
    








    HandlerResponse response = HandlerResponse.builder().setObjectBody(calculadoraResposta).build();
    
    return response;
  }
}
