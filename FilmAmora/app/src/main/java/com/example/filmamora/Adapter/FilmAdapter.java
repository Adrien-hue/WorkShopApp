package com.example.filmamora.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmamora.Objet.Film;
import com.example.filmamora.R;

import org.w3c.dom.Text;

import java.util.List;

public class FilmAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<Film> filmList;
    private LayoutInflater inflater;

    //Constructeur
    public FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return filmList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =inflater.inflate(R.layout.adapter_list, null);

        Film currentItem = (Film) getItem(i);
        String itemName = currentItem.getName();
        String itemDate = currentItem.getDate();
        String itemInfo = currentItem.getInfo();
        int id = currentItem.getId();

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        ImageView itemImageView = view.findViewById(R.id.item_icon);
        String ressourceName = "item_" + id;
        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemImageView.setImageResource(resId);

        TextView itemInfoView = view.findViewById(R.id.item_info);
        itemInfoView.setText(itemInfo);

        TextView itemDateView = view.findViewById(R.id.item_date);
        itemDateView.setText(itemDate);

        return view;
    }
}
