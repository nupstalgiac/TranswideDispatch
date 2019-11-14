package transwide.dev.dispatch;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;

import transwide.dev.dispatch.Adapter.AdapterClass;

public class Home extends AppCompatActivity {

private static final String TAG = "Home";
DatabaseReference reff;
    ArrayList<Deal> list;
    ArrayList<String> keys;
RecyclerView recyclerView;
SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        reff = FirebaseDatabase.getInstance().getReference().child("Orders");
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);
        //single event listener
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()){
                    String parent = childSnapshot.getKey();
                    Log.i(TAG,parent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (reff != null)
        {
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        list =  new ArrayList<>();
                        keys =  new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            keys.add(ds.getKey());
                        list.add(ds.getValue(Deal.class));
                        }
                        AdapterClass adapterClass = new AdapterClass(list,keys,getApplicationContext());
                        recyclerView.setAdapter(adapterClass);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Home.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }


    }
    private void search(String str)
    {
        ArrayList<Deal> myList = new ArrayList<>();
        for (Deal object : list )
        {
            if(object.getCustomer().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }
        }
        AdapterClass adapterClass = new AdapterClass(myList,keys,getApplicationContext());
        recyclerView.setAdapter(adapterClass);
    }
}
