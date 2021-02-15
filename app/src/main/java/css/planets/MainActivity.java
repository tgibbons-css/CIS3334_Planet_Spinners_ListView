package css.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerStandard, spinnerCustom;
    TextView tvDisplayItem;
    ListView listViewPlanets;
    ArrayList<Planet> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--------------------------------------
        tvDisplayItem = (TextView) findViewById(R.id.textViewDisplayItem);
        listViewPlanets = (ListView) findViewById(R.id.listViewPlanets);
        //--------------------------------------
        initializePlanetList();
        setupStandardSpinner();
        setupCustomSpinner();
        setupListView();
    }

    private void initializePlanetList() {
        planetList = new ArrayList<Planet>();
        // planet data from http://www.enchantedlearning.com/subjects/astronomy/planets/
        planetList.add(new Planet("Mercury", 57.9, 4800));
        planetList.add(new Planet("Venus", 108.2, 12104));
        planetList.add(new Planet("Earth", 149.6, 12700));
        planetList.add(new Planet("Mars", 227.9, 6700));
        planetList.add(new Planet("Jupiter", 778.3, 143000));
        planetList.add(new Planet("Saturn", 1427.0, 120000));
        planetList.add(new Planet("Uranus", 2871.0, 51100));
        planetList.add(new Planet("Neptune", 4497.1, 48600));
        planetList.add(new Planet("Pluto (dwarf)", 5913.0, 2274));
        planetList.add(new Planet("Tatoonie", 99999.9, 11000));
        planetList.add(new Planet("Hoth", 99999.9, 7000));
        planetList.add(new Planet("Naboo", 99999.9, 14000));
        planetList.add(new Planet("Alderaan", 99999.9, 15000));
        planetList.add(new Planet("Dagobah", 99999.9, 11000));
    }

    private void setupStandardSpinner() {
        spinnerStandard = (Spinner) findViewById(R.id.spinnerJava);
        // Read the planet names from the strings.xml file
        String  planetNames[] = getResources().getStringArray(R.array.planets_array);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetNames);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerStandard.setAdapter(itemsAdapter);
        //-------------------------------------
        spinnerStandard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDisplayItem.setText("Planet: " + parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    private void setupCustomSpinner() {
        spinnerCustom = (Spinner) findViewById(R.id.spinnerCustom);
        // create the custom array adapter. The 3rd parameter is just a placeholder for the parent class pointing to any textview in the new layout.
        PlanetAdapter planetAdapter = new PlanetAdapter(this, 0, planetList);
        planetAdapter.setDropDownViewResource(R.layout.planet_row);
        spinnerCustom.setAdapter(planetAdapter);
        //-------------------------------------
        spinnerCustom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet planet = planetList.get(position);
                tvDisplayItem.setText("Planet : " + planet.getName());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //-------------------------------------
    }

    private void setupListView() {
        PlanetAdapter planetScrollAdapter = new PlanetAdapter(this, 0, planetList);
        planetScrollAdapter.setDropDownViewResource(R.layout.planet_row);
        listViewPlanets.setAdapter(planetScrollAdapter);
    }

}