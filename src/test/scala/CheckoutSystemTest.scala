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
  it should "return 3.0 for 5 Apples" in {
    val in: List[String] = List("Apple", "Apple", "Apple", "Apple", "Apple")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(3.0)
  }
  it should "return 25.25 for 101 Oranges" in {
    val in: List[String] = for (_ <- List.range(0, 101)) yield "Orange"
    val out: Double = CheckoutSystem.checkout(in)

    out should be(25.25)
  }
  it should "return 1.1 for 2 Oranges and 1 Apple" in {
    val in: List[String] = List("Orange", "Apple", "Orange")
    val out: Double = CheckoutSystem.checkout(in)

    out should be(1.1)
  }
}
