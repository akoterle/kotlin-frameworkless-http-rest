package it.akoterle.learning.kotlin.frameworkless.http.server

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HelloController : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.status = 200
    }


}