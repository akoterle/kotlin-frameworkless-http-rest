package it.akoterle.learning.kotlin.frameworkless.http.server

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.ServerConnector
import org.eclipse.jetty.server.handler.DefaultHandler
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import javax.servlet.http.HttpServlet

class EmbeddedJetty(private val servletHandlersMap: Map<String, Class<out HttpServlet>>) : EmbeddedServer {

    @Throws(Exception::class)
    override fun start(port: Int) {
        with(Server()) {
            try {
                configure(this, port)
                start()
                //dumpStdErr()
                join()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }

    }

    @Throws(Exception::class)
    private fun configure(server: Server, tcpPort: Int) {
        val connector = ServerConnector(server).apply { port = tcpPort }
        server.connectors = arrayOf(connector)

        val context = ServletContextHandler(ServletContextHandler.SESSIONS)
        context.contextPath = "/"
        servletHandlersMap.entries.forEach {
            context.addServlet(ServletHolder(it.value), it.key)
        }
        val handlerList = HandlerList()
        handlerList.handlers = arrayOf(context, DefaultHandler())
        server.handler = handlerList
    }


}