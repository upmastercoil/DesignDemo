package tech.android.tcmp13.designdemo.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tech.android.tcmp13.designdemo.R;

/**
 * Created by tcmp13-t on 1/8/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private List<String> data;
    private Context context;

    public RecyclerAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_simple, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {

        holder.textView.setText(data.get(position));
        //Create the bitmap from the drawable res folder
        Bitmap original = BitmapFactory.decodeResource(context.getResources(), R.drawable.shuki);
        //Create a rounded drawable
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), original);
        //Make it round
        roundedBitmapDrawable.setCircular(true);
        holder.avatar.setImageDrawable(roundedBitmapDrawable);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public void deleteData(RecyclerView.ViewHolder holder) {

        int position = holder.getAdapterPosition();
        data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, data.size());
    }
}
