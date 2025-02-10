package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayCalculator {

    payCalulator payCalulator;

  @BeforeEach
  void setup() {
    payCalulator = new payCalulator();
  }

  @Test
  void itCalulatesThePayForZero(){
    assertEquals(payCalulator.gross(0), 0);
  }

  @Test
  void itCalulatesThePayForOne(){
    assertEquals(payCalulator.gross(1), 16.78);
  }

  @Test
  void itCalulatesThePayFortwo(){
    assertEquals(payCalulator.gross(10), 167.80);
  }

}