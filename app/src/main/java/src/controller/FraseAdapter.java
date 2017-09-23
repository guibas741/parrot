package src.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import java.util.List;

import src.dao.Create;
import src.model.Frase;
import src.util.ItemClickSupport;
import src.view.ItemFraseActivity;

import static android.R.drawable.star_big_off;
import static android.R.drawable.star_big_on;

/**
 * Created by Windows on 11/09/2017.
 */

public class FraseAdapter extends RecyclerView.Adapter<ItemFraseActivity>{

    private final List<Frase> frases;
    private int index;

    public FraseAdapter(List<Frase> frases) {
        this.frases = frases;
    }


    @Override
    public ItemFraseActivity onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemFraseActivity(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_frase, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemFraseActivity holder, int position) {
        holder.frase.setText(frases.get(position).getFraseOriginal());
        final int index = position;
        final Frase f = frases.get(position);
        final ItemFraseActivity h = holder;

        if(f.isFavorito()) holder.btnFavorito.setImageResource(star_big_on);
        else holder.btnFavorito.setImageResource(star_big_off);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir esta frase?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Create c = new Create(view.getContext());
                                Frase f = frases.get(index);
                                if(c.deleteFrase(f)) {
                                    removerFrase(f);
                                    Toast.makeText(view.getContext(), "Excluiu", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(view.getContext(), "Não excluiu", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("Cancelar", null).create() .show();

            }
        });
       // clicar(holder, position);
        holder.btnFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create dao = new Create(v.getContext());
                String favoritou = dao.favoritar(f, v);
                if(!"".equals(favoritou)) favoritarFrase(f);
            }
        });

    }

    @Override
    public int getItemCount() {
        return frases != null ? frases.size() : 0;
    }

    public void removerFrase(Frase f){
        int position = frases.indexOf(f);
        frases.remove(position);
        notifyItemRemoved(position);
    }

    public void clicar(ItemFraseActivity holder, int position, RecyclerView recyclerView) {
        final ItemFraseActivity fHolder =  holder;
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                fHolder.frase.setText(frases.get(position).getFraseTraduzida());
            }
        });
    }

    public void favoritarFrase(Frase f){
        frases.set(frases.indexOf(f), f);
        notifyItemChanged(frases.indexOf(f));
    }

}
