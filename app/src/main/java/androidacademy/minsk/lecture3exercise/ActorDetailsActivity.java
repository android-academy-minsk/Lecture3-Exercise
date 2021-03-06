package androidacademy.minsk.lecture3exercise;

import androidacademy.minsk.lecture3exercise.data.Actor;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ActorDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_FULL_NAME = "full_name";
    private static final String EXTRA_PHOTO = "photo";
    private static final String EXTRA_WIKI_ARTICLE = "wiki_article";

    public static void start(@NonNull Context context, @NonNull Actor actor) {
        Intent intent = new Intent(context, ActorDetailsActivity.class);
        intent.putExtra(EXTRA_FULL_NAME, actor.getName());
        intent.putExtra(EXTRA_PHOTO, actor.getAvatar());
        intent.putExtra(EXTRA_WIKI_ARTICLE, actor.getWikiArticle());

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra(EXTRA_FULL_NAME);
        String wikiArticle = intent.getStringExtra(EXTRA_WIKI_ARTICLE);
        Uri avatar = intent.getParcelableExtra(EXTRA_PHOTO);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle(fullName);
        }

        ImageView photoView = findViewById(R.id.photoView);
        TextView wikiInfoView = findViewById(R.id.wikiInfoView);

        Glide.with(this).load(avatar).apply(new RequestOptions()
                .placeholder(R.drawable.avatar_default_details)
                .fallback(R.drawable.avatar_default_details)
                .centerCrop()).into(photoView);
        wikiInfoView.setText(wikiArticle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
