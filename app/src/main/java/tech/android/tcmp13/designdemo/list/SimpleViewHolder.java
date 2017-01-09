package tech.android.tcmp13.designdemo.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tech.android.tcmp13.designdemo.R;

/**
 * Created by tcmp13-t on 1/8/2017.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    ImageView avatar;

    public SimpleViewHolder(View itemView) {

        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.simpleTextView);
        avatar = (ImageView) itemView.findViewById(R.id.listItemAvatar);
    }
}
