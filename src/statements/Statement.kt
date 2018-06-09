
package com.johnfmarion.kt.db.statements;

import com.johnfmarion.kt.db.records.Row1;

data class Statement(val type: StatementType) {
  
  // only for insert statement
  var recordToInsert: Row1? = null;
}