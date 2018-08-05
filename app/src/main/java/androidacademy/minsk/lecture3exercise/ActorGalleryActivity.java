package androidacademy.minsk.lecture3exercise;

import androidacademy.minsk.lecture3exercise.data.Actor;
import androidacademy.minsk.lecture3exercise.data.DataUtil;
import androidacademy.minsk.lecture3exercise.widget.MarginDecoration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ActorGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_gallery);

        RecyclerView actorList = findViewById(R.id.actorList);
        List<Actor> actors = DataUtil.generateActors();
        actorList.setAdapter(new ActorListAdapter(
                this, actors,
                ((position, v) -> ActorDetailsActivity.start(this, actors.get(position)))));
        actorList.addItemDecoration(new MarginDecoration(getResources().getDimensionPixelOffset(R.dimen.listSeparatorWidth)));
    }
}
