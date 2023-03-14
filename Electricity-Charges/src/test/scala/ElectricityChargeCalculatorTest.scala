package com.knoldus.electricitycharges

import org.scalatest.funsuite.AnyFunSuite

class ElectricityChargeCalculatorTest extends AnyFunSuite {

  test("Test1: when unit less than zero"){
    assertThrows[IllegalArgumentException](ElectricityChargeCalculator(100,"user","India",2003,2002).calculateElectricityCharges())
  }
  test("Test2: when unit is greater than 450") {
    assert(ElectricityChargeCalculator(101, "user1", "delhi", 5062, 5904).calculateElectricityCharges() === 7073.51)
  }
  test("Test3: when unit is less than 250") {
    assert(ElectricityChargeCalculator(102, "user2", "Noida", 1050, 1150).calculateElectricityCharges() === 619.5)
  }
  test("Test4: when unit is less than 450 and greater than 250") {
    assert(ElectricityChargeCalculator(103, "user3", "Greater Noida", 4047, 4398).calculateElectricityCharges() === 2353.215)
  }
}

