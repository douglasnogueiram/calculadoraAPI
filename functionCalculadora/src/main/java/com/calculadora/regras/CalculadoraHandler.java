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
    context.getLogger().log("[#] Calculadora, Operação = " + calculadora.getOperacao());
    
    operacao = calculadora.getOperacao();
    
    context.getLogger().log("[#] Operação que será validada = " + operacao);
    
    if (operacao.equals("+"))
    {
      context.getLogger().log("[#] Caiu na soma");
      calculadoraResposta.setResultado(calculadora.soma());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("-")) {
      context.getLogger().log("[#] Caiu na subtração");
      calculadoraResposta.setResultado(calculadora.subtrair());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("*")) {
      context.getLogger().log("[#] Caiu na multiplicação");
      calculadoraResposta.setResultado(calculadora.multiplicar());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else if (operacao.equals("/")) {
      if (calculadora.getValor2() == 0.0D) {
        throw new CalculadoraNotFoundException(
          "Não é possivel fazer divisão por 0!;-( Operação: " + calculadora.getOperacao());
      }
      
      context.getLogger().log("[#] Caiu na divisão");
      calculadoraResposta.setResultado(calculadora.dividir());
      calculadoraResposta.setValor1(calculadora.getValor1());
      calculadoraResposta.setValor2(calculadora.getValor2());
      calculadoraResposta.setOperacao(calculadora.getOperacao());

    }
    else
    {
      throw new CalculadoraNotFoundException("Parâmetros incorretos: " + calculadora.getOperacao());
    }
    








    HandlerResponse response = HandlerResponse.builder().setObjectBody(calculadoraResposta).build();
    
    return response;
  }
}
