package com.feature.others;

import java.util.List;

public interface Expression {
  record Variable(String name, int value) {}
  record AddExpression(Variable left, Variable right) implements Expression  {}
  record MultipleExpression(Variable left, Variable right) implements Expression {}

  static void solve(List<Expression> expressions) {
    for (Expression exp : expressions) {
      switch (exp) {
        case AddExpression(var left, var right) -> System.out.println(left.value() + right.value);
        case MultipleExpression(var left, var right) -> System.out.println(left.value() * right.value);
        default -> System.out.println("");
      }

    }
  }

  public static void main(String[] args) {
    solve(List.of(
        new AddExpression(new Variable("a", 5), new Variable("b", 10)),
        new MultipleExpression(new Variable("a", 5), new Variable("b", 10))));
  }

}
