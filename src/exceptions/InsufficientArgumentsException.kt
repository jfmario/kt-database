
package com.johnfmarion.kt.db.exceptions;

class InsufficientArgumentsException(command: String): SyntaxErrorException("Insufficient or invalid arguments in ${command}") {
  
}