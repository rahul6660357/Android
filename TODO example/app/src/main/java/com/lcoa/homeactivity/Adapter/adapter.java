package com.lcoa.homeactivity.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcoa.homeactivity.AddUser;
import com.lcoa.homeactivity.R;
import com.lcoa.homeactivity.Viewdetails;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.CourseViewHolder> {
List<AddUser> addUsers;
    private Context context;
public adapter(Context context,List<AddUser> addUsers)
{
    this.context=context;
    this.addUsers=addUsers;
}
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item,viewGroup,false);

        CourseViewHolder holder= new CourseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder courseViewHolder, int i) {

AddUser user=addUsers.get(i);
courseViewHolder.edit1.setText(user.getTitle());
courseViewHolder.edit2.setText(user.getDes());

    }

    @Override
    public int getItemCount() {
        return addUsers.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{
TextView edit2;
TextView edit1;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            edit1=itemView.findViewById(R.id.myedit1);
            edit2=itemView.findViewById(R.id.myedit2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddUser add = addUsers.get(getAdapterPosition());
                    Intent i= new Intent(context, Viewdetails.class);
                    i.putExtra("id",add.getId());
                    i.putExtra("title",add.getTitle());
                    i.putExtra("desc",add.getDes());
                    context.startActivity(i);
                }
            });
        }
    }
}
