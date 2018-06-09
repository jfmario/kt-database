
package com.johnfmarion.kt.db;

import java.io.BufferedReader;

import com.johnfmarion.kt.db.exceptions.UnrecognizedCommandException;
import com.johnfmarion.kt.db.exceptions.UnrecognizedKeywordException;

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
    return Statement(StatementType.INSERT);
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
    catch(e: UnrecognizedKeywordException) {
      println(e);
      continue;
    }
    
    executeStatement(statement);
    
    println("Executed.");
  }
}