package controllers

import java.util.UUID

import play.api.libs.json.{JsArray, Json}
import play.api.mvc._

class QueryController extends Controller {

  def index = Action {
    Ok(views.html.react())
  }

  // https://fb.me/react-warning-keys.
  val RESULTS = "results"
  val queryKey = "document"
  val resultKey = "result"
  val docIdKey = "id"

  var resultsJson: JsArray = Json.arr(
    Json.obj(docIdKey -> UUID.randomUUID().toString, queryKey -> "db.Events.find({})", resultKey -> "{}")
  )

  def queries = Action {
    Ok(resultsJson)
  }

  def query(query: String) = Action {

    //TODO query the mongodb

    val newResult = Json.obj(
      docIdKey -> UUID.randomUUID().toString,
      resultKey -> s"FIXME result for $query")

    resultsJson = resultsJson :+ newResult
    Ok(newResult)
  }

}
