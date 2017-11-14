package ffadilaputra.org.baboonmovie.model;

import com.orm.SugarRecord;

/**
 * Created by aura on 10/11/17.
 */

public class Director extends SugarRecord<Director>{

    public String directorName;
    public Movies movies;

    public Director(){

    }

    public Director(String directorName, Movies movies) {
        this.directorName = directorName;
        this.movies = movies;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}
