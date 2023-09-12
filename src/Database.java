import java.util.Arrays;

public class Database {

    private Superhero[] superheroList;
    int count = 0;

    public Database() {
        this.superheroList = new Superhero[5];
    }
    public void addSuperhero(String name, String realName, String superpower, int age, int strength, boolean isHuman) {
        superheroList[count++] = new Superhero(name, realName, superpower, age, strength, isHuman);

    }
    public Superhero getSuperhero(int index) {
        return superheroList[index];
    }
    public Superhero setSuperhero(int index) {
        return superheroList[index];
    }

    @Override
    public String toString() {
        return "Database{" +
                "superheroList=" + Arrays.toString(superheroList) +
                '}';
    }
}
