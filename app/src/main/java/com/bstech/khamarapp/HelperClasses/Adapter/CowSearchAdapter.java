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
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
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

public class CowSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    private Context context;
    private ArrayList<CowModel> cowModel, cowModelFresh;

    public CowSearchAdapter(Context context, ArrayList<CowModel> data){
        this.context = context;
        this.cowModel = data;
        cowModelFresh = data;
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
        viewHolderClass.tv_click_title.setText(context.getString(R.string.click_to_add_title_bn));

        viewHolderClass.cv_main_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cowModel.size();
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView tv_id, tv_birth_date, tv_species, tv_click_title;
        ImageView img_cow_pic, img_edit, img_delete, img_info;
        Typeface bangla_font;
        SwipeLayout swipe_cow_list;
        CardView cv_main_content;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            swipe_cow_list= itemView.findViewById(R.id.swipe_cow_list);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_birth_date = itemView.findViewById(R.id.tv_birth_date);
            tv_species = itemView.findViewById(R.id.tv_species);
            tv_click_title = itemView.findViewById(R.id.tv_click_title);
            img_cow_pic = itemView.findViewById(R.id.img_cow_pic);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_info = itemView.findViewById(R.id.img_info);
            cv_main_content = itemView.findViewById(R.id.cv_main_content);

            bangla_font = Typeface.createFromAsset(context.getAssets(), "fonts/KalpurushANSI.ttf");

            tv_id.setTypeface(bangla_font);
            tv_birth_date.setTypeface(bangla_font);
            tv_species.setTypeface(bangla_font);

            swipe_cow_list.setSwipeEnabled(false);

        }
    }



    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<CowModel> filterResult = new ArrayList<>();


            if(charSequence == null || charSequence.length() == 0){
                filterResult.addAll(cowModelFresh);
            }
            else{
                String pattern = charSequence.toString().toLowerCase().trim();

                try{
                    int cow_id = Integer.parseInt(pattern);

                    for (int i=0; i<cowModelFresh.size(); i++){
                        if(cow_id == cowModelFresh.get(i).getId()){
                            filterResult.add(cowModelFresh.get(i));
                        }
                    }

                }
                catch (Exception e){
                    Toast.makeText(context, "Please enter cow ID", Toast.LENGTH_SHORT).show();
                    filterResult.addAll(cowModelFresh);
                }

            }

            FilterResults results = new FilterResults();
            results.values = filterResult;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            cowModel = new ArrayList<>();

            ArrayList<CowModel> filterData = (ArrayList) filterResults.values;

            cowModel.addAll(filterData);
            notifyDataSetChanged();
        }
    };
}
