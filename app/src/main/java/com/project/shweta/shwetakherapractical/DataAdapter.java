package com.project.shweta.shwetakherapractical;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<Profile> profileList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView fn, ln, dob, textView,textView3,textView5;
        public ImageView circle1,circle2,circle3,line1,line2;
        public ConstraintLayout main;

        public MyViewHolder(View view) {
            super(view);
            fn = view.findViewById(R.id.fn);
            ln = view.findViewById(R.id.ln);
            dob = view.findViewById(R.id.dob);

            circle1 = view.findViewById(R.id.circle1);
            circle2 = view.findViewById(R.id.circle2);
            circle3 = view.findViewById(R.id.circle3);
            line1 = view.findViewById(R.id.line1);
            line2 = view.findViewById(R.id.line2);

            textView = view.findViewById(R.id.textView);
            textView3 = view.findViewById(R.id.textView3);
            textView5 = view.findViewById(R.id.textView5);

            main = view.findViewById(R.id.main);
        }
    }


    public DataAdapter(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        String first,last,DOB;

        first = profile.getFirstName();
        last = profile.getLastName();
        DOB = profile.getDob();

        holder.fn.setText(first);
        holder.ln.setText(last);
        holder.dob.setText(DOB);


        if(first.equals("") && last.equals("") && !DOB.equals("")){
            holder.circle3.setVisibility(View.VISIBLE);
            holder.textView5.setVisibility(View.VISIBLE);
            holder.dob.setVisibility(View.VISIBLE);
        }
        else if( first.equals("") && !last.equals("") && DOB.equals("")){
            holder.circle2.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.ln.setVisibility(View.VISIBLE);
        }
        else if( !first.equals("") && last.equals("") && DOB.equals("")){
            holder.circle1.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.VISIBLE);
            holder.fn.setVisibility(View.VISIBLE);
        }
        else if( first.equals("") && !last.equals("") && !DOB.equals("")){
            holder.circle3.setVisibility(View.VISIBLE);
            holder.circle2.setVisibility(View.VISIBLE);
            holder.line2.setVisibility(View.VISIBLE);

            holder.textView5.setVisibility(View.VISIBLE);
            holder.dob.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.ln.setVisibility(View.VISIBLE);

        }
        else if( !first.equals("") && last.equals("") && !DOB.equals("")){
            holder.circle3.setVisibility(View.VISIBLE);
            holder.circle1.setVisibility(View.VISIBLE);
            holder.line2.setVisibility(View.VISIBLE);

            holder.textView5.setVisibility(View.VISIBLE);
            holder.dob.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.VISIBLE);
            holder.fn.setVisibility(View.VISIBLE);
        }
        else if( !first.equals("") && !last.equals("") && DOB.equals("")){
            holder.circle1.setVisibility(View.VISIBLE);
            holder.circle2.setVisibility(View.VISIBLE);
            holder.line1.setVisibility(View.VISIBLE);

            holder.textView.setVisibility(View.VISIBLE);
            holder.fn.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.ln.setVisibility(View.VISIBLE);
        }
        else if( !first.equals("") && !last.equals("") && !DOB.equals("")){
            holder.circle3.setVisibility(View.VISIBLE);
            holder.circle1.setVisibility(View.VISIBLE);
            holder.line2.setVisibility(View.VISIBLE);
            holder.line1.setVisibility(View.VISIBLE);
            holder.circle2.setVisibility(View.VISIBLE);

            holder.textView5.setVisibility(View.VISIBLE);
            holder.dob.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.ln.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.VISIBLE);
            holder.fn.setVisibility(View.VISIBLE);
        }
        else if(first.equals("") && last.equals("") && DOB.equals(""))
            holder.main.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}
