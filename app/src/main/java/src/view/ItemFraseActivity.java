package src.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.parrot.parrot.R;

public class ItemFraseActivity extends RecyclerView.ViewHolder {

    public TextView frase;
    public ImageView btnDelete, btnEdit;

    public ItemFraseActivity(View itemView) {
        super(itemView);
        btnDelete = (ImageView) itemView.findViewById(R.id.btnDeleteId);
        btnEdit = (ImageView) itemView.findViewById(R.id.btnEditId);

        frase = (TextView) itemView.findViewById(R.id.itemFraseId);
    }
}
