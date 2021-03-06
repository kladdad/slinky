package me.shadaj.slinky.docs.homepage //nodisplay

import me.shadaj.slinky.core.{Component, StatelessComponent} //nodisplay
import me.shadaj.slinky.core.annotations.react //nodisplay
import me.shadaj.slinky.web.html._ //nodisplay
import org.scalajs.dom.raw.{Event, HTMLInputElement} //nodisplay

import scala.scalajs.js.Date //nodisplay

case class TodoItem(text: String, id: Long)

@react class TodoApp extends Component {
  type Props = Unit
  case class State(items: Seq[TodoItem], text: String)

  override def initialState = State(Seq.empty, "")

  def handleChange(e: Event): Unit = {
    val eventValue =
      e.target.asInstanceOf[HTMLInputElement].value
    setState(_.copy(text = eventValue))
  }

  def handleSubmit(e: Event): Unit = {
    e.preventDefault()

    if (state.text.nonEmpty) {
      val newItem = TodoItem(
        text = state.text,
        id = Date.now().toLong
      )

      setState(prevState => {
        State(
          items = prevState.items :+ newItem,
          text = ""
        )
      })
    }
  }

  override def render() = {
    div(
      h3("TODO"),
      TodoList(items = state.items),
      form(onSubmit := handleSubmit _)(
        input(
          onChange := handleChange _,
          value := state.text
        ),
        button(s"Add #${state.items.size + 1}")
      )
    )
  }
}

@react class TodoList extends StatelessComponent {
  case class Props(items: Seq[TodoItem])

  override def render() = {
    ul(
      props.items.map { item =>
        li(key := item.id.toString)(item.text)
      }
    )
  }
}

//display:ReactDOM.render(TodoApp(), mountNode)
//run:TodoApp() //nodisplay