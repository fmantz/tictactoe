package scaladays

import scaladays.config.ConfigurationService
import scaladays.server.*
import cats.effect.{Async, ExitCode, Resource}
import cats.implicits.*
import org.http4s.server
import org.http4s.server.middleware.CORS
import org.http4s.server.websocket.WebSocketBuilder
import org.typelevel.log4cats.Logger

object Server:

  def serve[F[_]: Async: Logger]: fs2.Stream[F, ExitCode] =
    for
      configService <- fs2.Stream.eval(ConfigurationService.impl)
      stream        <- fs2.Stream.eval(
                         // TODO - Use configService.httpServer to start an http app
                         // Find a way to keep the stream running
                         ???
                       )
    yield stream
