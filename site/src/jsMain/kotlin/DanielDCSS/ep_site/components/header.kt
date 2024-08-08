package DanielDCSS.ep_site.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun SimpleHeader() {
    Header {
        Div(attrs = {
            style {
                property("background-color", "#333")
                property("color", "white")
                property("padding", "1rem")
                property("text-align", "left")
                property("border-bottom", "1px solid #dee2e6")
                property("width", "100vw")
            }
        }) {
            H1(attrs = {
                style {
                    property("margin", "0")
                }
            }) {
                Text("Daniel Carlos Souza Santos")
            }
            P {
                Text("Nº USP : 13686330")
            }
        }
    }
}
