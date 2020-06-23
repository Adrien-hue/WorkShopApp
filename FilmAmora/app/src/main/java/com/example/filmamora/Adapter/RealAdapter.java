package com.example.filmamora.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.filmamora.Objet.Personne;
import com.example.filmamora.R;

import java.util.List;

public class RealAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<Personne> listRealisateur;
    private LayoutInflater inflater;

    //Constructeur
    public RealAdapter(Context context, List<Personne> listPersonne) {
        this.context = context;
        this.listRealisateur = listPersonne;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listRealisateur.size();
    }

    @Override
    public Object getItem(int position) {
        return listRealisateur.get(position);
    }

    @Override
    public long getItemId(int i) {
        return listRealisateur.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_listrealisateur, null);

        Personne currentItem = (Personne) getItem(i);

        String itemPrenom = currentItem.getPrenom();

        TextView item_Prenom = view.findViewById(R.id.item_prenom);
        item_Prenom.setText(itemPrenom);

        String itemNom = currentItem.getNom();

        TextView item_Nom = (TextView) view.findViewById(R.id.item_nom);
        item_Nom.setText(itemNom);


        return view;
    }
}
