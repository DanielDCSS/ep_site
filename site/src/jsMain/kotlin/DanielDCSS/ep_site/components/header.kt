package DanielDCSS.ep_site.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
private fun NavLink(path: String, text: String) {
    Link(path, text, variant = UndecoratedLinkVariant.then(UncoloredLinkVariant))
}
@Composable
private fun EpsItems() {
    NavLink("/", "Ep01")
    NavLink("/about", "Ep02")
}

@Composable
fun SimpleHeader() {
    Header {
        Div(attrs = {
            style {
                property("position", "fixed")    // Fixa o header no topo
                property("top", "0")             // Posiciona no topo
                property("left", "0")            // Alinha à esquerda
                property("width", "100%")        // Ocupa toda a largura da viewport
                property("background-color", dark)
                property("color", orange_lighter)
                property("padding", "1rem")
                property("text-align", "left")
                property("border-bottom", "1px solid #e8c39e")
                property("display", "flex")
                property("justify-content", "space-between")
                property("align-items", "center")
                property("z-index", "1000")      // Garante que o header fique sobre outros elementos
            }
        }) {
            Div {
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
            Div(attrs = {
                style {
                    property("color", "white")
                    property("display", "flex")
                    property("align-items", "left")
                }
            }){
                Image("/bras2.png", "Usp Logo", Modifier.height(5.cssRem).display(DisplayStyle.Block))
            }
        }
    }
}



