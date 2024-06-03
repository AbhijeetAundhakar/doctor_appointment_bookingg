package com.example.healthcareclientfirebase;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_article_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageViewArticle = (ImageView) findViewById(R.id.imageViewArticle);
        TextView tvArticleContent = (TextView) findViewById(R.id.tvArticleContent);
        TextView tvHeading = findViewById(R.id.tvArticleHeading);

        // Get the data passed from MainActivity
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        int imageResourceId = getIntent().getIntExtra("imageResourceId", 0); // Default to 0 if not found


        tvHeading.setText(title);
        tvArticleContent.setText(content);
        if (imageResourceId != 0) {
            imageViewArticle.setImageResource(imageResourceId);
        }
    }
}