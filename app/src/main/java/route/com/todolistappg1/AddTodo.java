package route.com.todolistappg1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import route.com.todolistappg1.ToDoDataBas.Model.Todo;
import route.com.todolistappg1.ToDoDataBas.MyDataBase;

public class AddTodo extends AppCompatActivity implements View.OnClickListener {


    protected EditText title;
    protected EditText content;
    protected EditText datetime;
    protected Button insert;
    public static Todo todoItem;
    protected Button update;
    protected Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_add_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

        if (todoItem != null) {
            insert.setVisibility(View.GONE);
            update.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
            title.setText(todoItem.getTitle());
            content.setText(todoItem.getContent());
            datetime.setText(todoItem.getDateTime());
        }

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.insert) {
            String titleString = title.getText().toString();
            String contentString = content.getText().toString();
            String dateTimeString = datetime.getText().toString();

            Todo todo = new Todo(titleString, contentString, dateTimeString);
            MyDataBase.getInstance(getApplicationContext())
                    .todoDao().AddTodo(todo);
            finish();

        } else if (view.getId() == R.id.update) {
            String titleString = title.getText().toString();
            String contentString = content.getText().toString();
            String dateTimeString = datetime.getText().toString();
            todoItem.setTitle(titleString);
            todoItem.setContent(contentString);
            todoItem.setDateTime(dateTimeString);
            MyDataBase.getInstance(getApplicationContext())
                    .todoDao().UpdateTodo(todoItem);
            todoItem= null;
            finish();

        } else if (view.getId() == R.id.delete) {
            MyDataBase.getInstance(getApplicationContext())
                    .todoDao().removeTodo(todoItem);
            todoItem= null;
            finish();
        }
    }

    private void initView() {
        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        datetime = (EditText) findViewById(R.id.datetime);
        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(AddTodo.this);
        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(AddTodo.this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(AddTodo.this);
    }
}
