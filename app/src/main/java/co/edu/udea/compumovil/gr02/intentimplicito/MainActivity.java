package co.edu.udea.compumovil.gr02.intentimplicito;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


   /* public void llamarIntento(View view) {
        Intent intent = null;
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        int opcion = spinner.getSelectedItemPosition();
        switch (opcion) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+57)3103458466"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+57)3103458466"));
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 6.264033, -75.568543"));
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0,0?q=query"));
                startActivity(intent);
                break;
            case 5:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
                break;
            case 6:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            default:
                break;

        }


    }*/

    public void llamarIntento(int opcion) {
        Intent intent = null;

        switch (opcion) {
            case 0:
                Toast.makeText(this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:3205822875"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+57)3103458466"));
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 6.264033, -75.568543"));
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0,0?q=query"));
                startActivity(intent);
                break;
            case 6:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
                break;
            case 7:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            default:
                break;

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK && requestCode == 0){
            String result = data.toURI();
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          llamarIntento(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
