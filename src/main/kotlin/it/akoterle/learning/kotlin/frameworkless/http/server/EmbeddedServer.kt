package it.akoterle.learning.kotlin.frameworkless.http.server

interface EmbeddedServer {
    fun start(port: Int)
}