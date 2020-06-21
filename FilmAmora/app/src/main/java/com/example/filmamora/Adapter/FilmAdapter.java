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
        return filmList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =inflater.inflate(R.layout.adapter_list, null);



        Film currentItem = (Film) getItem(i);
<<<<<<< Updated upstream
        String itemName = currentItem.getTitre();
        Long itemDate = currentItem.getAnnee();
        //TODO String prenom = currentItem.get();
        int id = currentItem.getId();
=======

        String prenom = currentItem.getP_prenom();

        String nom = currentItem.getP_nom();
>>>>>>> Stashed changes

        Long Fdate = currentItem.getAnnee();

        String titre = currentItem.getTitre();

        int id = currentItem.getId();

        ImageView itemImageView = view.findViewById(R.id.item_icon);
        String ressourceName = "item_" + id;

        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemImageView.setImageResource(resId);

<<<<<<< Updated upstream
        //TODO TextView itemInfoView = view.findViewById(R.id.item_info);
        //TODO itemInfoView.setText(itemInfo);
=======


        TextView itemPrenom = view.findViewById(R.id.item_prenom);
        itemPrenom.setText(prenom);

        TextView itemNom = view.findViewById(R.id.item_nom);
        itemNom.setText(nom);
>>>>>>> Stashed changes

        TextView itemTitre = view.findViewById(R.id.item_titre);
        itemTitre.setText(titre);




        TextView itemDate = view.findViewById(R.id.item_date);
        itemDate.setText("Sorti en" + Fdate);


        return view;
    }

    public void update(List<Film> filmList){
        this.filmList = filmList;
        this.notifyDataSetChanged();
    }
}
