package it.akoterle.learning.kotlin.frameworkless.http.server

import javafx.application.Application
import javafx.stage.Stage
import java.lang.management.ManagementFactory
import javax.servlet.http.HttpServlet


class Main: Application() {

    private var runtimeMxBean = ManagementFactory.getRuntimeMXBean()!!

    private val httpHandlersMap = mapOf<String, Class<out HttpServlet>>(
            "/" to HelloController::class.java
    )


    override fun start(primaryStage: Stage?) {
        val arguments = runtimeMxBean.inputArguments
        arguments .forEach(::println)
        EmbeddedJetty(httpHandlersMap).start(8090)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Main::class.java, *args)
        }

    }

}