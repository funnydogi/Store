/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mystory.mystore;

public class MyAccount
{
  private double cost;
  private final int accountNumber;
  
  MyAccount(int accountN)
  {
    this.cost = 0;
    this.accountNumber = accountN;
  }
  
  public void deposit(double money)
  {
      this.cost += money;
  }
  
  public void withdraw(double money)
  {
    this.cost -= money;
  }
  
  public int getCost()
  {
    return (int)this.cost;
  }
  
  boolean isNormal(double money)
  {
    return ((this.cost - money) >= 0);
  }
  
  public int hashCode()
  {
    return this.accountNumber;
  }
  
  public boolean equals(Object otherObject)
  {
    if(this == otherObject)
      return true;
    
    if(otherObject == null)
      return false;
    
    if(getClass() != otherObject.getClass())
      return false;
    
    MyAccount other = (MyAccount)otherObject;
    return cost == other.cost 
      && accountNumber == other.accountNumber;
  }
}
