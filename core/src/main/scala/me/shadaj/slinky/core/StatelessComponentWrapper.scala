package me.shadaj.slinky.core

import me.shadaj.slinky.readwrite.{Reader, Writer}

import scala.scalajs.js

abstract class StatelessDefinition[Props](jsProps: js.Object)
                                         (implicit propsReader: Reader[Props],
                                          propsWriter: Writer[Props]) extends DefinitionBase[Props, Unit](jsProps) {
  override def initialState: Unit = ()
}

abstract class StatelessComponentWrapper extends BaseComponentWrapper {
  override type State = Unit

  override type Definition = StatelessDefinition[Props]
}
