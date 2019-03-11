package com.calculadora.repository;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


public class DynamoDBManager
{
  private static DynamoDBMapper mapper;
  
  static
  {
    AmazonDynamoDB ddb = (AmazonDynamoDB)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1)).build();
    
    mapper = new DynamoDBMapper(ddb); }
  
  public DynamoDBManager() {}
  
  public static DynamoDBMapper mapper() { return mapper; }
}
