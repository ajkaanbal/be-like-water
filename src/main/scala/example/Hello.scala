package example


import shapeless._

case class Node[T,R](f: T => R)

object Hello extends Greeting {
  println(greeting)
  // Lets do some stuff
}

trait Greeting {
  lazy val greeting: String = "hello"
}
