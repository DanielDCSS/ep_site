package DanielDCSS.ep_site.pages

import DanielDCSS.ep_site.components.SimpleHeader
import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*



@Page
@Composable
fun HomePage() {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val ctx = rememberPageContext()
    val log1 :String = "Monitor1"
    val passwd1:String = "Senha1"

    SimpleHeader()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        H1(
            attrs = Modifier.fontSize(40.px).toAttrs()
        ){
            Text("Eps de Calculo Numérico")
        }
        P(
            attrs = Modifier.fontSize(20.px).toAttrs()
        ){
            Text(value = "Login :")
        }
        Input(
            type = InputType.Text,
            attrs = Modifier.padding(10.px).fontSize(10.px).toAttrs{
                placeholder("Seu Login")
                onInput{
                    name = it.value
                }}
        )
        P(
            attrs = Modifier.fontSize(20.px).toAttrs()
        ){
            Text(value = "Senha :")
        }
        Input(
            type = InputType.Text,
            attrs = Modifier.padding(10.px).fontSize(10.px).toAttrs{
                placeholder("Seu Login")
                onInput{
                    password = it.value
                }}
        )
        P(
            attrs = Modifier.fontSize(10.px).toAttrs()
        ){
            Text(value = "Bem vindo ${name} clique no botão abaixo para entrar")
        }
        Button(
            attrs = {
                onClick {
                    if(name == log1 && password == passwd1){
                        ctx.router.navigateTo("/principal") // Como configurar o router ?
                    }else{
                        errorMessage = "Desculpe, mais o login ${name} ou a senha ${password} estão inválidos"
                    }
                }
            }

        ){
            Text("Login")
        }
        if (errorMessage.isNotEmpty()){
            P{ Text(errorMessage)}
        }
    }
}

