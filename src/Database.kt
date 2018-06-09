
package com.johnfmarion.kt.db;

import java.io.BufferedReader;

fun printPrompt() {
  print("jfmarioDB~> ")
}

fun main(args: Array<String>) {
  
  while (true) {
    
    printPrompt();
    
    val userInput: String = readLine()!!;
    
    if (userInput == ".exit") {
      kotlin.system.exitProcess(0);
    }
    else {
      println("Unrecognized command: ${userInput}");
    }
  }
}