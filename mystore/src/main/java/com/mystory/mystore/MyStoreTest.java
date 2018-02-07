/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mystory.mystore;

import java.util.*;
/**
 *
 * @author Dimka
 */
public class MyStoreTest
{
  static int number = 0;
  static int amount = 0;
  static Set<MyAccount>accounts ;
  public static void main(String[] args)
  {
    accounts = new HashSet<>();
    try(Scanner in = new Scanner(System.in))
    {      
      while(!in.hasNext("EXIT"))
      {
        String[] task = in.nextLine().split(" ");
        
        //Проверка на корректность ввода задачи
        if(!isCorrectTask(task) )
        {
          if(task[0].equals(""))
            continue;
          System.out.println("ERROR");
          continue;
        }
        
            
        String operation = task[0];
        number = Integer.parseInt(task[1]); 
        //проверка на дублирование аккаунта
        if(!isCorrectAccount(accounts, number, operation))
        {
          System.out.println("ERROR");
          continue;
        }
        
        switch (operation) 
        {
          case "NEWACCOUNT": 
          {
            accounts.add(new MyAccount(number));
            System.out.println("OK");
            break;
          }
          case "DEPOSIT": 
          {
            amount = Integer.parseInt(task[2]);
            
            for(MyAccount e: accounts)
            {
              if(e.hashCode() == number)
                e.deposit(amount);
            }   
            
            System.out.println("OK");
            break;
          }
          case "WITHDRAW": 
          {
            amount = Integer.parseInt(task[2]);
            
            for(MyAccount e: accounts)
            {
              if(e.hashCode() == number && e.isNormal(amount))
                e.withdraw(amount);
            } 
            
            System.out.println("ERROR");
            break;
          }
          case "BALANCE": 
          {
            for(MyAccount e: accounts)
            {
              if(e.hashCode() == number)
                System.out.println(e.getCost());  
            }            
            break;
          }
          default: 
          {
            System.out.println("ERROR");
          }    
        }
      }
      
    }    
  }
  
  static boolean isCorrectTask(String[] tsk)
  {
    if(tsk.length == 2 && tsk[0].equals("NEWACCOUNT"))
    {
      try
      {
        if(isValid(Integer.parseInt(tsk[1])))
        {
          return true;
        }
      }
      catch(NumberFormatException e)
      {
        
      }
    }
    else if(tsk.length == 2 && tsk[0].equals("BALANCE") &&
            !accounts.isEmpty())
    {
      try
      {
        if(isValid(Integer.parseInt(tsk[1])))
        {
          return true;
        }
      }
      catch(NumberFormatException e)
      {
        
      }
    }
    else if(tsk.length == 3     &&
            !accounts.isEmpty() &&
            (tsk[0].equals("DEPOSIT") || tsk[0].equals("WITHDRAW")))
    {
      try
      {
        if(isValid(Integer.parseInt(tsk[1])) && isValid(Integer.parseInt(tsk[2])))
        {
          return true;
        }
      }
      catch(NumberFormatException e)
      {
        
      }
    }
    return false;
  }
  
  static boolean isValid(int intger)
  {   
    if(intger < 0)
      return false;
    else if(intger > Integer.MAX_VALUE)
      return false;
    
    return true;
  }
  
  static boolean isCorrectAccount(Set<MyAccount> acc,int num, String operation)
  {
    if(operation.equals("NEWACCOUNT"))
    {
        for(MyAccount e : acc)
        {
          if(e.hashCode() == num)
            return false;
        }
        return true;
    }
    else
    {
        for(MyAccount e : acc)
        {
          if(e.hashCode() == num)
            return true;
        }
        return false;
    }
  }
  
}

