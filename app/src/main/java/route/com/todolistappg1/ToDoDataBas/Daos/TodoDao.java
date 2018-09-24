package route.com.todolistappg1.ToDoDataBas.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import route.com.todolistappg1.ToDoDataBas.Model.Todo;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
@Dao
public interface TodoDao {

    @Query("select * from Todo")
    List<Todo> SelectAllTodo();

    @Insert
    public void AddTodo(Todo todo);

    @Delete
    public void removeTodo(Todo todo);

    @Update
    public void UpdateTodo(Todo todo);

}
