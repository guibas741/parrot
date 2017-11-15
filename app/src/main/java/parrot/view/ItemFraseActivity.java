package parrot.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parrot.parrot.parrot.R;

public class ItemFraseActivity extends RecyclerView.ViewHolder {

    public TextView frase;
    public ImageView btnDelete;
    
    public ItemFraseActivity(View itemView) {
        super(itemView);
        btnDelete = (ImageView) itemView.findViewById(R.id.btnDeleteId);
        frase = (TextView) itemView.findViewById(R.id.itemFraseId);
    }
}
