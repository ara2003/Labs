package com.example.labs.prolog

import org.junit.jupiter.api.Assertions.*

fun assertEqualsAsSet(expected: Iterable<*>, actual: Iterable<*>) {
	assertEquals(expected.toSet(), actual.toSet())
}

fun assertEqualsAsList(expected: Iterable<*>, actual: Iterable<*>) {
	assertEquals(expected.toList(), actual.toList())
}