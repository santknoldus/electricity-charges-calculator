# Electricity Bill Generator
**Problem Statement:**
Write a program to Calculate the electricity charges of a person based on the price unit slab without using mutability along with its unit test cases.

Components:
*  Account number
*  Account username
*  Address
*  Previous unit
*  Current unit
*  Price per unit 
*  Price unit slab[0-250 = 5.25Rs per unit] [250-450 = 6.75Rs per unit] [above 450 = 8.50Rs per unit]
*  Gst charges [18%]
*  Total amount

**Sample Input:**
*  Account Number: 1001
*  Account Username: user1
*  Address: Delhi
*  Previous Unit: 5062
*  Current Unit: 5904

**Sample Output:**
*  Total Amount: 7073.51 (GST included)

### Code:
```
package com.knoldus.electricitycharges

case class ElectricityChargeCalculator(accountNumber: Int, accountUserName: String, userAddress: String, previousUnit: Double, currentUnit: Double) {
  private val unit: Double = currentUnit - previousUnit

  //generate electricity bill using given units
  def calculateElectricityCharges(): Double = {

    if (unit < 0) {
      throw new IllegalArgumentException()
    }
    else if (unit <= 250) {
      val totalAmount = unit * 5.25
      gstCalculator(totalAmount, 18)
    }
    else if (unit <= 450) {
      val totalAmount = 250 * 5.25 + (unit - 250) * 6.75
      gstCalculator(totalAmount, 18)
    }
    else {
      val totalAmount = 250 * 5.25 + 200 * 6.75 + (unit - 450) * 8.50
      gstCalculator(totalAmount, 18)
    }
  }

  def gstCalculator(taxableAmount: Double, gst: Int): Double = {
    taxableAmount + (taxableAmount * gst / 100)
  }
}
```

**Also Added Test Cases:**
```
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
```
