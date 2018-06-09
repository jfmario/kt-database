
package com.johnfmarion.kt.db.exceptions;

open class SyntaxErrorException(error: String): Exception("Syntax Error: ${error}") {
  
}