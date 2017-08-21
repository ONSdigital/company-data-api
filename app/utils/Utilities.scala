package utils

import java.io.File
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Optional
import java.util.concurrent.atomic.AtomicInteger

import play.api.Logger
import play.api.libs.json._
import play.api.mvc.Result

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._
import scala.io.Source
import scala.util.{ Failure, Success, Try }

/**
 * Created by coolit on 18/07/2017.
 */
object Utilities {
  def currentDirectory = new File(".").getCanonicalPath

  def errAsJson(status: Int, code: String, msg: String): JsObject = {
    Json.obj(
      "status" -> status,
      "code" -> code,
      "message_en" -> msg
    )
  }

  def getElement(value: Any) = {
    val res = value match {
      case Some(i: Int) => i
      case Some(l: Long) => l
      case Some(z) => s""""${z}""""
      case x => s""""${x.toString}""""
      case None => ""
    }
    res
  }

  /**
   * Run regex on a string to check for validity
   *
   *  @param toCheck String to check
   *  @param conditions Any number of regex strings
   *  @return boolean
   */
  def checkRegex(toCheck: String, conditions: String*): Boolean = conditions.toList
    .map(x => toCheck.matches(x))
    .foldLeft(false)(_ || _)

  /**
   * Method source: https://github.com/outworkers/util/blob/develop/util-play/src/main/scala/com/outworkers/util/play/package.scala#L98
   */
  implicit class ResultAugmenter(val res: Result) {
    def future: Future[Result] = {
      Future.successful(res)
    }
  }

  def readFile(fileName: String): Iterator[String] = {
    Logger.info(s"Reading in file: $fileName")
    Try(Source.fromFile(fileName).getLines) match {
      case Success(x) => x
      case Failure(e) => throw new RuntimeException(s"Cannot read file $fileName", e)
    }
  }

  def readCsv(fileName: String): List[Map[String, String]] = {
    val counter = new AtomicInteger(0)
    val content = readFile(fileName).map(_.split(","))
    val header = content.next
    val data = content.map { z =>
      Future {
        val c = counter.incrementAndGet()
        if (c % 1000 == 0) Logger.debug(s"Processed 1000 lines of $fileName")
        header.zip(
          z.map(
            a => a.replaceAll("^\"|\"$", "")
          )
        ).toMap
      }
    }.toList
    Await.result(Future.sequence(data), 2 minutes)
  }

  def optionConverter[T](o: Optional[T]): Option[T] = if (o.isPresent) Some(o.get) else None

  def periodToYearMonth(period: String): YearMonth = {
    YearMonth.parse(period.slice(0, 6), DateTimeFormatter.ofPattern("yyyyMM"))
  }
}