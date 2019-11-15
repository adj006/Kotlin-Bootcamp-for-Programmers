package Lesson5

import java.util.*

fun main(args: Array<String>) {
    /*
    val book = Book("Goosebumps", "R.L. Stine", 1999)

    val titleAuthor = book.getTitleAuthor()
    val titleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${titleAuthor.first} by ${titleAuthor.second}")
    println("Here is your book ${titleAuthorYear.first} by ${titleAuthorYear.second} written in ${titleAuthorYear.third}")

    val allBooks = setOf("G1", "G2", "G3")
    val library = mapOf(book.author to allBooks)

    println(library.any {it.value.contains("G2")})

    var moreBooks = mutableMapOf<String, String>("author2" to "title2")

    moreBooks.getOrPut("Jungle Book") {"Kipline"}
    moreBooks.getOrPut("G2") {book.author}

    println(moreBooks)
    */
    val puppy = Puppy()
    val book = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }

    println("Sad puppy, no more pages in ${book.title}")
}

class Book(val title: String, val author: String, val year: Int, var pages: Int) {

    companion object {
        val BASE_URL = "https://base-url-catilog.com/"
    }

    fun getTitleAuthor(): Pair<String, String>{
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBook: Int): Boolean {
        return (hasBook < MAX_NUMBER_OF_BOOKS)
    }

    fun printURL() {
        //println(Constants.BASE_URL + title + ".html")
        println(BASE_URL + title + ".html")
    }

}

const val MAX_NUMBER_OF_BOOKS = 2

object Constants {
    const val BASE_URL = "https://base-url-catilog.com/"
}

fun Book.weight() = pages * 1.5
fun Book.tornPages(tornPages: Int) = if (tornPages <= pages) pages -= tornPages else pages = 0

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(book.pages + 1))
    }
}




