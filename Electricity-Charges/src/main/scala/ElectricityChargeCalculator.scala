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

