data class Item(val name: String)
data class Token(val value : String = "example token")
data class Post(val content : String = "example post")


fun main() {
    val item = Item(name = "Products")

    postItem(item)

}

fun postItem(item: Item) {
    preparePostAsync { token ->
        submitPostAsync(token, item) { post ->
            processPost(post)
        }
    }
}
fun preparePostAsync(callback: (Token) -> Unit)
{
    Thread {
        Thread.sleep(1000)
        val token = Token(value = "example token")
        callback(token)
    }.start()
}

fun submitPostAsync(token: Token, item: Item, callback: (Post) -> Unit)
{
    Thread {
        Thread.sleep(1000)
        val post = Post("Post content: ${item.name}")
        callback(post)
    }.start()

}

fun processPost(post: Post) {
    println("post created ")
    println(post.content)

}