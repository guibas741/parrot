package src.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.parrot.parrot.R;

public class ItemFavoritoActivity extends RecyclerView.ViewHolder {

    public TextView frase;

    public ItemFavoritoActivity(View itemView) {
        super(itemView);
        frase = (TextView) itemView.findViewById(R.id.itemFraseId);
    }
}
