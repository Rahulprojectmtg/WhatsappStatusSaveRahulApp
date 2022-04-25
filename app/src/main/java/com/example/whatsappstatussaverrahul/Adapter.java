package com.example.whatsappstatussaverrahul;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Adapter<viewHolder> extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> fileslist;
    private Object view;

    public Adapter(Context context, ArrayList<ModelClass> fileslist) {
        this.context = context;
        this.fileslist = fileslist;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout, null, false);

        return new viewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final ModelClass modelClass=fileslist.get(position);
        if(modelClass.getUri().toString().endsWith(".mp4"))
        {
             holder.play.setVisibility(view.VISIBLE);


        }
        else

            {
            holder.play.setVisibility(view.INVISIBLE);

        }
        Glide.with(context).load(modelClass.getUri()).into(holder.mainstatus);

        holder.mainstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modelClass.getUri().toString().endsWith(".mp4"))
                {
                    final String path=fileslist.get(position).getPath();
                    String destpath= Environment.getExternalStorageDirectory().getAbsolutePath()+Constant.SAVE_FOLDER_NAME
                            Intent intent=new Intent(context,videoo.class);
                            intent.putExtra("DEST_PATH_VIDEO",destpath);
                            intent.putExtra("FILE_video",path);
                            intent.putExtra("FILENAME_VIDEO",modelClass.getFilename());
                            intent.putExtra("Uri_VIDEO",modelClass.getUri().toString());
                            context.startActivities(intent);


                }
                else

                {
            }                    final String path=fileslist.get(position).getPath();
                String destpath= Environment.getExternalStorageDirectory().getAbsolutePath()+Constant.SAVE_FOLDER_NAME
                Intent intent=new Intent(context,Picture.class);
                intent.putExtra("DEST_PATH",destpath);
                intent.putExtra("FILE",path);
                intent.putExtra("FILENAME",modelClass.getFilename());
                intent.putExtra("Uri",modelClass.getUri().toString());
                context.startActivities(intent);

            });




    }

    @Override
    public int getItemCount() {
        return fileslist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView mainstatus,play;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            mainstatus=itemView.findViewById(R.id.thumbnailofstatus);
            play=itemView.findViewById(R.id.play);
        }
    }
}

    public class ViewHolder {
    }







