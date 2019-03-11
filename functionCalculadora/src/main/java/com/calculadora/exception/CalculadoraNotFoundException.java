package com.calculadora.exception;


public class CalculadoraNotFoundException
  extends RuntimeException
{
  public CalculadoraNotFoundException() {}
  
  public CalculadoraNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
  public CalculadoraNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public CalculadoraNotFoundException(String message) {
    super(message);
  }
  
  public CalculadoraNotFoundException(Throwable cause) {
    super(cause);
  }
}