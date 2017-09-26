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

import src.dao.DaoFrase;
import src.model.Frase;
import src.view.ItemFraseActivity;



public class FraseAdapter extends RecyclerView.Adapter<ItemFraseActivity>{

    private final List<Frase> frases;

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
                                DaoFrase daoFrase = new DaoFrase(view.getContext());
                                Frase f = frases.get(index);
                                if(daoFrase.deleteFrase(f)) {
                                    removerFrase(f);
                                    Toast.makeText(view.getContext(), "Excluiu", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(view.getContext(), "Não excluiu", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("Cancelar", null).create() .show();

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
}
