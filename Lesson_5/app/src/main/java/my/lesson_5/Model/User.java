package my.lesson_5.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "table_users")
public class User {


    @PrimaryKey(autoGenerate = true)
    private int id;

    public String name;

    private String surname;

    private int age;

    public User() {
    }

    @Ignore
    public User(int id) {
        this.id = id;
    }

    @Ignore
    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    @Ignore
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Ignore
    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        if (id != 0) {
            return String.format("User: %s %s %s, age: %s",id, name, surname, age);
        }
        return String.format("User: %s %s, age: %s", name, surname, age);
    }
}
