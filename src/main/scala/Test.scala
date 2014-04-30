import scalikejdbc._, SQLInterpolation._

object Test extends App {
  Class.forName("org.sqlite.JDBC")
  ConnectionPool.singleton("jdbc:sqlite:test.db", null, null)

  implicit val session = AutoSession

  println(sql"""SELECT * FROM kv WHERE key == 'seq' LIMIT 1""".map(_.toMap).single().apply())
}
