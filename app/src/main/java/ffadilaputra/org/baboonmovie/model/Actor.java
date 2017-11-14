package ffadilaputra.org.baboonmovie.model;

import com.orm.SugarRecord;

/**
 * Created by wirasyafri on 15/11/2017.
 */

public class Actor extends SugarRecord<Actor> {

    private String actorName;
    private Movies movies;

    public Actor(){

    }

    public Actor(String actorName, Movies movies) {
        this.actorName = actorName;
        this.movies = movies;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}