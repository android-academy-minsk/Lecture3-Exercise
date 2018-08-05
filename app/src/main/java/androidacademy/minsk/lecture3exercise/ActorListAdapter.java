package androidacademy.minsk.lecture3exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidacademy.minsk.lecture3exercise.data.Actor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ViewHolder> {
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final RequestOptions imageOptions;
    @NonNull
    private final List<Actor> actors;
    @Nullable
    private final ItemClickListener itemClickListener;

    public ActorListAdapter(@NonNull Context context, @NonNull List<Actor> actors,
            @Nullable ItemClickListener itemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.actors = actors;
        this.itemClickListener = itemClickListener;
        this.imageOptions = new RequestOptions()
                .placeholder(R.drawable.avatar_default_list)
                .fallback(R.drawable.avatar_default_list)
                .centerCrop();
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false), itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);
        Glide.with(holder.photoView)
                .load(actor.getAvatarPreview())
                .apply(imageOptions)
                .into(holder.photoView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView photoView;
        public ViewHolder(@NonNull View itemView,
                @Nullable final ItemClickListener itemClickListener) {
            super(itemView);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (itemClickListener != null && position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(position, v);
                }
            });
            photoView = itemView.findViewById(R.id.photoView);
        }
    }
}
