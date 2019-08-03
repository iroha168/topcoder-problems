package application.controllers

import application.service.topcoder.TopcoderService
import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import scalikejdbc.ConnectionPool

class ApiController  @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def SRMProblems() = Action{
    Class.forName("com.mysql.jdbc.Driver")
    ConnectionPool.add('default, "jdbc:mysql://localhost/competitive_programming?characterEncoding=UTF-8", "iroha", "qualtagh")

    val tcService = new TopcoderService
    Ok(Json.toJson(tcService.listProblems()))
  }
}
