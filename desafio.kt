// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }
    
    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    val usuario1 = Usuario("Ana")
    val usuario2 = Usuario("Carlos")
    
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Funcional em Kotlin", 120, Nivel.INTERMEDIARIO)
    
    val formacao = Formacao("Desenvolvimento Kotlin", listOf(conteudo1, conteudo2))
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Testando re-matrícula
    
    formacao.listarInscritos()
}
