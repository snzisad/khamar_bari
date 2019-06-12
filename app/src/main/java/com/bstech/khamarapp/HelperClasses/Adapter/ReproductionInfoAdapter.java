package com.bstech.khamarapp.HelperClasses.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bstech.khamarapp.R;
import com.bstech.khamarapp.ReproductionInfo.Form;
import com.bstech.khamarapp.ReproductionInfo.View;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hp on 1/23/2019.
 **/

public class ReproductionInfoAdapter extends RecyclerSwipeAdapter<ReproductionInfoAdapter.ViewHolderClass> {
    private Context context;
    private ArrayList<HashMap<String, String>> items;
    private Pair[] pairs;
    private ActivityOptions options;

    public ReproductionInfoAdapter(Context context, ArrayList<HashMap<String, String>> items){
        this.context = context;
        this.items = items;

        pairs = new Pair[1];
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        android.view.View v = LayoutInflater.from(context).inflate(R.layout.layout_reproduction_info_list, viewGroup,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(v);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderClass viewHolderClass, final int i) {

        final HashMap<String, String> item = items.get(i);

        viewHolderClass.tv_id.setText("#"+item.get("id"));
        viewHolderClass.tv_last_delivery_date.setText(context.getString(R.string.last_delivery_date_bn)+" "+item.get("last_delivery_date"));
        viewHolderClass.tv_next_delivery_date.setText(context.getString(R.string.next_delivery_date_bn)+" "+item.get("next_delivery_date"));
        viewHolderClass.tv_heat_date.setText(context.getString(R.string.heat_date_bn)+" "+item.get("heat_date"));
        viewHolderClass.swipe_reproduction_info_list.setShowMode(SwipeLayout.ShowMode.PullOut);

//        left to right swipe menu
        viewHolderClass.swipe_reproduction_info_list.addDrag(SwipeLayout.DragEdge.Left, viewHolderClass.swipe_reproduction_info_list.findViewById(R.id.cv_right_menu));

//        right to left swipe menu
        viewHolderClass.swipe_reproduction_info_list.addDrag(SwipeLayout.DragEdge.Right, viewHolderClass.swipe_reproduction_info_list.findViewById(R.id.cv_left_menu));


        viewHolderClass.swipe_reproduction_info_list.getSurfaceView().setOnClickListener(new android.view.View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(android.view.View v) {
                detailsViewIntent(item, viewHolderClass);
            }
        });

        viewHolderClass.img_delete.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                items.remove(i);
                notifyDataSetChanged();
                mItemManger.closeAllItems();
                Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolderClass.img_edit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                context.startActivity(new Intent(context, Form.class));
            }
        });

        viewHolderClass.img_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                detailsViewIntent(item, viewHolderClass);
            }
        });

        mItemManger.bindView(viewHolderClass.itemView, i);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_reproduction_info_list;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView tv_id, tv_heat_date, tv_next_delivery_date, tv_last_delivery_date;
        ImageView img_edit, img_delete, img_info;
        Typeface bangla_font;
        SwipeLayout swipe_reproduction_info_list;
        CardView cv_main_content;


        public ViewHolderClass(@NonNull android.view.View itemView) {
            super(itemView);

            swipe_reproduction_info_list= itemView.findViewById(R.id.swipe_reproduction_info_list);

            cv_main_content = itemView.findViewById(R.id.cv_main_content);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_heat_date = itemView.findViewById(R.id.tv_heat_date);
            tv_next_delivery_date = itemView.findViewById(R.id.tv_next_delivery_date);
            tv_last_delivery_date = itemView.findViewById(R.id.tv_last_delivery_date);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_info = itemView.findViewById(R.id.img_info);

            bangla_font = Typeface.createFromAsset(context.getAssets(), "fonts/KalpurushANSI.ttf");

            tv_id.setTypeface(bangla_font);
            tv_heat_date.setTypeface(bangla_font);
            tv_next_delivery_date.setTypeface(bangla_font);
            tv_last_delivery_date.setTypeface(bangla_font);


        }
    }

    @SuppressLint("NewApi")
    private void detailsViewIntent(HashMap<String, String> item, ViewHolderClass viewHolderClass){

        pairs[0] = new Pair<android.view.View, String>(viewHolderClass.cv_main_content, context.getString(R.string.transaction_layout));

        options = ActivityOptions.makeSceneTransitionAnimation((Activity)context, pairs);

        Intent detailIntent = new Intent(context, View.class);

//        try{
//            context.startActivity(detailIntent, options.toBundle());
//        }
//        catch (Exception e){
//
//            context.startActivity(detailIntent);
//        }

        context.startActivity(detailIntent);

        mItemManger.closeAllItems();
    }
}
