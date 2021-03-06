package me.shadaj.slinky.docs

import me.shadaj.slinky.core.facade.ReactElement
import me.shadaj.slinky.web.html.{className, div, style}

import scala.scalajs.js.Dynamic.literal

object MainPageContent {
  def apply(children: ReactElement*): ReactElement = {
    div(className := "article", style := literal(
      maxWidth = "1400px",
      marginLeft = "auto",
      marginRight = "auto",
      marginBottom = "15px",
      padding = "5px"
    ))(
      children: _*
    )
  }
}
