package parrot.adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parrot.parrot.parrot.R;

import java.util.List;

import parrot.dao.DaoFrase;
import parrot.model.Frase;
import parrot.util.Util;
import parrot.view.ItemFraseActivity;



public class FraseAdapter extends RecyclerView.Adapter<ItemFraseActivity>{

    private final List<Frase> frases;

    private Util util;
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
                util = new Util();
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
                                    util.makeToast("Excluiu", view.getContext(), Toast.LENGTH_LONG);
                                } else {
                                    util.makeToast("Não excluiu", view.getContext(), Toast.LENGTH_LONG);
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
        notifyItemRangeChanged(position, getItemCount());
    }
}
