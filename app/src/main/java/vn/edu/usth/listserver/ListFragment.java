package vn.edu.usth.listserver;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.usth.chatbox.ChatboxActivity;
import vn.edu.usth.chatbox.R;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.listserver_fragment_listserver, container, false);


        v.findViewById(R.id.clickable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the IRC activity
                Intent intent = new Intent(getActivity(), ServerActivity.class);

                startActivity(intent);
            }
        });





        return v;
        //LinearLayout linearLayout = new LinearLayout(getContext());
        //linearLayout.setOrientation(LinearLayout.VERTICAL);
        //linearLayout.setBackgroundColor(0x2000FF00);
        /*TextView thursdayTextView = new TextView(getContext());
        thursdayTextView.setText("Thursday");
        thursdayTextView.setTextSize(20);
        thursdayTextView.setPadding(30,30,30,30);
        ImageView thursdayImageView = new ImageView(getContext());
        thursdayImageView.setImageResource(R.drawable.rain);
        thursdayImageView.setPadding(30,30,30,30);
        linearLayout.addView(thursdayTextView);
        linearLayout.addView(thursdayImageView);**/
        //return linearLayout;


    }
}