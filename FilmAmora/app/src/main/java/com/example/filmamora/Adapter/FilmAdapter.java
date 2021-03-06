package com.example.filmamora.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmamora.Objet.Film;
import com.example.filmamora.R;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<Film> filmList;
    private LayoutInflater inflater;
    private static final String TAG = "filmAdapter";



    //Constructeur
    public FilmAdapter(Context context, List<Film> filmList) {
        this.filmList = new ArrayList<>();
        this.context = context;
        this.filmList.addAll(filmList);
        Log.d(TAG, "Création Adapter");
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
        return filmList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_list, null);



        Film currentItem = (Film) getItem(i);

        String itemName = currentItem.getTitre();
        Long itemDate = currentItem.getAnnee();
        String prenom = currentItem.getP_prenom();
        String nom = currentItem.getP_nom();
        int id = currentItem.getId();

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        ImageView itemImageView = view.findViewById(R.id.item_icon);
        String ressourceName = "item_" + id;

        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemImageView.setImageResource(resId);


        TextView itemPrenom = view.findViewById(R.id.item_prenom);
        itemPrenom.setText(prenom);


        TextView itemNom = view.findViewById(R.id.item_nom);
        itemNom.setText(nom);

        TextView itemDateView = view.findViewById(R.id.item_date);
        itemDateView.setText("Sorti en " + itemDate);

        return view;
    }

    public void update(List<Film> filmList){
        this.filmList.clear();
        this.filmList.addAll(filmList);
        this.notifyDataSetChanged();
    }
}
