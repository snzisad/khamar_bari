package com.bstech.khamarapp.HelperClasses.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.HashMap;

/**
 * Created by hp on 1/23/2019.
 */

public class MilkInfoFormAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList data;
    private final int HEADER_TYPE = 1;
    private final int CONTENT_TYPE = 2;
    private final int FOOTER_TYPE = 3;

    public MilkInfoFormAdapter(Context context, ArrayList data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == HEADER_TYPE){
            View v = LayoutInflater.from(context).inflate(R.layout.layout_date, viewGroup,false);
            return new HeaderClass(v);
        }

        else if(i == FOOTER_TYPE){
            View v = LayoutInflater.from(context).inflate(R.layout.layout_footer_button, viewGroup,false);
            return new FooterClass(v);
        }

        else{
            View v = LayoutInflater.from(context).inflate(R.layout.layout_milk_cow_milk_entry, viewGroup,false);
            return new ContentClass(v);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        if(viewHolder.getItemViewType() == HEADER_TYPE){
            final HeaderClass headerClass = (HeaderClass) viewHolder;

            headerClass.tv_change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else if(viewHolder.getItemViewType() == FOOTER_TYPE){
            final FooterClass footerClass = (FooterClass) viewHolder;

            footerClass.btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Coming Soon !!!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else{
            final ContentClass contentClass = (ContentClass) viewHolder;
            final HashMap<String, String> content = (HashMap<String, String>) data.get(i);

            contentClass.tv_id.setText(context.getString(R.string.title_cow) + "#" + content.get("id"));
            contentClass.edt_milk_amount.setText(content.get("amount"));

        }
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0) return HEADER_TYPE;
        else if(position == data.size()) return FOOTER_TYPE;
        else return CONTENT_TYPE;

    }

    public class ContentClass extends RecyclerView.ViewHolder{

        TextView tv_id;
        EditText edt_milk_amount;
        ImageView img_cow_pic;
        Typeface bangla_font;


        public ContentClass(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            edt_milk_amount = itemView.findViewById(R.id.edt_milk_amount);
            img_cow_pic = itemView.findViewById(R.id.img_cow_pic);

            bangla_font = Typeface.createFromAsset(context.getAssets(), "fonts/KalpurushANSI.ttf");

            tv_id.setTypeface(bangla_font);
            edt_milk_amount.setTypeface(bangla_font);

        }
    }

    public class HeaderClass extends RecyclerView.ViewHolder{
        TextView tv_date, tv_change;
        Typeface bangla_font;

        public HeaderClass(@NonNull View itemView) {
            super(itemView);

            tv_date = itemView.findViewById(R.id.tv_date);
            tv_change = itemView.findViewById(R.id.tv_change);
            bangla_font = Typeface.createFromAsset(context.getAssets(), "fonts/KalpurushANSI.ttf");

            tv_date.setTypeface(bangla_font);
        }
    }

    public class FooterClass extends RecyclerView.ViewHolder{
        Button btn_done;

        public FooterClass(@NonNull View itemView) {
            super(itemView);

            btn_done = itemView.findViewById(R.id.btn_done);
        }
    }

}
