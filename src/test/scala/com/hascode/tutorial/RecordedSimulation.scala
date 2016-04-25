package com.hascode.tutorial

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico""", """.*\.png""", """.*\.gif"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0")

  val uri1 = "http://localhost:8080/hascode"

  object HomePage {
    val home = exec(http("StartPage")
      .get("/hascode"))
      .pause(25)
  }

  object LoginPage {
    val loginProperties = csv("user-login.csv").random

    val login = feed(loginProperties).exec(http("LoginPage")
      .post("/hascode/j_security_check")
      .formParam("j_username", "${username}")
      .formParam("j_password", "${password}"))
      .pause(3)
  }

  object UserInfoPage {
    val info = exec(http("UserInformation")
      .get("/hascode/rs/session"))
  }

  val scenario1 = scenario("JavaMultiuserScenario")
    .exec(HomePage.home, LoginPage.login, UserInfoPage.info)
    
  val scenario2 = scenario("JavaMultiuserScenario")
    .exec(HomePage.home, LoginPage.login)

  setUp(scenario1.inject(rampUsers(10) over (10 seconds), rampUsers(2) over (10 seconds))).protocols(httpProtocol)
}