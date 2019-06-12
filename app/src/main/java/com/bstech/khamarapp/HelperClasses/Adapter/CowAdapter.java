package com.bstech.khamarapp.HelperClasses.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bstech.khamarapp.CowInfo.Form;
import com.bstech.khamarapp.HelperClasses.Model.CowModel;
import com.bstech.khamarapp.R;
import com.bstech.khamarapp.ReproductionInfo.List;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;

/**
 * Created by hp on 1/23/2019.
 */

public class CowAdapter extends RecyclerSwipeAdapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<CowModel> cowModel;
    private Pair[] pairs;
    private ActivityOptions options;

    public CowAdapter(Context context, ArrayList<CowModel>cowModel){
        this.context = context;
        this.cowModel = cowModel;

        pairs = new Pair[1];
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_cow_list, viewGroup,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(v);
        return viewHolderClass;
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        final CowModel cow = cowModel.get(i);
        final ViewHolderClass viewHolderClass = (ViewHolderClass) viewHolder;

        viewHolderClass.tv_id.setText(context.getString(R.string.id_bn)+cow.getId());
        viewHolderClass.tv_birth_date.setText(context.getString(R.string.bdate_bn)+cow.getBirthdate());
        viewHolderClass.tv_species.setText(context.getString(R.string.species_bn)+cow.getSpecies());

        viewHolderClass.swipe_cow_list.setShowMode(SwipeLayout.ShowMode.PullOut);

//        left to right swipe menu
        viewHolderClass.swipe_cow_list.addDrag(SwipeLayout.DragEdge.Left, viewHolderClass.swipe_cow_list.findViewById(R.id.cv_right_menu));

//        right to left swipe menu
        viewHolderClass.swipe_cow_list.addDrag(SwipeLayout.DragEdge.Right, viewHolderClass.swipe_cow_list.findViewById(R.id.cv_left_menu));


        viewHolderClass.swipe_cow_list.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                cowDetailsIntent(cow, viewHolderClass);
            }
        });

        viewHolderClass.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cowModel.remove(i);
                notifyDataSetChanged();
                mItemManger.closeAllItems();
                Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolderClass.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, Form.class));
            }
        });

        viewHolderClass.img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cowDetailsIntent(cow, viewHolderClass);
            }
        });

        mItemManger.bindView(viewHolderClass.itemView, i);
    }

    @Override
    public int getItemCount() {
        return cowModel.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_cow_list;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView tv_id, tv_birth_date, tv_species;
        ImageView img_cow_pic, img_edit, img_delete, img_info;
        Typeface bangla_font;
        SwipeLayout swipe_cow_list;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            swipe_cow_list= itemView.findViewById(R.id.swipe_cow_list);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_birth_date = itemView.findViewById(R.id.tv_birth_date);
            tv_species = itemView.findViewById(R.id.tv_species);
            img_cow_pic = itemView.findViewById(R.id.img_cow_pic);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_info = itemView.findViewById(R.id.img_info);

            bangla_font = Typeface.createFromAsset(context.getAssets(), "fonts/KalpurushANSI.ttf");

            tv_id.setTypeface(bangla_font);
            tv_birth_date.setTypeface(bangla_font);
            tv_species.setTypeface(bangla_font);


        }
    }

    @SuppressLint("NewApi")
    private void cowDetailsIntent(CowModel cow, ViewHolderClass viewHolderClass){
        Toast.makeText(context, "ID: "+cow.getId(), Toast.LENGTH_SHORT).show();

        pairs[0] = new Pair<View, String>(viewHolderClass.img_cow_pic, context.getString(R.string.transaction_image));
//        pairs[1] = new Pair<View, String>(viewHolderClass.tv_id, context.getString(R.string.transaction_id));

        options = ActivityOptions.makeSceneTransitionAnimation((Activity)context, pairs);

        Intent detailIntent = new Intent(context, List.class);
        context.startActivity(detailIntent, options.toBundle());
        mItemManger.closeAllItems();

    }
}
