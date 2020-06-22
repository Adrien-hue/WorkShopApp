package com.example.filmamora.Adapter;

import android.content.Context;
import android.util.Log;
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
        view = inflater.inflate(R.layout.adapter_detail_film, null);


    //GETTER
        DetailFilm currentItem = (DetailFilm) getItem(i);

        String Titre = currentItem.getTitre();

        Log.d("Detail", Titre);

        Long itemDate = currentItem.getAnnee();

        Log.d("Detail", "" + itemDate);

        String prenom = currentItem.getReal_p();

        Log.d("Detail", prenom);

        String nom = currentItem.getReal_nom();

        Log.d("Detail", nom);

        String synopsis = currentItem.getSynopsis();

        Log.d("Detail", synopsis);

        int id = currentItem.getIdFilm();

        Log.d("Detail", "" + id);

        int note = currentItem.getaNote();

        Log.d("Detail", "" + note);

        String commentaire = currentItem.getaCommentaire();



        //Remplacement

        TextView itemTitreF = view.findViewById(R.id.item_TitreFilm);
        itemTitreF.setText(Titre);

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
        itemSynopsis.setText(synopsis);

        TextView Note = view.findViewById(R.id.item_note);

        TextView Commentaire = view.findViewById(R.id.item_critique);

        if(note == 0){
            Note.setText("Pas de note");
        }else {
            Note.setText(note + "/10");
        }

        if(commentaire == null){
            Commentaire.setText("Pas de commentaire");
        }else {
            Commentaire.setText(commentaire);
        }

        return view;
    }

    public void update(List<DetailFilm> detailList){
        this.detailList = detailList;
        this.notifyDataSetChanged();
    }
}
