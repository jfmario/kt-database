
package com.johnfmarion.kt.db;

import java.io.StringReader;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.johnfmarion.kt.db.exceptions.InsufficientArgumentsException;
import com.johnfmarion.kt.db.exceptions.UnrecognizedCommandException;
import com.johnfmarion.kt.db.exceptions.UnrecognizedKeywordException;

import com.johnfmarion.kt.db.records.Row1;

import com.johnfmarion.kt.db.statements.Statement;
import com.johnfmarion.kt.db.statements.StatementType;

fun doMetaCommand(command: String) {
  if (command == ".exit") {
    kotlin.system.exitProcess(0);
  }
  else {
    throw UnrecognizedCommandException(command);
  }
}

fun prepareStatement(statement: String): Statement {
  if (statement.startsWith("insert")) {
  
    val statementObject = Statement(StatementType.INSERT);
    
    val reader = Scanner(StringReader(statement));
    reader.next();
    
    try {
    
      val id = reader.nextLong();
      val username = reader.next();
      val email = reader.next();
      
      statementObject.recordToInsert = Row1(id, username, email);
    }
    catch (e: NoSuchElementException) {
      throw InsufficientArgumentsException(statement);
    }
    
    
    return statementObject;
  }
  else if (statement.startsWith("select")) {
    return Statement(StatementType.SELECT);
  }
  else {
    throw UnrecognizedKeywordException(statement);
  }
}

fun executeStatement(statement: Statement) {
  if (statement.type == StatementType.INSERT) {
    println("An insert statement.");
  }
  else if (statement.type == StatementType.SELECT) {
    println("A select statement.");
  }
}

fun printPrompt() {
  print("jfmarioDB~> ")
}

fun main(args: Array<String>) {
  
  while (true) {
    
    printPrompt();
    
    val userInput: String = readLine()!!;
    
    if (userInput.get(0) == '.') {
      try {
        doMetaCommand(userInput);
        continue;
      }
      catch (e: UnrecognizedCommandException) {
        println(e);
        continue;
      }
    }
    
    var statement: Statement? = null;
    
    try {
      statement = prepareStatement(userInput);
    }
    catch(e: Exception) {
      println(e);
      continue;
    }
    
    executeStatement(statement);
    
    println("Executed.");
  }
}