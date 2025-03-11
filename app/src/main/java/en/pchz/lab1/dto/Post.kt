package en.pchz.lab1.dto

data class Post(
    val imageUrl: String,
    val text: String,
    val likesCount: Int,
    val commentsCount: Int
)