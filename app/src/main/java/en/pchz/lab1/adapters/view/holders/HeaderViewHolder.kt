package en.pchz.lab1.adapters.view.holders

import android.content.res.ColorStateList
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.shape.CircleShape
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import en.pchz.lab1.R

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val profileImage: ImageView = itemView.findViewById(R.id.profile_image)
    private val profileName: TextView = itemView.findViewById(R.id.profile_name)
    private val profileUsername: TextView = itemView.findViewById(R.id.profile_username)
    private val postsCount: TextView = itemView.findViewById(R.id.posts_count)
    private val followersCount: TextView = itemView.findViewById(R.id.followers_count)
    private val followingCount: TextView = itemView.findViewById(R.id.following_count)
    private val profileDescription: TextView = itemView.findViewById(R.id.profile_description)
    private val followButton: Button = itemView.findViewById(R.id.follow_button)
    private val messageButton: Button = itemView.findViewById(R.id.message_button)

    private var isFollowing = false
    private var currentFollowers = 1337

    fun bind() {
        Glide.with(itemView.context)
            .load("https://preview.redd.it/i-got-1-day-ban-for-putting-john-pork-thumbnail-in-my-game-v0-n5fbw52qctva1.jpg?width=400&format=pjpg&auto=webp&s=57eaa670e9d5a1f859223378e6d1ff94ae07cffa")
            .transform(CircleCrop())
            .into(profileImage)

        profileName.text = itemView.context.getString(R.string.profile_name)
        profileUsername.text = itemView.context.getString(R.string.profile_username)
        postsCount.text = itemView.context.getString(R.string.posts_count)
        followersCount.text = itemView.context.getString(R.string.followers_count)
        profileDescription.text = itemView.context.getString(R.string.profile_bio)

        followButton.setOnClickListener {
            isFollowing = !isFollowing
            if (isFollowing) {
                currentFollowers++
                followButton.text = itemView.context.getString(R.string.unfollow_button)
                followButton.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(itemView.context, android.R.color.darker_gray)
                )
            } else {
                currentFollowers--
                followButton.text = itemView.context.getString(R.string.follow_button)
                followButton.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        itemView.context,
                        android.R.color.holo_blue_dark
                    )
                )
            }
            followersCount.text = "$currentFollowers"
        }
    }
}