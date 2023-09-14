import java.util.ArrayList;
import java.util.Objects;

public class Database {

    final ArrayList<Superhero> superheroList;

    public Database() {
        this.superheroList = new ArrayList<>();

    }

    public void addSuperhero(String name, String realName, String superpower, int age, int strength, boolean isHuman) {
        superheroList.add( new Superhero(name, realName, superpower, age, strength, isHuman));
    }

    public Superhero getSuperhero(int index) {
        return superheroList.get(index);
    }
    public Superhero findSuperhero(Objects findSuperhero) {

    }

    }

