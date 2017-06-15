package com.example.notepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saish on 14/6/17.
 */

public class FileAdapter extends BaseAdapter {

    private final Context context ;
    private final List<FileItem> files;
    private LayoutInflater inflater;


    public FileAdapter(Context context, List<FileItem> files) {

        this.context = context;
        this.files = files;


        inflater = LayoutInflater.from(context);

}
    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {
        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            view = inflater.inflate(R.layout.file_item, parent, false);
        } else view = convertView;

        ((ImageView) view.findViewById(R.id.imgIC)).setImageResource(files.get(position).ic);
        ((TextView) view.findViewById(R.id.txtNm)).setText(files.get(position).nm);
        ((TextView) view.findViewById(R.id.txtSz)).setText(files.get(position).sz);

        return view;
    }
}
