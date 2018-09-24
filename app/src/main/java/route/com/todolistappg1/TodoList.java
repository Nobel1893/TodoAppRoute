package route.com.todolistappg1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import route.com.todolistappg1.ToDoDataBas.Model.Todo;
import route.com.todolistappg1.ToDoDataBas.MyDataBase;

public class TodoList extends AppCompatActivity {

    RecyclerView recyclerView;
    TodoListAdapter adapter;
    LinearLayoutManager layoutManager;
    List<Todo> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new TodoListAdapter(items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TodoListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, Todo todo) {
                AddTodo.todoItem= todo;
                startActivity(new Intent(TodoList.this,AddTodo.class));
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TodoList.this,AddTodo.class));
    }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        items = MyDataBase.getInstance(getApplicationContext())
                .todoDao().SelectAllTodo();
        adapter.setTodoList(items);
    }
}
