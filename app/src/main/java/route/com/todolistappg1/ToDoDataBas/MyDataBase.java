package route.com.todolistappg1.ToDoDataBas;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import route.com.todolistappg1.ToDoDataBas.Daos.TodoDao;
import route.com.todolistappg1.ToDoDataBas.Model.Todo;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
@Database(entities = {Todo.class},version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase{

    private static MyDataBase todoDatabase;

    public  abstract TodoDao todoDao();

    public static MyDataBase getInstance(Context context){
        if(todoDatabase==null)//initialize
           todoDatabase=
                   Room.databaseBuilder(context,
                   MyDataBase.class, "todo-database")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();

        return todoDatabase;
    }

}
