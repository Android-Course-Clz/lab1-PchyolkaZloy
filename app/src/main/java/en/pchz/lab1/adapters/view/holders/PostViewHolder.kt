package en.pchz.lab1.adapters.view.holders

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import en.pchz.lab1.R
import en.pchz.lab1.dto.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val postImage: ImageView = itemView.findViewById(R.id.post_image)
    private val postText: TextView = itemView.findViewById(R.id.post_text)
    private val likesCount: TextView = itemView.findViewById(R.id.likes_count)
    private val likeButton: ImageButton = itemView.findViewById(R.id.like_button)
    private val commentCount: TextView = itemView.findViewById(R.id.comments_count)

    private var isLiked = false
    private var currentLikes = 0
    private var currentComments = 0

    fun bind(post: Post) {
        Glide.with(itemView.context)
            .load(post.imageUrl)
            .into(postImage)

        postText.text = post.text

        currentLikes = post.likesCount
        currentComments = post.commentsCount

        likesCount.text = itemView.context.getString(R.string.likes_count, currentLikes)
        commentCount.text = itemView.context.getString(R.string.comments_count, currentComments)

        likeButton.setOnClickListener {
            isLiked = !isLiked
            if (isLiked) {
                currentLikes++
                likeButton.setImageResource(R.drawable.ic_heart_filled)
            } else {
                currentLikes--
                likeButton.setImageResource(R.drawable.ic_heart_outline)
            }
            likesCount.text = "$currentLikes likes"
        }
    }
}