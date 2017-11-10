package ffadilaputra.org.baboonmovie.model;

import com.orm.SugarRecord;

/**
 * Created by aura on 10/11/17.
 */

public class Movies extends SugarRecord<Movies> {

    public String name;
    public String synopsys;
    public int year;

    public Movies(){

    }

    public Movies(String name, String synopsys, int year) {
        this.name = name;
        this.synopsys = synopsys;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



}
