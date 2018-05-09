import org.scalatest.{FlatSpec, Matchers}

class CheckoutSystemTest extends FlatSpec with Matchers {
  "The Checkout" should "return 0.6 for 1 Apple" in {
    val in: List[String] = List("Apple")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(0.6)
  }
  it should "return 0.25 for 1 Orange" in {
    val in: List[String] = List("Orange")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(0.25)
  }
  it should "return 0.0 for a empty list" in {
    val in: List[String] = List()
    val out: Double = CheckoutSystem.checkout(in)

    out should be(0.0)
  }
  it should "return 1.8 for 5 Apples" in {
    val in: List[String] = List("Apple", "Apple", "Apple", "Apple", "Apple")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(1.8)
  }
  it should "return 16.75 for 101 Oranges" in {
    val in: List[String] = for (_ <- List.range(0, 101)) yield "Orange"
    val out: Double = CheckoutSystem.checkout(in)

    out should be(16.75)
  }
  it should "return 1.1 for 2 Oranges and 1 Apple" in {
    val in: List[String] = List("Orange", "Apple", "Orange")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(1.1)
  }
  it should "throw an error if the item is not a Apple or Orange" in {
    val in: List[String] = List("Orange", "Apple", "Bananna")

    val caught: Exception =
    intercept[Exception] {
      CheckoutSystem.checkout(in)
    }

    caught.getMessage should be("Bananna is not a valid item")
  }
}
