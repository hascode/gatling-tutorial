package com.hascode.tutorial

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:2990")
    .inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico""", """.*\.png""", """.*\.gif"""), WhiteList())
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0")

  val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "REMOTE_USER" -> "admin")

  val headers_1 = Map(
    "Accept" -> "text/css,*/*;q=0.1",
    "REMOTE_USER" -> "admin")

  val headers_2 = Map("REMOTE_USER" -> "admin")

  val headers_427 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/json",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_429 = Map(
    "Accept" -> "text/html, */*; q=0.01",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_430 = Map(
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_875 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_877 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/json; charset=utf-8",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_943 = Map(
    "Accept" -> "application/xml, text/xml, */*; q=0.01",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_944 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_945 = Map(
    "Accept" -> "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "REMOTE_USER" -> "admin",
    "X-Requested-With" -> "XMLHttpRequest")

  val uri1 = "http://localhost:2990/jira"

  object JiraHome {
    val home = exec(http("JiraHome")
      .get("/jira")
      .headers(headers_0))
      .pause(1)
  }

  object Login {
    val login = exec(http("LoginUser")
      .post("/jira/rest/gadget/1.0/login")
      .headers(headers_430)
      .formParam("os_username", "admin")
      .formParam("os_password", "admin")
      .resources(http("request_438")
        .get(uri1 + "")
        .headers(headers_0)))
      .pause(3)
  }

  val scn = scenario("RecordedSimulation")
    .exec(JiraHome.home, Login.login)
    .pause(3)
    .exec(http("request_946")
      .post("/jira/rest/analytics/1.0/publish/bulk")
      .headers(headers_427)
      .body(RawFileBody("RecordedSimulation_0946_request.txt")))
    .pause(5)
    .exec(http("request_947")
      .get("/jira/logout?atl_token=BWP3-NZB2-6EDY-6C7K|244cd562d40ca98b40fd1cf361b657ec287fa2f7|lin")
      .headers(headers_0))
    .pause(1)
    .exec(http("request_948")
      .get("/jira/s/d41d8cd98f00b204e9800998ecf8427e-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.0.17/_/download/resources/com.atlassian.devrel.developer-toolbox-plugin:dt-toolbar/toolbar.css?devtoolbar=true")
      .headers(headers_1)
      .resources(http("request_949")
        .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-navigation/aui-navigation.js?locale=en-US")
        .headers(headers_2),
        http("request_950")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-header/aui-header-responsive.js?locale=en-US")
          .headers(headers_2),
        http("request_951")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-navigation/navigation.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_952")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.ui.mouse.js?locale=en-US")
          .headers(headers_2),
        http("request_953")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/messages.js?locale=en-US")
          .headers(headers_2),
        http("request_954")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/forms.js?locale=en-US")
          .headers(headers_2),
        http("request_955")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.is-dirty.js?locale=en-US")
          .headers(headers_2),
        http("request_956")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/template.js?locale=en-US")
          .headers(headers_2),
        http("request_957")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/event.js?locale=en-US")
          .headers(headers_2),
        http("request_958")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:dialog/dialog.js?locale=en-US")
          .headers(headers_2),
        http("request_959")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.selection.js?locale=en-US")
          .headers(headers_2),
        http("request_960")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.moveto.js?locale=en-US")
          .headers(headers_2),
        http("request_961")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.progressbar.js?locale=en-US")
          .headers(headers_2),
        http("request_962")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.ui.core.js?locale=en-US")
          .headers(headers_2),
        http("request_963")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/keyCode.js?locale=en-US")
          .headers(headers_2),
        http("request_964")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/cookie.js?locale=en-US")
          .headers(headers_2),
        http("request_965")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.throbber.js?locale=en-US")
          .headers(headers_2),
        http("request_966")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/firebug.js?locale=en-US")
          .headers(headers_2),
        http("request_967")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.os.js?locale=en-US")
          .headers(headers_2),
        http("request_968")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/whenitype.js?locale=en-US")
          .headers(headers_2),
        http("request_969")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.ui.widget.js?locale=en-US")
          .headers(headers_2),
        http("request_970")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.elements.js?locale=en-US")
          .headers(headers_2),
        http("request_971")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/copyObject.js?locale=en-US")
          .headers(headers_2),
        http("request_972")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/describeBrowser.js?locale=en-US")
          .headers(headers_2),
        http("request_973")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/trace.js?locale=en-US")
          .headers(headers_2),
        http("request_974")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.users.logged-in-user.js?locale=en-US")
          .headers(headers_2),
        http("request_975")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.assistive.js?locale=en-US")
          .headers(headers_2),
        http("request_976")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/Class.js?locale=en-US")
          .headers(headers_2),
        http("request_977")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.data.cookie.js?locale=en-US")
          .headers(headers_2),
        http("request_978")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/tabs.js?locale=en-US")
          .headers(headers_2),
        http("request_979")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/Control.js?locale=en-US")
          .headers(headers_2),
        http("request_980")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/inline-dialog.js?locale=en-US")
          .headers(headers_2),
        http("request_981")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.browser.js?locale=en-US")
          .headers(headers_2),
        http("request_982")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.forms.js?locale=en-US")
          .headers(headers_2),
        http("request_983")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/util.js?locale=en-US")
          .headers(headers_2),
        http("request_984")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.ui.draggable.js?locale=en-US")
          .headers(headers_2),
        http("request_985")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/initAjaxSetup.js?locale=en-US")
          .headers(headers_2),
        http("request_986")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/getOptionsFromAttributes.js?locale=en-US")
          .headers(headers_2),
        http("request_987")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/LayerManager.js?locale=en-US")
          .headers(headers_2),
        http("request_988")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/Mouse.js?locale=en-US")
          .headers(headers_2),
        http("request_989")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/getDocHeight.js?locale=en-US")
          .headers(headers_2),
        http("request_990")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/meta.js?locale=en-US")
          .headers(headers_2),
        http("request_991")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/os.js?locale=en-US")
          .headers(headers_2),
        http("request_992")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/JSONiefix.js?locale=en-US")
          .headers(headers_2),
        http("request_993")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/hasFixedParent.js?locale=en-US")
          .headers(headers_2),
        http("request_994")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/reasons.js?locale=en-US")
          .headers(headers_2),
        http("request_995")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.form.js?locale=en-US")
          .headers(headers_2),
        http("request_996")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/Descriptor.js?locale=en-US")
          .headers(headers_2),
        http("request_997")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/simpleClick.js?locale=en-US")
          .headers(headers_2),
        http("request_998")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/version.js?locale=en-US")
          .headers(headers_2),
        http("request_999")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/observer.js?locale=en-US")
          .headers(headers_2),
        http("request_1000")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/parseOptionsFromFieldset.js?locale=en-US")
          .headers(headers_2),
        http("request_1001")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/Keyboard.js?locale=en-US")
          .headers(headers_2),
        http("request_1002")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/setSelectionRange.js?locale=en-US")
          .headers(headers_2),
        http("request_1003")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/LocalStorage.js?locale=en-US")
          .headers(headers_2),
        http("request_1004")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/persistence.js?locale=en-US")
          .headers(headers_2),
        http("request_1005")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/parseUri.js?locale=en-US")
          .headers(headers_2),
        http("request_1006")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:internal-ajs-no-context-path/jquery.ui.sortable.js?locale=en-US")
          .headers(headers_2),
        http("request_1007")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/SessionStorage.js?locale=en-US")
          .headers(headers_2),
        http("request_1008")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/jira.util.objects.js?locale=en-US")
          .headers(headers_2),
        http("request_1009")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/XSRF.js?locale=en-US")
          .headers(headers_2),
        http("request_1010")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/JSON.js?locale=en-US")
          .headers(headers_2),
        http("request_1011")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/AjaxUtil.js?locale=en-US")
          .headers(headers_2),
        http("request_1012")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/jquery.pjax.js?locale=en-US")
          .headers(headers_2),
        http("request_1013")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/handleAccessKeys.js?locale=en-US")
          .headers(headers_2),
        http("request_1014")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/GroupDescriptor.js?locale=en-US")
          .headers(headers_2),
        http("request_1015")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/ItemDescriptor.js?locale=en-US")
          .headers(headers_2),
        http("request_1016")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/PageableList.js?locale=en-US")
          .headers(headers_2),
        http("request_1017")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/effects.js?locale=en-US")
          .headers(headers_2),
        http("request_1018")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util/bindDefaultCustomEvent.js?locale=en-US")
          .headers(headers_2),
        http("request_1019")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/ListWithMessages.js?locale=en-US")
          .headers(headers_2),
        http("request_1020")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:util-lite/SmartAjax.js?locale=en-US")
          .headers(headers_2),
        http("request_1021")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:issue-table/jquery.dragtable.js?locale=en-US")
          .headers(headers_2),
        http("request_1022")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/MessageDescriptor.js?locale=en-US")
          .headers(headers_2),
        http("request_1023")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/ItemDescriptorFactory.js?locale=en-US")
          .headers(headers_2),
        http("request_1024")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/Group.js?locale=en-US")
          .headers(headers_2),
        http("request_1025")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.1.7/_/download/resources/com.atlassian.plugins.issue-status-plugin:issue-status-resources/issue-status-plugin.js?locale=en-US")
          .headers(headers_2),
        http("request_1026")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:issue-table/issueActionsFragment.js?locale=en-US")
          .headers(headers_2),
        http("request_1027")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/table.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1028")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/aui.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1029")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/badges.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1030")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.1.7/_/download/resources/com.atlassian.plugins.issue-status-plugin:issue-status-resources/issue-status.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1031")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/tabs.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1032")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/panel.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1033")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/trigger.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1034")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/icons.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1035")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/expander.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1036")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:issue-table/issueActionsDropdown.js?locale=en-US")
          .headers(headers_2),
        http("request_1037")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:js-soy-templates/jira-dialogs-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1038")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:js-soy-templates/jira-pageheader-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1039")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/group.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1040")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/lozenges.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1041")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/sidebar.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1042")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/toolbar2.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1043")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:list/List.js?locale=en-US")
          .headers(headers_2),
        http("request_1044")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:messages/flags.js?locale=en-US")
          .headers(headers_2),
        http("request_1045")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-dialog-core/DialogFactory.js?locale=en-US")
          .headers(headers_2),
        http("request_1046")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-dialog-core/dirtyFormWarning.js?locale=en-US")
          .headers(headers_2),
        http("request_1047")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-dialog-core/DialogRegister.js?locale=en-US")
          .headers(headers_2),
        http("request_1048")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:messages/messages.js?locale=en-US")
          .headers(headers_2),
        http("request_1049")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/dropdown.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1050")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-issuenavigator/Issue.js?locale=en-US")
          .headers(headers_2),
        http("request_1051")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/MultiSelect.LozengeGroup.js?locale=en-US")
          .headers(headers_2),
        http("request_1052")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/avatar.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1053")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-issuenavigator/IssueNavigator.js?locale=en-US")
          .headers(headers_2),
        http("request_1054")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/CheckboxMultiSelectStatusLozenge.js?locale=en-US")
          .headers(headers_2),
        http("request_1055")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/shifter.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1056")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/LabelPicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1057")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/ShifterController.js?locale=en-US")
          .headers(headers_2),
        http("request_1058")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/shifter.js?locale=en-US")
          .headers(headers_2),
        http("request_1059")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/MultiSelect.Lozenge.js?locale=en-US")
          .headers(headers_2),
        http("request_1060")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:inline-attach/jquery.inlineAttach.js?locale=en-US")
          .headers(headers_2),
        http("request_1061")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/ShifterDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1062")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/CheckboxMultiSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1063")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/ErrorDialog.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1064")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/SingleSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1065")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/SelectHelper.js?locale=en-US")
          .headers(headers_2),
        http("request_1066")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/IssueActionsDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1067")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/ShifterSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1068")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/SmartAjaxWebSudo.js?locale=en-US")
          .headers(headers_2),
        http("request_1069")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/ScreenshotDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1070")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/userhover.js?locale=en-US")
          .headers(headers_2),
        http("request_1071")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/FormDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1072")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:shifter/ShifterAnalytics.js?locale=en-US")
          .headers(headers_2),
        http("request_1073")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/initUserhover.js?locale=en-US")
          .headers(headers_2),
        http("request_1074")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/LinkIssueDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1075")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/LabelsDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1076")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:default-comment-security-level/DefaultCommentSecurityLevelModel.js?locale=en-US")
          .headers(headers_2),
        http("request_1077")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dropdown-select/DropdownSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1078")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-issuenavigator/IssueNavigator.Shortcuts.js?locale=en-US")
          .headers(headers_2),
        http("request_1079")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/IssuePicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1080")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-trigger/aui-trigger.js?locale=en-US")
          .headers(headers_2),
        http("request_1081")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/ScrollableSingleSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1082")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dropdown-select/SecurityLevelSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1083")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/MultiSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1084")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:messages/message-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1085")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:default-comment-security-level/DefaultCommentSecurityLevelControl.js?locale=en-US")
          .headers(headers_2),
        http("request_1086")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/ErrorDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1087")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/SuggestionHandlers.js?locale=en-US")
          .headers(headers_2),
        http("request_1088")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:default-comment-security-level/SecuritySelectAdapter.js?locale=en-US")
          .headers(headers_2),
        http("request_1089")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/QueryableDropdownSelect.js?locale=en-US")
          .headers(headers_2),
        http("request_1090")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:assignee-picker/AssigneePicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1091")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/dark-features.js?locale=en-US")
          .headers(headers_2),
        http("request_1092")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:inline-attach/InlineAttach.js?locale=en-US")
          .headers(headers_2),
        http("request_1093")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-inline-dialog2/inline-dialog2.js?locale=en-US")
          .headers(headers_2),
        http("request_1094")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/expandOnInput.js?locale=en-US")
          .headers(headers_2),
        http("request_1095")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:assignee-picker/initAssigneePickers.js?locale=en-US")
          .headers(headers_2),
        http("request_1096")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initDialogBehaviour.js?locale=en-US")
          .headers(headers_2),
        http("request_1097")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/color.js?locale=en-US")
          .headers(headers_2),
        http("request_1098")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/overlabel.js?locale=en-US")
          .headers(headers_2),
        http("request_1099")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initWorkflowTransitionDialogs.js?locale=en-US")
          .headers(headers_2),
        http("request_1100")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initDialogs.js?locale=en-US")
          .headers(headers_2),
        http("request_1101")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/wikiPreview.js?locale=en-US")
          .headers(headers_2),
        http("request_1102")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/ToggleList.js?locale=en-US")
          .headers(headers_2),
        http("request_1103")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-dialog-core/Dialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1104")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/page.js?locale=en-US")
          .headers(headers_2),
        http("request_1105")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-inline-dialog2/inline-dialog2.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1106")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initDashboardDialogs.js?locale=en-US")
          .headers(headers_2),
        http("request_1107")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initGenericDialogs.js?locale=en-US")
          .headers(headers_2),
        http("request_1108")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/DropdownFactory.js?locale=en-US")
          .headers(headers_2),
        http("request_1109")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initDropdowns.js?locale=en-US")
          .headers(headers_2),
        http("request_1110")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/webSudo.js?locale=en-US")
          .headers(headers_2),
        http("request_1111")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:default-comment-security-level/CommentSecurityLevelView.js?locale=en-US")
          .headers(headers_2),
        http("request_1112")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/ProjectSample.js?locale=en-US")
          .headers(headers_2),
        http("request_1113")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/toggleField.js?locale=en-US")
          .headers(headers_2),
        http("request_1114")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/DefaultDropdownElement.js?locale=en-US")
          .headers(headers_2),
        http("request_1115")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/labels.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1116")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/progress-tracker.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1117")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:js-soy-templates/jira-links-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1118")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initCreateProjectField.js?locale=en-US")
          .headers(headers_2),
        http("request_1119")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:select-pickers/QueryableSelect-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1120")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/ProjectKeyGenerator.js?locale=en-US")
          .headers(headers_2),
        http("request_1121")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/createProject.js?locale=en-US")
          .headers(headers_2),
        http("request_1122")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/message.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1123")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:js-soy-templates/status-category-field-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1124")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/ProjectEditKey.js?locale=en-US")
          .headers(headers_2),
        http("request_1125")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:key-commands/keyevents.js?locale=en-US")
          .headers(headers_2),
        http("request_1126")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/createEditProjectDialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1127")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/projectSampleTemplate.js?locale=en-US")
          .headers(headers_2),
        http("request_1128")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/IssueActionsTriggerElement.js?locale=en-US")
          .headers(headers_2),
        http("request_1129")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:key-commands/whenIType.js?locale=en-US")
          .headers(headers_2),
        http("request_1130")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initProjectEditKey.js?locale=en-US")
          .headers(headers_2),
        http("request_1131")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-trigger/aui-trigger.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1132")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:key-commands/shortcuts.js?locale=en-US")
          .headers(headers_2),
        http("request_1133")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:key-commands/KeyboardShortcuts.js?locale=en-US")
          .headers(headers_2),
        http("request_1134")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:key-commands/initKeyboardShortcuts.js?locale=en-US")
          .headers(headers_2),
        http("request_1135")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/license-banner.js?locale=en-US")
          .headers(headers_2),
        http("request_1136")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/initNonDashboardDialogs.js?locale=en-US")
          .headers(headers_2),
        http("request_1137")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:header/headerModule.js?locale=en-US")
          .headers(headers_2),
        http("request_1138")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-pickers/NoBrowseUserNamePicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1139")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/CreateProjectField.js?locale=en-US")
          .headers(headers_2),
        http("request_1140")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-pickers/initMultiUserPickers.js?locale=en-US")
          .headers(headers_2),
        http("request_1141")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/isDirty.js?locale=en-US")
          .headers(headers_2),
        http("request_1142")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:field-templates/assigneeField.js?locale=en-US")
          .headers(headers_2),
        http("request_1143")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:header/initHeader.js?locale=en-US")
          .headers(headers_2),
        http("request_1144")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-pickers/initSingleUserPickers.js?locale=en-US")
          .headers(headers_2),
        http("request_1145")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/jquery.dotdotdot-1.5.7.js?locale=en-US")
          .headers(headers_2),
        http("request_1146")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/Config.js?locale=en-US")
          .headers(headers_2),
        http("request_1147")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/toolbar.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1148")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.0.8/_/download/resources/com.atlassian.plugins.jira-project-creation:project-creation-resources/xdr.js?locale=en-US")
          .headers(headers_2),
        http("request_1149")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/app.js?locale=en-US")
          .headers(headers_2),
        http("request_1150")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/SelectProjectTemplateController.js?locale=en-US")
          .headers(headers_2),
        http("request_1151")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/CreateSharedView.js?locale=en-US")
          .headers(headers_2),
        http("request_1152")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/DialogView.js?locale=en-US")
          .headers(headers_2),
        http("request_1153")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/TemplateInfoView.js?locale=en-US")
          .headers(headers_2),
        http("request_1154")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:dialogs/linkissue.js?locale=en-US")
          .headers(headers_2),
        http("request_1155")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/ProjectKeyGenerator.js?locale=en-US")
          .headers(headers_2),
        http("request_1156")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/page.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1157")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/SelectProjectTemplateView.js?locale=en-US")
          .headers(headers_2),
        http("request_1158")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.0.8/_/download/resources/com.atlassian.plugins.jira-project-creation:project-creation-resources/project-creation-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1159")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/CreateSharedController.js?locale=en-US")
          .headers(headers_2),
        http("request_1160")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/dropdown2.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1161")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/ProjectTemplatesList.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1162")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:jira-global/ToggleBlock.js?locale=en-US")
          .headers(headers_2),
        http("request_1163")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/TemplateInfoController.js?locale=en-US")
          .headers(headers_2),
        http("request_1164")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/buttons.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1165")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/DialogController.js?locale=en-US")
          .headers(headers_2),
        http("request_1166")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/RemoteProjectsCreatedMessage.js?locale=en-US")
          .headers(headers_2),
        http("request_1167")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-pickers/userPickerUtil.js?locale=en-US")
          .headers(headers_2),
        http("request_1168")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:field-templates/singleUserPicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1169")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/AddProjectController.js?locale=en-US")
          .headers(headers_2),
        http("request_1170")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-web-plugin:issue-link-web-link/issuelink-weblink.js?locale=en-US")
          .headers(headers_2),
        http("request_1171")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:administration-shortcuts-resources/adminshortcuts-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1172")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-projectshortcuts/projectshortcuts-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1173")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/AddProjectView.js?locale=en-US")
          .headers(headers_2),
        http("request_1174")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:administration-shortcuts-resources/adminnavlinks.js?locale=en-US")
          .headers(headers_2),
        http("request_1175")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:momentjs/moment.lib.js?locale=en-US")
          .headers(headers_2),
        http("request_1176")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:momentjs/moment.jira.formatter.js?locale=en-US")
          .headers(headers_2),
        http("request_1177")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:momentjs/moment.legacy.js?locale=en-US")
          .headers(headers_2),
        http("request_1178")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.0.8/_/download/resources/com.atlassian.plugins.jira-project-creation:project-creation-resources/project-creation.js?locale=en-US")
          .headers(headers_2),
        http("request_1179")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/ie_version.js?locale=en-US")
          .headers(headers_2),
        http("request_1180")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:momentjs/moment.jira.js?locale=en-US")
          .headers(headers_2),
        http("request_1181")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/trace.js?locale=en-US")
          .headers(headers_2),
        http("request_1182")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/resource-uris.js?locale=en-US")
          .headers(headers_2),
        http("request_1183")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/executor.js?locale=en-US")
          .headers(headers_2),
        http("request_1184")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/path.js?locale=en-US")
          .headers(headers_2),
        http("request_1185")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/requireDeployJava.js?locale=en-US")
          .headers(headers_2),
        http("request_1186")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/tracking.js?locale=en-US")
          .headers(headers_2),
        http("request_1187")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/issue-paste.js?locale=en-US")
          .headers(headers_2),
        http("request_1188")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/initialize.js?locale=en-US")
          .headers(headers_2),
        http("request_1189")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-projectshortcuts/projectshortcuts.js?locale=en-US")
          .headers(headers_2),
        http("request_1190")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/CreateSharedProject.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1191")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:momentjs/moment.jira.i18n.js?locale=en-US")
          .headers(headers_2),
        http("request_1192")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-remote-jira-plugin:issue-link-jira-search-js/js/issuelink-jira-jqlautocomplete.js?locale=en-US")
          .headers(headers_2),
        http("request_1193")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/html5.js?locale=en-US")
          .headers(headers_2),
        http("request_1194")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/attach-screenshot-form-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1195")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/polyfill.js?locale=en-US")
          .headers(headers_2),
        http("request_1196")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-applinks-common-plugin:issue-link-applinks/issuelink-applinks.js?locale=en-US")
          .headers(headers_2),
        http("request_1197")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira.project-templates-plugin:project-templates-plugin-resources/AddProject.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1198")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/5.7.31/_/download/resources/com.atlassian.auiplugin:aui-experimental-soy-templates/form.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1199")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/GravatarUtils.js?locale=en-US")
          .headers(headers_2),
        http("request_1200")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-remote-jira-plugin:issue-link-remote-jira-js/issuelink-jira.js?locale=en-US")
          .headers(headers_2),
        http("request_1201")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/AvatarPicker-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1202")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-remote-jira-plugin:issue-link-jira-search-js/js/issuelink-jira-search.js?locale=en-US")
          .headers(headers_2),
        http("request_1203")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/Avatar.js?locale=en-US")
          .headers(headers_2),
        http("request_1204")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/AvatarUtil.js?locale=en-US")
          .headers(headers_2),
        http("request_1205")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/AvatarPicker.js?locale=en-US")
          .headers(headers_2),
        http("request_1206")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/3.1.8/_/download/resources/com.atlassian.jira.jira-quick-edit-plugin:quick-create-issue-bootstrap/create-bootstrap-wrm.js?locale=en-US")
          .headers(headers_2),
        http("request_1207")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/3.1.8/_/download/resources/com.atlassian.jira.jira-quick-edit-plugin:loading-indicator/loading-indicator.js?locale=en-US")
          .headers(headers_2),
        http("request_1208")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/AvatarStore.js?locale=en-US")
          .headers(headers_2),
        http("request_1209")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/avataror.js?locale=en-US")
          .headers(headers_2),
        http("request_1210")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.0.7/_/download/resources/com.atlassian.jira.plugins.jira-admin-helper-plugin:dialog-resources/notification-helper-init.js?locale=en-US")
          .headers(headers_2),
        http("request_1211")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.0.7/_/download/resources/com.atlassian.jira.plugins.jira-admin-helper-plugin:dialog-resources/dialog.js?locale=en-US")
          .headers(headers_2),
        http("request_1212")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.0.7/_/download/resources/com.atlassian.jira.plugins.jira-admin-helper-plugin:dialog-resources/permission-helper-init.js?locale=en-US")
          .headers(headers_2),
        http("request_1213")
          .get(uri1 + "/s/d41d8cd98f00b204e9800998ecf8427e-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.0.17/_/download/resources/com.atlassian.devrel.developer-toolbox-plugin:dt-toolbar/toolbar.js?devtoolbar=true")
          .headers(headers_2),
        http("request_1214")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.0.7/_/download/resources/com.atlassian.jira.plugins.jira-admin-helper-plugin:dialog-resources/whereismycf-init.js?locale=en-US")
          .headers(headers_2),
        http("request_1215")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0.5/_/download/resources/com.atlassian.plugins.helptips.jira-help-tips:common/helptip.js?locale=en-US")
          .headers(headers_2),
        http("request_1216")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-header-plugin:newsletter-signup-tip/static/components/newsletter/initNewsletterSignup.js?locale=en-US")
          .headers(headers_2),
        http("request_1217")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-remote-jira-plugin:issue-link-jira-search-js/templates/dialog/linkjiraissue-search-html.js?locale=en-US")
          .headers(headers_2),
        http("request_1218")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0.5/_/download/resources/com.atlassian.plugins.helptips.jira-help-tips:common/helptip-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1219")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/KeyTester.js?locale=en-US")
          .headers(headers_2),
        http("request_1220")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/UndoableTextarea.js?locale=en-US")
          .headers(headers_2),
        http("request_1221")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-confluence-plugin:issue-link-confluence-js/issuelink-confluence.js?locale=en-US")
          .headers(headers_2),
        http("request_1222")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/keymaster-setup.js?locale=en-US")
          .headers(headers_2),
        http("request_1223")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/Analytics.js?locale=en-US")
          .headers(headers_2),
        http("request_1224")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-menu/appswitcher_old.js?locale=en-US")
          .headers(headers_2),
        http("request_1225")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/TextareaManipulator.js?locale=en-US")
          .headers(headers_2),
        http("request_1226")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-confluence-plugin:confluence-page-resource/js/ConfluencePageSearch.js?locale=en-US")
          .headers(headers_2),
        http("request_1227")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/UndoManager.js?locale=en-US")
          .headers(headers_2),
        http("request_1228")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/keymaster.js?locale=en-US")
          .headers(headers_2),
        http("request_1229")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/SpeechRecognition.js?locale=en-US")
          .headers(headers_2),
        http("request_1230")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/WikiEditorUtil.js?locale=en-US")
          .headers(headers_2),
        http("request_1231")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-issue-link-confluence-plugin:confluence-page-resource/templates/dialog/searchresult-html.js?locale=en-US")
          .headers(headers_2),
        http("request_1232")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/amd-wrappers.js?locale=en-US")
          .headers(headers_2),
        http("request_1233")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-header-plugin:jira-header/header-dropdown.js?locale=en-US")
          .headers(headers_2),
        http("request_1234")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/WikiEnabledTextarea.js?locale=en-US")
          .headers(headers_2),
        http("request_1235")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-header-plugin:newsletter-signup-tip/static/components/newsletter/NewsletterSignup.js?locale=en-US")
          .headers(headers_2),
        http("request_1236")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-header-plugin:jira-header/init-dropdown2.js?locale=en-US")
          .headers(headers_2),
        http("request_1237")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/6.1.0/_/download/resources/com.atlassian.jira-core-project-templates:jira-core-project-templates-resources/CoreProjectTemplates.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1238")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:avatar-picker/AvatarManager.js?locale=en-US")
          .headers(headers_2),
        http("request_1239")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-menu/appswitcher.js?locale=en-US")
          .headers(headers_2),
        http("request_1240")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-message-flags/admin-flags-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1241")
          .get(uri1 + "/s/2bfa0c8022fc58affc19dbcaa92228a2-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/2.3.1/_/download/resources/com.atlassian.administration.atlassian-admin-quicksearch-jira:admin-quicksearch-webresources/adminQuickNav.js?locale=en-US")
          .headers(headers_2),
        http("request_1242")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.3.3/_/download/resources/com.atlassian.labs.hipchat.hipchat-for-jira-plugin:update-plugin-banner-resources/update-hipchat-link-banner.js?locale=en-US")
          .headers(headers_2),
        http("request_1243")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0.5/_/download/resources/com.atlassian.plugins.helptips.jira-help-tips:common/helptipmanager.js?locale=en-US")
          .headers(headers_2),
        http("request_1244")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/WikiEditor.js?locale=en-US")
          .headers(headers_2),
        http("request_1245")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.1.0/_/download/resources/com.atlassian.jira.jira-header-plugin:newsletter-signup-tip/static/components/newsletter/NewsletterSignup.soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1246")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/7.3.3/_/download/resources/com.atlassian.labs.hipchat.hipchat-for-jira-plugin:update-plugin-banner-resources/update-hipchat-link-banner-client.js?locale=en-US")
          .headers(headers_2),
        http("request_1247")
          .get(uri1 + "/s/46f82e5e6383d86dac2e9666fa4c84fc-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:user-message-flags/admin-flags.js?locale=en-US")
          .headers(headers_2),
        http("request_1248")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.11/_/download/resources/com.atlassian.jira.plugins.jira-dnd-attachment-plugin:jira-html5-attach-images-resources/deployJava.js?locale=en-US")
          .headers(headers_2),
        http("request_1249")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-menu/appswitcher-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1250")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/4.2.4/_/download/resources/com.atlassian.plugins.atlassian-nav-links-plugin:rotp-menu/appswitcher_old-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1251")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.9.9/_/download/resources/com.atlassian.jira.plugins.jira-wiki-editor:wiki-editor-resources/wiki-editor-soy.js?locale=en-US")
          .headers(headers_2),
        http("request_1252")
          .post(uri1 + "/rest/webResources/1.0/resources")
          .headers(headers_427)
          .body(RawFileBody("RecordedSimulation_1252_request.txt")),
        http("request_1253")
          .post(uri1 + "/rest/webResources/1.0/resources")
          .headers(headers_427)
          .body(RawFileBody("RecordedSimulation_1253_request.txt")),
        http("request_1254")
          .get(uri1 + "/plugins/servlet/dev-toolbar?_=1461174922792")
          .headers(headers_429),
        http("request_1255")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:mentions-feature/UncomplicatedInlineLayer.js?locale=en-US")
          .headers(headers_2),
        http("request_1256")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:mentions-feature/Mention.Group.js?locale=en-US")
          .headers(headers_2),
        http("request_1257")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:mentions-feature/Mention-element.js?locale=en-US")
          .headers(headers_2),
        http("request_1258")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:mentions-feature/Mention-templates.js?locale=en-US")
          .headers(headers_2),
        http("request_1259")
          .get(uri1 + "/s/73cc4183512f4c2468fa709054a097bf-CDN/en_US-um35yr/71002/b6b48b2829824b869586ac216d119363/1.0/_/download/resources/jira.webresources:mentions-feature/Mention.js?locale=en-US")
          .headers(headers_2)))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}