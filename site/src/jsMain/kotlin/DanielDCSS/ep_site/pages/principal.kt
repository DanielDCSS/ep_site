package DanielDCSS.ep_site.pages

import DanielDCSS.ep_site.components.SimpleHeader
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Page
@Composable

fun principalPage() {
    SimpleHeader()
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 130.px)
            .styleModifier {
                paddingLeft(16.px)
            },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        StyledH1("EP 1")

        StyledH2("Dependências")

        StyledP("Kotlin.math é uma biblioteca que contém os métodos " +
                "matemáticos exigidos para o ep. Letsplot é uma biblioteca para exportação gráfica")

        code_div("%use lets-plot\n" +
                "import kotlin.math.pow\n" +
                "import kotlin.math.cos\n" +
                "import kotlin.math.sin\n" +
                "import kotlin.math.sign\n" +
                "import org.jetbrains.letsPlot.export.ggsave\n" +
                "import org.jetbrains.letsPlot.geom.geomLine\n" +
                "import org.jetbrains.letsPlot.letsPlot\n" +
                "import org.jetbrains.letsPlot.label.ggtitle\n" +
                "import org.jetbrains.letsPlot.label.xlab\n" +
                "import org.jetbrains.letsPlot.label.ylab\n" +
                "import org.jetbrains.letsPlot.scale.scaleXContinuous")

        StyledH2("Exercício 1")

        StyledH3("Ítem (A)")

        StyledP("Para resolver a equação \$ x^{\\frac{3}{4}} - cos(x^{2}) = 0 \$ vamos dizer que \$ x_1 \$ é um ponto mais a esquerda que \$ x_2 \$ sempre. Seja \$ f(x) = x^{\\frac{3}{4}} - cos(x^{2}) \$. " +
                "O programa abaixo cria uma função que calcula a média de 2 valores e outra que corresponde a função do " +
                "enunciado. Plotando a função do enunciado no seu respectivo domínio.")

        code_div("fun target( x : Double ) : Double {\n" +
                "    return x.pow(3.0/4.0) - cos(x.pow(2.0))\n" +
                "}\n" +
                "fun x_med( a : Double, b : Double) : Double {\n" +
                "    return ( a + b )/ 2.0\n" +
                "}\n" +
                "\n" +
                "val xs = (0..300).map { it / 10.0 }\n" +
                "var ys = xs.map { target(it) }\n" +
                "\n" +
                "val data = mapOf(\n" +
                "    \"x\" to xs,\n" +
                "    \"y\" to ys\n" +
                ")\n" +
                "\n" +
                "val plot = letsPlot(data) + geomLine {\n" +
                "    x = \"x\"\n" +
                "    y = \"y\"\n" +
                "} + ggtitle(\"Plot da função target(x)\") + xlab(\"x\") + ylab(\"target(x)\")\n" +
                "\n" +
                "plot\n")
        graf("/Captura de Tela 2024-08-10 às 11.44.03.png")

        code_div("var x_1 : Double = 0.0\n" +
                "var x_2 : Double = 1.0\n" +
                "val err  = 0.000001\n" +
                "// Essa parte do código inicializa x1 e x2. Após atualiza x1 e xx2 conforme indicado pelo método da bissecção\n" +
                "while (Math.abs(x_1 - x_2) > err){\n" +
                "    if(sign(target(x_1)) ==  sign(target(x_med(x_1, x_2))) ){\n" +
                "        x_1 = x_med(x_1, x_2)\n" +
                "    }else{\n" +
                "        x_2 = x_med(x_1, x_2)\n" +
                "    }\n" +
                "    println(\"x1: \$x_1\")\n" +
                "    println(\"x2: \$x_2\")\n" +
                "    println(\"xMed: \${x_med(x_1, x_2)}\")\n" +
                "}")
        StyledP("Não existem outras raizes pois a função não é devinida para numéros negativos e é crescente na " +
                "medida que x cresce. <br />\n" +
                "Resposta encontrada : 0.7743964195251465")
        StyledH3("Ítem B")
        StyledP("A derivada da função do ítem (a) é : \$f'(x) = \\frac{3}{4}x^{\\frac{-1}{4}} + 2x*sen(x^{2})\$, " +
                "a qual foi calculada analíticamente. Para o método de Newton vamos usar o programa a seguir cujo o " +
                "algoritmo replica exatamente \$x_{n+1} = x_n - \\frac{f(x_n)}{f'(x_n)}\$ parando apenas " +
                "quando \$f(x_{n+1})\$ está convenientemente próxima de 0. Ao final pode-se notar que ambos os métodos " +
                "convergiram para valores próximos.")
        code_div("fun target_line(x :Double) :Double {\n" +
                "    return (3.0/4.0)*x.pow(-1.0/4.0) + 2*x*sin(x.pow(2.0))\n" +
                "}\n" +
                "var x_n : Double = 1.0 // tem que ser diferente de 0\n" +
                "var x_j : Double = 0.0 // x_n+1\n" +
                "\n" +
                "while(Math.abs(target(x_n)) > err){\n" +
                "    if(x_n > err){\n" +
                "        x_j = x_n - target(x_n)/target_line(x_n)\n" +
                "        println(\"xn = \${x_n} e x_n+1 = \${x_j} \\n\")\n" +
                "        x_n = x_j\n" +
                "        \n" +
                "    }\n" +
                "    else{\n" +
                "        break\n" +
                "    }\n" +
                "}")
        StyledP("Resposta encontrada : 0.7743966632733174 ")
        StyledH3("Ítem C")
        StyledP("Como \$V(r) = \\frac{-e^2}{4\\pi \\epsilon_0 r} + V_0e^{\\frac{-r}{r_0}}\$ e " +
                "também \$F(r) = \\frac{-e^2}{4\\pi \\epsilon_0 r^2} + \\frac{V_0}{r_o}e^{\\frac{-r}{r_0} \$ os " +
                "gráficos do potêncial e da força, pedidos no ítem \$I\$ ficam :")
        code_div("fun potencial( x : Double) :Double { \n" +
                "    return ( -14.4/x ) + 1380* exp(-x/0.328)  \n" +
                "}\n" +
                "fun force( x : Double) :Double{\n" +
                "    return ( -14.4/x.pow(2.0) ) + (1380/0.328)* exp(-x/0.328)\n" +
                "}\n" +
                "var ys2 = xs.map {force(it)}\n" +
                "ys = xs.map { potencial(it) }\n" +
                "\n" +
                "val data = mapOf(\n" +
                "    \"x\" to xs,\n" +
                "    \"y\" to ys,\n" +
                "    \"y2\" to ys2\n" +
                "    \n" +
                ")\n" +
                "\n" +
                "val plot = letsPlot(data) + geomLine(color = \"dark_green\", alpha = .7) {\n" +
                "    x = \"x\"\n" +
                "    y = \"y\"\n" +
                "} + geomLine(color = \"red\", alpha = .7){\n" +
                "    x = \"x\"\n" +
                "    y = \"y2\"\n" +
                "}+ggtitle(\"Plot das funções Potencial(x) e Force(x), X em Angstrong e Potencial em eV\") + ggsize(700, 500) "+
                "+xlab(\"x\") + ylab(\"potencial(x)\")+ \n scaleFillBrewer(type = \"seq\") + theme(panelGridMajorX = \"blank\")+ "+
                "scaleXContinuous()\n" +
                "plot\n" +
                "\n" +
                "// Distancias em Angstrong e potenciais em eletron-volts")
        graf("/Captura de Tela 2024-08-10 às 12.08.15.png")
        StyledP("A função Potencial, em verde, foi plotada ao lado da função Força em vermelho. \n" +
                "<p color = 'green'> Potencial </p> <p color = 'red'> Força </p><br />\n" +
                "Abaixo vem uma implementação literal do método das secantes. Ele visa resolver a parte \$II\$ do ítem c.")
        code_div("// Parte 2 do ítem (c). Para achar a região em que F(r) = 0 pelo método das secantes façamos : \n" +
                "var x_a : Double = 1.0 // x_n+1\n" +
                "var x_b : Double = 2.0 // x_n\n" +
                "var x_c : Double = 3.0 // x_n-1\n" +
                "// err é um número arbitrariamente perto de 0, o qual nesse caso servirá para não fazer a segurança do programa.\n" +
                "while (Math.abs(force(x_a)) > err ){\n" +
                "    if(x_a > err && x_b > err && x_c > err ){\n" +
                "        x_a = x_b - (force(x_b)*(x_b - x_c))/(force(x_b) - force(x_c))\n" +
                "        x_c = x_b\n" +
                "        x_b = x_a\n" +
                "        println(\"x_a = \${x_a}, x_b = \${x_b}, x_c = \${x_c}\")\n" +
                "    }else{\n" +
                "        break\n" +
                "    }\n" +
                "} // as unidades aqui usadas foram as mesmas indicadas no programa. (ev e Å)")
        StyledP("Resposta encontrada : 2.4500072105655226 Å")

    } // Implementar navheader lateral. Estudar como rodar os códigos no navegdor e criar novos usuários
}

