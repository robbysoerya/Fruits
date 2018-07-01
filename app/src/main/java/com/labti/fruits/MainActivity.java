package com.labti.fruits;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Model> arrayFruit = new ArrayList<>();
    String fruits = "{\n" +
            "  \"fruits\" : [\n" +
            "    {\n" +
            "      \"name\" : \"Apel\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
            "      \"id\" : \"Apel adalah jenis buah-buahan, atau buah yang dihasilkan dari pohon buah apel. Buah apel biasanya berwarna merah kulitnya jika masak dan, namun bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek, daging buahnya keras.\",\n" +
            "      \"en\" : \"Apples are a type of fruit, or fruit produced from an apple tree. Apples are usually red in color if cooked and, but can also be green or yellow skin. The skin of the fruit is rather soft, the flesh is hard.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Pisang\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg\",\n" +
            "      \"id\" : \"Pisang adalah nama umum yang diberikan pada tumbuhan terna raksasa berdaun besar memanjang dari suku Musaceae. Beberapa jenisnya menghasilkan buah konsumsi yang dinamakan sama.\",\n" +
            "      \"en\" : \"Bananas are a common name given to large giant leafy terna plants extending from the Musaceae tribe. Some species produce fruit of consumption called the same.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Anggur\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Table_grapes_on_white.jpg/320px-Table_grapes_on_white.jpg\",\n" +
            "      \"id\" : \"Anggur merupakan tanaman buah berupa perdu merambat yang termasuk ke dalam keluarga Vitaceae. Buah ini biasanya digunakan untuk membuat jus anggur, jelly, minuman anggur, minyak biji anggur dan kismis, atau dimakan langsung.\",\n" +
            "      \"en\" : \"Grape is a fruit plant of vines that belong to the family Vitaceae. The fruit is usually used to make grape juice, jelly, wine, grape seed oil and raisins, or eaten directly.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Nanas\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/286px-Pineapple_and_cross_section.jpg\",\n" +
            "      \"id\" : \"Nanas, nenas, atau ananas adalah sejenis tumbuhan tropis yang berasal dari Brasil, Bolivia, dan Paraguay Tumbuhan ini termasuk dalam familia nanas-nanasan.\",\n" +
            "      \"en\" : \"Pineapple, pineapple, or ananas are a kind of tropical plant originating from Brazil, Bolivia, and Paraguay These plants belong to the pineapple familia-nanasan.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Salak\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Salak200507.jpg/800px-Salak200507.jpg\",\n" +
            "      \"id\" : \"Salak adalah sejenis palma dengan buah yang biasa dimakan. Ia dikenal juga sebagai sala. Dalam bahasa Inggris disebut salak atau snake fruit, sementara nama ilmiahnya adalah Salacca zalacca.\",\n" +
            "      \"en\" : \"Salak is a type of palm fruit commonly eaten. He is also known as sala. In English is called bark or snake fruit, while its scientific name is Salacca zalacca.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Alpukat\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Avocado_fruitnfoliage.jpg/800px-Avocado_fruitnfoliage.jpg\",\n" +
            "      \"id\" : \"Apokat, avokad, atau Persea americana ialah tumbuhan penghasil buah meja dengan nama sama. Tumbuhan ini berasal dari Meksiko dan Amerika Tengah dan kini banyak dibudidayakan di Amerika Selatan\",\n" +
            "      \"en\" : \"Avocados, avocados, or Persea americana are fruit-producing plants of the same name. This plant originated in Mexico and Central America and is now widely cultivated in South America\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Jambu\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Jambuair2.jpg/800px-Jambuair2.jpg\",\n" +
            "      \"id\" : \"Jambu air adalah tumbuhan dalam suku jambu-jambuan atau Myrtaceae yang berasal dari Asia Tenggara. Jambu air sebetulnya berbeda dengan jambu semarang, kerabat dekatnya yang memiliki pohon dan buah hampir serupa.\",\n" +
            "      \"en\" : \"Guava is a plant in the tribe or Myrtaceae originating from Southeast Asia. Guava water is actually different from cashew semarang, its close relative has tree and fruit almost similar.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Mangga\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/9/91/Mangga_gedong_gincu_071021-0845_tmo.jpg\",\n" +
            "      \"id\" : \"Mangga atau mempelam adalah nama sejenis buah, demikian pula nama pohonnya. Mangga termasuk ke dalam marga Mangifera, yang terdiri dari 35-40 anggota dan suku Anacardiaceae. Nama ilmiahnya adalah Mangifera indica.\",\n" +
            "      \"en\" : \"Mango or Diving is the name of a kind of fruit, as is the name of the tree. Mango belongs to the Mangifera clan, which consists of 35-40 members and Anacardiaceae tribe. Its scientific name is Mangifera indica.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Belimbing\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/6/62/Averrhoa_carambola_ARS_k5735-7.jpg\",\n" +
            "      \"id\" : \"Belimbing / Belimbing Manis adalah tumbuhan penghasil buah berbentuk khas yang berasal dari Indonesia, India, dan Sri Langka.\",\n" +
            "      \"en\" : \"Starfruit Sweet is a typical fruit-shaped fruit plant originating from Indonesia, India and Sri Lanka.\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject reader = new JSONObject(fruits);
            JSONArray jsonArray = reader.getJSONArray("fruits");

            for (int i =0; i< jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String image = jsonObject.getString("image");
                String detailid = jsonObject.getString("id");
                String detailen = jsonObject.getString("en");
                arrayFruit.add(new Model(name,image,detailid,detailen));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        final Adapter adapter = new Adapter(this,arrayFruit);
        lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = adapter.mlist.get(position).getName();
                String image = adapter.mlist.get(position).getImage();
                String detailid = adapter.mlist.get(position).getDetailid();
                String detailen = adapter.mlist.get(position).getDetailen();
                Intent intent = new Intent(MainActivity.this,Pager.class);
                intent.putExtra("name",name);
                intent.putExtra("image",image);
                intent.putExtra("id",detailid);
                intent.putExtra("en",detailen);
                startActivity(intent);
            }
        });

    }
}
