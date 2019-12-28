package com.example.musicfinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProcessJSON extends AsyncTask<String,Void,String>
{

    Context a;
    String stream;
    View parent;
    public ProcessJSON(Context v, View pv) {
        this.a = v;
        this.parent = pv;
    }



    protected String doInBackground(String... strings)
    {

        String urlString = strings[0];

        HTTPDataHandler hh = new HTTPDataHandler();
        stream = hh.getHTTPData(urlString);
        return stream;
    }

    protected void onPostExecute(String stream)
    {
        final String[] element = new String[10];
        final String[] links = new String[10];
        Log.v("Key1","Executing data");

        if(stream!=null)
        {
            try {
                JSONObject reader = new JSONObject(stream);
                JSONObject fObj = reader.getJSONObject( "results" );
                JSONObject othObj = fObj.getJSONObject( "trackmatches" );

                JSONArray trackArray = othObj.getJSONArray("track");

                for(int i = 0;i<=9;i++)
                {
                    JSONObject trackObject = trackArray.getJSONObject(i);

                    String name = trackObject.getString("name");
                    String artist = trackObject.getString("artist");
                    String u = trackObject.getString("url");

                    if(name != null && artist != null && u!=null)
                    {
                        element[i] = "Name: "+name+"\n"+"Artist: "+artist+"\n"+"Link: "+u;
                        links[i] = u;
                    }

                }

                ListView listView = parent.findViewById(R.id.listview);
                listView.setAdapter(
                        new ArrayAdapter<>(
                                a,
                                android.R.layout.simple_list_item_1,
                                element
                        ));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(links[i]));
                        a.startActivity(browserIntent);
                    }
                });

            } catch (JSONException e) {
                Log.wtf( "WTF",e.getMessage() );
                e.printStackTrace();
            }

        }
        else
        {
            Toast.makeText( a,"Stream is null ",Toast.LENGTH_LONG ).show();
            Log.v("Key3","Stream is null ");

        }

    }

}
