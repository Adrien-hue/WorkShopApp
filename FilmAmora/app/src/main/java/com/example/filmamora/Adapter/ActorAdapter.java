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

public class ActorAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<Personne> listActor;
    private LayoutInflater inflater;

    //Constructeur
    public ActorAdapter(Context context, List<Personne> listPersonne) {
        this.context = context;
        this.listActor = listPersonne;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listActor.size();
    }

    @Override
    public Object getItem(int position) {
        return listActor.get(position);
    }

    @Override
    public long getItemId(int i) {
        return listActor.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_listactor, null);

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
