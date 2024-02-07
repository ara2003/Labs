package com.example.labs.prolog.machine

import com.example.labs.prolog.statement.Statement

interface PrologMachine {

	fun runStatement(statement: Statement)
}