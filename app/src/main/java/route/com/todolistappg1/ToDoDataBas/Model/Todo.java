package route.com.todolistappg1.ToDoDataBas.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String content;
    String DateTime;


    public Todo(){

    }
    @Ignore
    public Todo( String title, String content, String dateTime) {
        this.title = title;
        this.content = content;
        DateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
