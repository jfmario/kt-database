
package com.johnfmarion.kt.db.exceptions;

class UnrecognizedCommandException(command: String): Exception("Unrecognized command: ${command}") {
  
}