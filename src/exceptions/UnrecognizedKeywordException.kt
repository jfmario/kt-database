
package com.johnfmarion.kt.db.exceptions;

class UnrecognizedKeywordException(command: String): Exception("Unrecognized keyword at start of: ${command}") {
  
}