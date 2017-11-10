package ffadilaputra.org.baboonmovie.model;

import com.orm.SugarRecord;

/**
 * Created by aura on 10/11/17.
 */

public class Director extends SugarRecord<Director>{

    public String name;
    public String experience;

    public Director(){

    }

    public Director(String name, String experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
