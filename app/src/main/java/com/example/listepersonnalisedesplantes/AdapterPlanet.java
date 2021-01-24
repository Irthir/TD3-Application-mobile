package com.example.listepersonnalisedesplantes;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlanet extends ArrayAdapter<Planete> {

    int viewRes;
    ArrayList<Planete> ListePlanetes;
    Context context;
    Resources res;

    static class ViewHolder
    {
        TextView planete;
        TextView distance;
        ImageView image;
    }

    public AdapterPlanet(Context context, int textViewResourceId, ArrayList<Planete> planetes)
    {
        super(context,textViewResourceId,planetes);
        this.ListePlanetes=planetes;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceId;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent)
    {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes,parent,false);
            holder = new ViewHolder();
            holder.planete = (TextView) view.findViewById(R.id.planete);
            holder.distance = (TextView) view.findViewById(R.id.distance);
            holder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
        }else
        {
            holder=(ViewHolder)view.getTag();
        }
        final Planete planete = ListePlanetes.get(position);
        if(planete!=null)
        {
            final String sPlanete = planete.getNomPlanete();
            holder.planete.setText(sPlanete);
            final String sDistance = String.format("dist moy : %s millions kms",planete.getDistancePlanete());
            holder.distance.setText(sDistance);
            int nResource = planete.getImagePlanete();
            holder.image.setImageResource(nResource);
        }
        return view;
    }

    public int getCount()
    {
        return ListePlanetes.size();
    }
}