@Composable
fun code_div( text: String) {
    Div(attrs = {
        style {
            property("background-color", "#333")
            property("color", "white")
            property("padding", "1rem")
            property("text-align", "left")
            property("border-bottom", "1px solid #dee2e6")
            property("width", "90vw")
            property("display", "flex")
            property("justify-content", "space-between")
            property("align-items", "center")
        }
    }) {
        Pre {
            Code {
                Text(text.toString())
            }
        }
    }
}
@Composable
fun graf(caminho: String){
    Div(attrs = {
        style {
            property("color", "white")
            property("display", "flex")
            property("align-items", "center")
            property("gap", "1.5rem")
            property("padding", "2rem")
        }
    }){
        Image( caminho.toString(),"Gráfico", Modifier.height(30.cssRem).display(DisplayStyle.Block))
    }
}
@Composable
fun StyledH1(text: String) {
    H1(attrs = {
        style {
            fontSize(40.px)
            color(Color("#333"))
            marginBottom(16.px)
            width(90.vw)
        }
    }) {
        Text(text.toString())
    }
}

@Composable
fun StyledH2(text: String) {
    H2(attrs = {
        style {
            fontSize(30.px)
            color(Color("#333"))
            marginBottom(12.px)
            width(90.vw)
        }
    }) {
        Text(text.toString())
    }
}

@Composable
fun StyledH3(text: String) {
    H3(attrs = {
        style {
            fontSize(25.px)
            color(Color("#333"))
            marginBottom(8.px)
            width(90.vw)
        }
    }) {
        Text(text.toString())
    }
}

@Composable
fun StyledP(text: String) {
    P(attrs = {
        style {
            fontSize(20.px)
            color(Color("#333"))
            marginBottom(16.px)
            width(90.vw)
        }
    }) {
        Text(text.toString())
    }
}