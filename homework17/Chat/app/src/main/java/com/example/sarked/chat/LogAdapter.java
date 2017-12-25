        package com.example.sarked.chat;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

public class LogAdapter extends ArrayAdapter<String> {
    private ArrayList<String> list;

    public LogAdapter(Context ctx, ArrayList<String> massages){
        super(ctx, R.layout.list_item, massages);
        list = massages;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        TextView mas = (TextView) convertView.findViewById(R.id.item);
        mas.setText(list.get(position));
        return convertView;
    }
}