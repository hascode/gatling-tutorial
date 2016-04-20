package com.hascode.tutorial

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:1990")
		.inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico""", """.*\.png""", """.*\.gif"""), WhiteList())
		.acceptHeader("application/json, text/javascript, */*; q=0.01")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"REMOTE_USER" -> "admin")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"REMOTE_USER" -> "admin")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"REMOTE_USER" -> "admin")

	val headers_6 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity",
		"REMOTE_USER" -> "admin")

	val headers_7 = Map(
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_8 = Map(
		"Accept" -> "text/html, */*; q=0.01",
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_9 = Map(
		"Content-Type" -> "application/json",
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_16 = Map(
		"Content-Type" -> "application/json; charset=utf-8",
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_26 = Map(
		"Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5",
		"REMOTE_USER" -> "admin")

	val headers_28 = Map(
		"Accept" -> "*/*",
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_34 = Map(
		"Accept" -> "text/plain, */*; q=0.01",
		"REMOTE_USER" -> "admin",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "http://localhost:1990/confluence"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/confluence/login.action")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/s/6c0981174e94142364564819dc0d1413-CDN/en_GB/5982/NOCACHE1/1.0/_/download/resources/confluence.web.resources:login/login.js?locale=en-GB")
			.headers(headers_1),
            http("request_2")
			.get(uri1 + "/s/68c89f96e4b7a97686e54444b4414780-CDN/en_GB/5982/NOCACHE1/c7b8eac9b0eb1776b3181ce6daccf519/_/download/contextbatch/css/main,atl.general/batch.css?flavour=VANILLA&devtoolbar=true")
			.headers(headers_2),
            http("request_3")
			.get(uri1 + "/s/3aa86da69e04e0994a1c8ccbe7db012a-CDN/en_GB/5982/NOCACHE1/c7b8eac9b0eb1776b3181ce6daccf519/_/download/contextbatch/js/main,atl.general/batch.js?devtoolbar=true&flavour=VANILLA&analytics-enabled=true&locale=en-GB&is-server-instance=true&hostenabled=true")
			.headers(headers_1),
            http("request_4")
			.get(uri1 + "/s/db0b7591cfadbadc1dd90174b2a158c5-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/js/batch.js?source=webContextStatic&atlassian.aui.raphael.disabled=true&locale=en-GB&build-number=5982")
			.headers(headers_1),
            http("request_5")
			.get(uri1 + "/s/43d467b830bb2d49d16b8efa994dc1dc-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/css/batch.css?build-number=5982")
			.headers(headers_2),
            http("request_6")
			.get(uri1 + "/s/en_GB/5982/NOCACHE1/5.7.26/_/download/resources/com.atlassian.auiplugin:aui-experimental-iconfont/atlassian-icons.woff")
			.headers(headers_6),
            http("request_7")
			.get(uri1 + "/rest/shortcuts/latest/shortcuts/5982/8691841740820c37a8b7174830a427d4")
			.headers(headers_7),
            http("request_8")
			.get(uri1 + "/plugins/servlet/dev-toolbar")
			.headers(headers_8),
            http("request_9")
			.post(uri1 + "/rest/analytics/1.0/publish/bulk")
			.headers(headers_9)
			.body(RawFileBody("RecordedSimulation_0009_request.txt"))))
		.pause(8)
		.exec(http("request_10")
			.post("/confluence/dologin.action")
			.headers(headers_0)
			.formParam("os_username", "admin")
			.formParam("os_password", "admin")
			.formParam("login", "Log in")
			.formParam("os_destination", "")
			.resources(http("request_11")
			.get(uri1 + "/s/4ff8766b0e23eb553773fd9bd6f00020-CDN/en_GB/5982/NOCACHE1/bbfa3e2c2b5e893180dc19e93b9e8d32/_/download/contextbatch/css/dashboard,atl.general,main/batch.css?devtoolbar=true&isAdmin=true&flavour=VANILLA&user-logged-in=true")
			.headers(headers_2),
            http("request_12")
			.get(uri1 + "/s/5581b279d13d2b329bc0cb54e973d418-CDN/en_GB/5982/NOCACHE1/bbfa3e2c2b5e893180dc19e93b9e8d32/_/download/contextbatch/js/dashboard,atl.general,main/batch.js?devtoolbar=true&isSystemAdministrator=true&flavour=VANILLA&analytics-enabled=true&isAdmin=true&locale=en-GB&user-logged-in=true&is-server-instance=true&hostenabled=true")
			.headers(headers_1),
            http("request_13")
			.get(uri1 + "/s/db0b7591cfadbadc1dd90174b2a158c5-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/js/batch.js?source=webContextStatic&atlassian.aui.raphael.disabled=true&locale=en-GB&build-number=5982")
			.headers(headers_1),
            http("request_14")
			.get(uri1 + "/s/43d467b830bb2d49d16b8efa994dc1dc-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/css/batch.css?build-number=5982")
			.headers(headers_2),
            http("request_15")
			.get(uri1 + "/rest/shortcuts/latest/shortcuts/5982/8691841740820c37a8b7174830a427d4")
			.headers(headers_7),
            http("request_16")
			.get(uri1 + "/rest/popular/1/stream/content?days=7&pageSize=20")
			.headers(headers_16),
            http("request_17")
			.get(uri1 + "/rest/mywork/latest/status/notification/count")
			.headers(headers_7),
            http("request_18")
			.get(uri1 + "/plugins/servlet/dev-toolbar")
			.headers(headers_8),
            http("request_19")
			.post(uri1 + "/rest/analytics/1.0/publish/bulk")
			.headers(headers_9)
			.body(RawFileBody("RecordedSimulation_0019_request.txt"))))
		.pause(4)
		.exec(http("request_20")
			.get("/confluence/display/ds")
			.headers(headers_0)
			.resources(http("request_21")
			.get(uri1 + "/s/en_GB/5982/NOCACHE1/4/_/styles/colors.css?spaceKey=ds")
			.headers(headers_2),
            http("request_22")
			.get(uri1 + "/s/5d9e2ca98c4010be3e9ca6dbbc4726d7-CDN/en_GB/5982/NOCACHE1/84e42deaaeed87a3db69bb72f0824edc/_/download/contextbatch/css/page,viewcontent,plugin.quick.comment.pre,atl.general,main,pagebanner,atl.confluence.plugins.pagetree-desktop,atl.comments/batch.css?devtoolbar=true&highlightactions=true&flavour=VANILLA&isAdmin=true&locale=en-GB&user-logged-in=true")
			.headers(headers_2),
            http("request_23")
			.get(uri1 + "/s/db0b7591cfadbadc1dd90174b2a158c5-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/js/batch.js?source=webContextStatic&atlassian.aui.raphael.disabled=true&locale=en-GB&build-number=5982")
			.headers(headers_1),
            http("request_24")
			.get(uri1 + "/s/87bb1ec7afdb1ce3349e9efaade58ba8-CDN/en_GB/5982/NOCACHE1/84e42deaaeed87a3db69bb72f0824edc/_/download/contextbatch/js/page,viewcontent,plugin.quick.comment.pre,atl.general,main,pagebanner,atl.confluence.plugins.pagetree-desktop,atl.comments/batch.js?devtoolbar=true&highlightactions=true&isSystemAdministrator=true&flavour=VANILLA&analytics-enabled=true&isAdmin=true&locale=en-GB&user-logged-in=true&is-server-instance=true&hostenabled=true")
			.headers(headers_1),
            http("request_25")
			.get(uri1 + "/s/43d467b830bb2d49d16b8efa994dc1dc-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/css/batch.css?build-number=5982")
			.headers(headers_2),
            http("request_26")
			.get(uri1 + "/download/attachments/98310/welcome.png?version=1&modificationDate=1433245783423&api=v2")
			.headers(headers_26),
            http("request_27")
			.get(uri1 + "/rest/helptips/1.0/tips")
			.headers(headers_9),
            http("request_28")
			.get(uri1 + "/rest/highlighting/1.0/panel-items?pageId=98310&_=1461157732634")
			.headers(headers_28),
            http("request_29")
			.get(uri1 + "/rest/shortcuts/latest/shortcuts/5982/8691841740820c37a8b7174830a427d4")
			.headers(headers_7),
            http("request_30")
			.get(uri1 + "/rest/likes/1.0/content/98310/likes?commentLikes=true&_=1461157732636")
			.headers(headers_7),
            http("request_31")
			.get(uri1 + "/rest/mywork/latest/status/notification/count?pageid=98310&_=1461157732678")
			.headers(headers_7),
            http("request_32")
			.get(uri1 + "/plugins/servlet/dev-toolbar?_=1461157732674")
			.headers(headers_8),
            http("request_33")
			.get(uri1 + "/rest/inlinecomments/1.0/comments?containerId=98310&_=1461157732710")
			.headers(headers_7),
            http("request_34")
			.get(uri1 + "/plugins/pagetree/naturalchildren.action?decorator=none&excerpt=false&sort=position&reverse=false&disableLinks=false&expandCurrent=true&hasRoot=true&pageId=98310&treeId=0&startDepth=0&mobile=false&ancestors=98310&treePageId=98310&_=1461157732689")
			.headers(headers_34),
            http("request_35")
			.get(uri1 + "/plugins/editor-loader/editor.action?parentPageId=&pageId=98310&spaceKey=ds&atl_after_login_redirect=%2Fconfluence%2Fdisplay%2Fds%2FWelcome%2Bto%2BConfluence&timeout=12000&_=1461157732865")
			.headers(headers_28),
            http("request_36")
			.post(uri1 + "/rest/webResources/1.0/resources")
			.headers(headers_9)
			.body(RawFileBody("RecordedSimulation_0036_request.txt")),
            http("request_37")
			.post(uri1 + "/rest/analytics/1.0/publish/bulk")
			.headers(headers_9)
			.body(RawFileBody("RecordedSimulation_0037_request.txt")),
            http("request_38")
			.get(uri1 + "/s/305ab38d098e1f4aa76f13d17d17e01c-CDN/en_GB/5982/NOCACHE1/efc3cdb23fc3aff28b87897a738139b6/_/download/contextbatch/js/editor,macro-browser,fullpage-editor,-viewcontent,-atl.general,-plugin.quick.comment.pre,-page,-main,-atl.comments/batch.js?locale=en-GB")
			.headers(headers_1),
            http("request_39")
			.get(uri1 + "/plugins/macrobrowser/browse-macros.action?detailed=false&macroMetadataClientCacheKey=1461155800856")
			.headers(headers_7),
            http("request_40")
			.get(uri1 + "/s/d41d8cd98f00b204e9800998ecf8427e-CDN/en_GB/5982/NOCACHE1/efc3cdb23fc3aff28b87897a738139b6/_/download/contextbatch/css/editor,macro-browser,fullpage-editor,-viewcontent,-atl.general,-plugin.quick.comment.pre,-page,-main,-atl.comments/batch.css?media=%28max-width%3A+1450px%29")
			.headers(headers_2)))
		.pause(7)
		.exec(http("request_41")
			.get("/confluence/logout.action")
			.headers(headers_0)
			.resources(http("request_42")
			.get(uri1 + "/s/6c0981174e94142364564819dc0d1413-CDN/en_GB/5982/NOCACHE1/1.0/_/download/resources/confluence.web.resources:login/login.js?locale=en-GB")
			.headers(headers_1),
            http("request_43")
			.get(uri1 + "/s/68c89f96e4b7a97686e54444b4414780-CDN/en_GB/5982/NOCACHE1/c7b8eac9b0eb1776b3181ce6daccf519/_/download/contextbatch/css/main,atl.general/batch.css?flavour=VANILLA&devtoolbar=true")
			.headers(headers_2),
            http("request_44")
			.get(uri1 + "/s/3aa86da69e04e0994a1c8ccbe7db012a-CDN/en_GB/5982/NOCACHE1/c7b8eac9b0eb1776b3181ce6daccf519/_/download/contextbatch/js/main,atl.general/batch.js?devtoolbar=true&flavour=VANILLA&analytics-enabled=true&locale=en-GB&is-server-instance=true&hostenabled=true")
			.headers(headers_1),
            http("request_45")
			.get(uri1 + "/s/db0b7591cfadbadc1dd90174b2a158c5-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/js/batch.js?source=webContextStatic&atlassian.aui.raphael.disabled=true&locale=en-GB&build-number=5982")
			.headers(headers_1),
            http("request_46")
			.get(uri1 + "/s/43d467b830bb2d49d16b8efa994dc1dc-CDN/en_GB/5982/NOCACHE1/3/_/download/superbatch/css/batch.css?build-number=5982")
			.headers(headers_2),
            http("request_47")
			.get(uri1 + "/rest/shortcuts/latest/shortcuts/5982/8691841740820c37a8b7174830a427d4")
			.headers(headers_7),
            http("request_48")
			.get(uri1 + "/plugins/servlet/dev-toolbar")
			.headers(headers_8),
            http("request_49")
			.post(uri1 + "/rest/analytics/1.0/publish/bulk")
			.headers(headers_9)
			.body(RawFileBody("RecordedSimulation_0049_request.txt"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
