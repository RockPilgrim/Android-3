package my.lesson_5.Model;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAllUsers();

    @Insert
    long addUser(User user);

    @Insert
    List<Long> addUserList(List<User> userList);

    @Delete
    int deleteUser(User user);


    @Update
    int updateUser(User user);



}
