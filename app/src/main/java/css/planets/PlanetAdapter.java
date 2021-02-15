package css.planets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {

    private List<Planet> planetList;
    private Context context;

    public PlanetAdapter(Context context, int resource, List<Planet> planets) {
        //super(context, R.layout.country_list_item, R.id.txtViewCountryName, objects);
        super(context, resource, planets);
        this.context = context;
        this.planetList = planets;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return setupView(position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return setupView(position);
    }

    private View setupView(int position) {
        //get the planet we are displaying
        Planet planet = planetList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.planet_row, null);

        TextView tvName=(TextView)view.findViewById(R.id.textViewPlanetName);
        TextView tvDistance=(TextView)view.findViewById(R.id.textViewPlanetDistance);
        TextView tvDiameter=(TextView)view.findViewById(R.id.textViewPlanetDiameter);
        tvName.setText(planet.getName());
        tvDistance.setText(planet.getDistanceFromSol().toString());
        tvDiameter.setText(planet.getDiameter().toString());
        return view;
    }
}