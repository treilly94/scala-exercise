

object CheckoutSystem {
  /** This method sums the value of the items passed into it
    *
    * @param items List[String] - Names of the items
    * @return Double
    */
  def checkout(items: List[String]): Double = {
    // Define the products/prices
    val products: Map[String, Double] = Map("Apple" -> 0.6, "Orange" -> 0.25)

    // Sum the products
    var total: Double = 0.0
    for (i <- items) {
      products.get(i) match {
        case Some(p) => total = total + p
        case None => throw new Exception(i + " is not a valid item")
      }
    }
    // Calculate discount
    val appleDiscount: Double = (items.count(_ == "Apple") / 2) * 0.6
    val orangeDiscount: Double = (items.count(_ == "Orange") / 3) * 0.25

    // Apply discount
    total - (appleDiscount + orangeDiscount)

  }

}
