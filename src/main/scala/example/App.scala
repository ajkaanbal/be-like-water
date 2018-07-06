import shapeless._

case class Schema(name: String)

trait CsvEncoder[A, B] {
  def encode(o: A): B
}

object CsvEncoder {
  implicit val intEncoder = new CsvEncoder[Int, String] {
    def encode(o: Int): String = o.toString
  }

  implicit val stringToInt = new CsvEncoder[String, Int] {
    def encode(s: String): Int = s.size
  }
  implicit val listToHlist = new CsvEncoder[List[Int], HList] {
    def encode(l: List[Int]): HList = {
      HNil
    }
  }
  // implicit val stringEncoder = new CsvEncoder[String] {
    // def encode(o: String): List[String] = List(o)
  // }

  // implicit val schemaEncoder = new CsvEncoder[Schema] {
    // def encode(schema: Schema): List[String] = List(schema.name)
  // }
}


object Main extends App{
  def encode[A, B](a: A)(implicit encoder: CsvEncoder[A, B]) = encoder.encode(a)

  println("dddd")
  println(encode(1))
  println(encode("abc"))
  println(encode(List(1,2,3)))

  // val schema = Schema("nous")
  // println(encode(schema))
}
