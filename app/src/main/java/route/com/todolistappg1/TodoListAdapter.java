package route.com.todolistappg1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import route.com.todolistappg1.ToDoDataBas.Model.Todo;


/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/21/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

    List<Todo> todoList;
    onItemClickListener onItemClickListener;

    public void setOnItemClickListener(TodoListAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onClick(int position, Todo todo);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Todo todo= todoList.get(position);
        holder.title.setText(todo.getTitle());
        holder.datetime.setText(todo.getDateTime());
        if(onItemClickListener!=null)
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,todo);
                }
            });

    }

    public void setTodoList(List<Todo> list){
        todoList=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(todoList==null)
            return 0;
        return todoList.size();
    }

    public TodoListAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView datetime;
        View parent;

        ViewHolder(View view){
            super(view);
            parent=view;
            title= view.findViewById(R.id.title);
            datetime =view.findViewById(R.id.datetime);
        }

    }
}
