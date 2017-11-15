package parrot.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.parrot.parrot.parrot.R;

import java.util.List;

import parrot.model.Frase;
import parrot.util.Util;
import parrot.view.ItemFavoritoActivity;


public class FavoritoAdapter extends RecyclerView.Adapter<ItemFavoritoActivity>{

    private final List<Frase> frases;

    private Util util;
    public FavoritoAdapter(List<Frase> frases) {
        this.frases = frases;
    }


    @Override
    public ItemFavoritoActivity onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemFavoritoActivity(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_favorito, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemFavoritoActivity holder, int position) {
        holder.frase.setText(frases.get(position).getFraseOriginal());
    }

    @Override
    public int getItemCount() {
        return frases != null ? frases.size() : 0;
    }

}
