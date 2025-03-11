package en.pchz.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import en.pchz.lab1.adapters.PostAdapter
import en.pchz.lab1.dto.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val postsRecyclerView = findViewById<RecyclerView>(R.id.posts_recycler_view)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)

        val posts = listOf(
            Post(
                "https://i.redd.it/yootj1vixt2a1.jpg",
                "Canon angel",
                150,
                30
            ),
            Post(
                "https://www.meme-arsenal.com/memes/e2fb01c1448e131d5823ba647c3508fb.jpg",
                "KOOOBE 24",
                200,
                40
            ),
            Post(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3VIqWfdMsBwJXkIIJe3lPJShAQBwqCq7csLRI3AS5Ok9Ub3P2R6pP3yv8IYQ79gJwOYM&usqp=CAU",
                "OMG!!! I CAN'T BELIEVE...",
                100,
                20
            ),

            )

        val postAdapter = PostAdapter(posts)
        postsRecyclerView.adapter = postAdapter
    }
}