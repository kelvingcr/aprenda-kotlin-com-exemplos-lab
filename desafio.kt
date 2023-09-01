enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(
    val nome: String,
    val descricao: String,
    val conteudos: List<ConteudoEducacional>,
    val aluno: Usuario,
    val nivel: List<Nivel>,
    val inscritos: MutableList<Usuario> = mutableListOf(),
) {
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("Alice", "alice@email.com")
    val usuario2 = Usuario("Bruno", "bruno@email.com")
    val usuario3 = Usuario("Clara", "clara@email.com")

    val conteudo1 = ConteudoEducacional("Programação em Python", 50, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados em Kotlin", 90, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento de Aplicativos iOS com Swift", 150, Nivel.DIFICIL)

    val formacao1 = Formacao(
        "Formação em Desenvolvimento Web",
        "Aprenda a criar aplicativos web modernos",
        listOf(conteudo1, conteudo2),
        usuario1,
        listOf(Nivel.BASICO, Nivel.INTERMEDIARIO)
    )

    val formacao2 = Formacao(
        "Formação em Desenvolvimento Mobile",
        "Aprenda a criar aplicativos móveis para iOS e Android",
        listOf(conteudo2, conteudo3),
        usuario2,
        listOf(Nivel.INTERMEDIARIO, Nivel.DIFICIL)
    )

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)
    formacao2.matricular(usuario1)

    println("Alunos matriculados na Formação em Desenvolvimento Web:")
    formacao1.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Email: ${aluno.email}")
    }

    println("\nAlunos matriculados na Formação em Desenvolvimento Mobile:")
    formacao2.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Email: ${aluno.email}")
    }
}
