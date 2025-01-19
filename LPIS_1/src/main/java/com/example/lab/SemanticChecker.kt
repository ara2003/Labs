package com.example.lab

import com.example.lab.statement.StatementContext

interface SemanticChecker {

	val line: Int

	fun checkContextSemantic(context: StatementContext?): Boolean {
		return true
	}
}
