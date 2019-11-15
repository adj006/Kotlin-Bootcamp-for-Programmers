package Quiz

open class Book (title: String, author: String) {
    private var page = 1

    open fun readPage() {
        page++
    }
}

class eBook(title: String, author: String, var format: String = "text"): Book(title,author) {
    private var wordCount = 0

    override fun readPage() {
        wordCount+= 250
    }
}