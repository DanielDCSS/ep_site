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
                property("background-color", "#333")
                property("color", "white")
                property("padding", "1rem")
                property("text-align", "left")
                property("border-bottom", "1px solid #dee2e6")
                property("width", "98.9vw")
                property("display", "flex")
                property("justify-content", "space-between")
                property("align-items", "center")
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
                    property("align-items", "center")
                    property("gap", "1.5rem")
                }
            }){
                Image( "/bras2.png","Usp Logo", Modifier.height(4.cssRem).display(DisplayStyle.Block))
                Row(Modifier.gap(1.5.cssRem).displayIfAtLeast(Breakpoint.MD), verticalAlignment = Alignment.CenterVertically) {
                    EpsItems()
                }
            }
        }
    }
}


