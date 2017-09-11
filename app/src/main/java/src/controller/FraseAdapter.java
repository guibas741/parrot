package src.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.parrot.parrot.R;

import java.util.List;

import src.model.Frase;
import src.view.ItemFraseActivity;

/**
 * Created by Windows on 11/09/2017.
 */

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
    }

    @Override
    public int getItemCount() {
        return frases != null ? frases.size() : 0;
    }
}
