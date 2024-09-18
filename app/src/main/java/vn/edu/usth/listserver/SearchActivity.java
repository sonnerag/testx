package vn.edu.usth.listserver;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vn.edu.usth.chatbox.R;

public class SearchActivity extends AppCompatActivity {
    ListView listView;
    SearchView searchView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listserver_activitysearch);
        searchView=findViewById(R.id.search);
        listView=findViewById(R.id.list);
        arrayList=new ArrayList<>();
        arrayList.add("Monday");
        arrayList.add("Friday");
        arrayList.add("Wednesday");
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Monday");
        arrayList.add("Monday");
        arrayList.add("Sunday");
        arrayList.add("Saturday");
        arrayList.add("Monday");
        arrayList.add("Monday");
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(arrayList.contains(s)){
                    arrayAdapter.getFilter().filter(s);
                }else{
                    Toast.makeText(SearchActivity.this,"No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                listView.setVisibility(ListView.VISIBLE);
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });**/
    }
}