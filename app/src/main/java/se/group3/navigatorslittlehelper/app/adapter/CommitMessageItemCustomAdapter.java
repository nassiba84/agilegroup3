package se.group3.navigatorslittlehelper.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import se.group3.navigatorslittlehelper.app.R;
import se.group3.navigatorslittlehelper.app.adapterobjects.ObjectCommitMessageItem;

/**
 * Created by Sam on 2014-04-10.
 */
public class CommitMessageItemCustomAdapter extends ArrayAdapter<ObjectCommitMessageItem> {

    Context mContext;
    int layoutResourceId;
    ArrayList<ObjectCommitMessageItem> data = null;

    public CommitMessageItemCustomAdapter(Context mContext, int layoutResourceId, ArrayList<ObjectCommitMessageItem> data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        TextView descriptionlabel = (TextView) listItem.findViewById(R.id.commit_message_description);
        TextView authorlabel = (TextView) listItem.findViewById(R.id.commit_message_author);
        TextView timelabel = (TextView) listItem.findViewById(R.id.commit_message_time);

        String description = data.get(position).description;
        String author = data.get(position).author;
        Date time = data.get(position).time;


        descriptionlabel.setText(description);
        authorlabel.setText("Author: "+author);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        timelabel.setText(sdf.format(time));

        return listItem;
    }


}
