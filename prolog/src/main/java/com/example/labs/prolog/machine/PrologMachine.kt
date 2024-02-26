package com.example.labs.prolog.machine

import com.example.labs.prolog.statement.Statement
import com.example.labs.prolog.term.PredicateResult

interface PrologMachine {

	fun runStatement(statement: Statement): PredicateResult
}