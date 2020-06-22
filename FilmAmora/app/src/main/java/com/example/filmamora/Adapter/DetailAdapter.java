package com.example.filmamora.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmamora.Objet.DetailFilm;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.R;

import java.util.List;

public class DetailAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<DetailFilm> detailList;
    private LayoutInflater inflater;

    //Constructeur
    public DetailAdapter(Context context, List<DetailFilm> detailList) {
        this.context = context;
        this.detailList = detailList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return detailList.size();
    }

    @Override
    public Object getItem(int position) {
        return detailList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return detailList.get(i).getIdFilm();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_list, null);



        DetailFilm currentItem = (DetailFilm) getItem(i);

        String itemTitre = currentItem.getTitre();

        Long itemDate = currentItem.getAnnee();

        String prenom = currentItem.getReal_p();

        String nom = currentItem.getReal_nom();

        String synopsis = currentItem.getSynopsis();

        int id = currentItem.getIdFilm();

        TextView itemTitreF = view.findViewById(R.id.item_Titre);
        itemTitreF.setText(itemTitre);

        ImageView itemImageView = view.findViewById(R.id.item_imageId);
        String ressourceName = "item_" + id;

        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemImageView.setImageResource(resId);


        TextView itemPrenom = view.findViewById(R.id.item_RealisateurPrenom);
        itemPrenom.setText(prenom);


        TextView itemNom = view.findViewById(R.id.item_RealisateurNom);
        itemNom.setText(nom);

        TextView itemDateView = view.findViewById(R.id.item_Date);
        itemDateView.setText("Sorti en " + itemDate);

        TextView itemSynopsis = view.findViewById(R.id.item_synopsis);
        itemDateView.setText(synopsis);

        return view;
    }

    public void update(List<DetailFilm> detailList){
        this.detailList = detailList;
        this.notifyDataSetChanged();
    }
}
