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

	val headers_0 = Map("REMOTE_USER" -> "admin")

    val uri1 = "http://localhost:8080/hascode"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/hascode")
			.headers(headers_0))
		.pause(25)
		.exec(http("request_1")
			.post("/hascode/j_security_check")
			.headers(headers_0)
			.formParam("j_username", "admin")
			.formParam("j_password", "test"))
		.pause(3)
		.exec(http("request_2")
			.get("/hascode/rs/session")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}