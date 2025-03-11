package en.pchz.lab1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import en.pchz.lab1.R
import en.pchz.lab1.adapters.view.holders.HeaderViewHolder
import en.pchz.lab1.adapters.view.holders.PostViewHolder
import en.pchz.lab1.dto.Post

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_POST = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.header_profile, parent, false)
                HeaderViewHolder(view)
            }

            else -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_post, parent, false)
                PostViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind()
            is PostViewHolder -> holder.bind(posts[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return posts.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_POST
    }

}