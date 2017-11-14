package ffadilaputra.org.baboonmovie.model;

import com.orm.SugarRecord;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class Genre extends SugarRecord<Genre>{

    private String genreName;
    private Movies movies;

    public Genre(){

    }

    public Genre(String genreName, Movies movies) {

        this.genreName = genreName;
        this.movies = movies;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }


}
