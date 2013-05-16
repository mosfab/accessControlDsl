/**
 * Created with IntelliJ IDEA.
 * User: Fabian Moser
 * Date: 06.05.13
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */


object Main extends App {


  println("hi")
  val ret = myProtectedMethod2("Yay")
  println(ret)

  def permit_if[T](condition: Boolean)(f: => T): T = {
    if (condition) f
    else throw new Exception("Permit conditions not met!")
  }

  /*  def myProtectedMethod(param: String):Any = {
      permit if_this  (1 == 1) or (param == "Yay") holds {
        return "Access granted and everything fine"
      }
    }*/


  def myProtectedMethod2(param: String): Int =
    permit_if(param.startsWith("Y") & (1==1)) {
      var x:Int = -1
      //Do some useful things
      return x
    }


  case class Cpu(cpus: Int, arch: String)

  class CpuInt(qty: Int) {
    def cpus(arch: String) = {
      Cpu(qty, arch)
    }
  }

  object permit {
    var placeholder: Boolean = false


    def myIf[T](condition: Boolean)(f: => T): T = {
      if (condition) f
      else throw new Exception("Permit conditions not met!")
    }

    def if_this(_expr: => Boolean) = {
      placeholder = _expr
      this
    }

    def and(_expr: => Boolean) = {
      placeholder = _expr
      this
    }

    def or(_expr: => Boolean) = {
      placeholder = _expr
      this
    }

    def xor(_expr: => Boolean) = {
      placeholder = _expr
      this
    }

    def holds(code: => Any): Any = {
      if (placeholder)
        return code
      else
        throw new IllegalAccessException()
    }




  }


}

