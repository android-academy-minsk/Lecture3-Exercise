package androidacademy.minsk.lecture3exercise.data;

import android.net.Uri;

public class Actor {
    private final String name;
    private final Uri avatarPreview;
    private final Uri avatar;
    private final String wikiArticle;

    public Actor(String name, Uri avatarPreview, Uri avatar, String wikiArticle) {
        this.name = name;
        this.avatarPreview = avatarPreview;
        this.avatar = avatar;
        this.wikiArticle = wikiArticle;
    }

    public String getName() {
        return name;
    }

    public Uri getAvatarPreview() {
        return avatarPreview;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public String getWikiArticle() {
        return wikiArticle;
    }
}
