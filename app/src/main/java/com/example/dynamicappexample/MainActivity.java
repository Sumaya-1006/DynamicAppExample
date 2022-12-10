package com.example.dynamicappexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_posts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);

        Call<List<Post>> call = jsonPlaceHolder.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post> postList = response.body();
                PostAdapter postAdapter = new PostAdapter(getApplicationContext(),postList);
                recyclerView.setAdapter(postAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    //  createPost();
       // updatePost();
       // patchPost();
       // deleteData();
        


    }

   /* private void deleteData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);
        Call<Void> call = jsonPlaceHolder.deletePost(2);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    return;
                }
                Toast.makeText(MainActivity.this, "Successfully deleted data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    } */

   /* private void patchPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);
        Post post = new Post("16","first tittle",null);
        Call<Post> call = jsonPlaceHolder.patchPost(2, post);


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()) {
                    return;
                }
                List<Post> postList = new ArrayList<>();
                postList.add(response.body());
                PostAdapter postAdapter = new PostAdapter(getApplicationContext(),postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    } */

 /*  private void updatePost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);
        Post post = new Post("16","first tittle","null");
        Call<Post> call = jsonPlaceHolder.updatePost(2, post);


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()) {
                    return;
                }
                List<Post> postList = new ArrayList<>();
                postList.add(response.body());
                PostAdapter postAdapter = new PostAdapter(getApplicationContext(),postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    } */

   /* private void createPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);
        Post post = new Post("18","first tittle","first body");
        Call<Post> call = jsonPlaceHolder.createPost(post);

       call.enqueue(new Callback<Post>() {
           @Override
           public void onResponse(Call<Post> call, Response<Post> response) {
               if(!response.isSuccessful()) {
                   Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                   return;
               }
               List<Post> postList = new ArrayList<>();
               postList.add(response.body());
               PostAdapter postAdapter = new PostAdapter(getApplicationContext(),postList);
               recyclerView.setAdapter(postAdapter);



           }

           @Override
           public void onFailure(Call<Post> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

           }
       })



    }   */
}