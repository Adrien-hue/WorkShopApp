package com.example.filmamora.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmamora.Objet.Realisateur;
import com.example.filmamora.R;

import java.util.List;

public class RealAdapter extends BaseAdapter {

    //Fields

    private Context context;
    private List<Realisateur> listRealisateur;
    private LayoutInflater inflater;

    //Constructeur
    public RealAdapter(Context context, List<Realisateur> listRealisateur) {
        this.context = context;
        this.listRealisateur = listRealisateur;
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

        Realisateur currentItem = (Realisateur) getItem(i);
        String itemName = currentItem.getName();

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);


        return view;
    }
}
