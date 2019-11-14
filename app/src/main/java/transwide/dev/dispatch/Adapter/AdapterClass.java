package transwide.dev.dispatch.Adapter;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import transwide.dev.dispatch.Deal;
import transwide.dev.dispatch.DetailsActivity;
import transwide.dev.dispatch.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Deal> list;
    ArrayList<String> keys;
   private Context context;
    public AdapterClass (ArrayList<Deal> list,ArrayList<String> keys,Context context)
    {
        this.list = list;
        this.keys = keys;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.number.setText(keys.get(i));
        myViewHolder.customer.setText(list.get(i).getCustomer());
        myViewHolder._details.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myactivity = new Intent(context.getApplicationContext(), DetailsActivity.class);
                myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(myactivity);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView number, customer;
        LinearLayout _details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            customer = itemView.findViewById(R.id.customer);
            _details = itemView.findViewById(R.id._details);
        }
    }
}
