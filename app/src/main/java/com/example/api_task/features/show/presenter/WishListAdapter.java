package com.example.api_task.features.show.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api_task.R;
import com.example.api_task.features.show.model.ShowResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WishListAdapter extends ArrayAdapter<ShowResponse.Item> {
    private String url;

    public WishListAdapter(Context context, ArrayList<ShowResponse.Item> items) {

        super(context, 0, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the current item record to be displayed
        ShowResponse.Item currentItem = getItem(position);

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item , parent , false);
        }

        // attach each field to its view


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);

        nameTextView.setText(currentItem.getName());



        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price);

        priceTextView.setText(""+currentItem.getPrice()+" EGP");



        ImageView lensImage = (ImageView) listItemView.findViewById(R.id.imagee);
        url = "http://lensaty.net/"+currentItem.getImagePath();
        Picasso.get().load(url).into(lensImage);

        return listItemView;
    }
}
