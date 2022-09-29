package br.com.up.zap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//import br.com.up.zap.R;
import br.com.up.zap.adapter.MessageAdapter;
import br.com.up.zap.model.Message;
import br.com.up.zap.repository.MessageRepository;

public class MainActivity extends AppCompatActivity {

    //private FloatingActionButton buttonAddMessage;
    private RecyclerView recyclerViewMessage;
    public TextView textViewMessageNotFound;

    private Button buttonAddInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMessage = findViewById(R.id.recycler_message);
        textViewMessageNotFound = findViewById(R.id.text_message_not_found);

        recyclerViewMessage.setLayoutManager(
                //new GridLayoutManager(this,10)
                new LinearLayoutManager(this)
        );

        buttonAddInfo = findViewById(R.id.button_add);
        buttonAddInfo.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        AddMessageActivity.class
                );
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Message> messages = MessageRepository.getInstance().get();
        if(messages.size() > 0){
            textViewMessageNotFound.setVisibility(View.INVISIBLE);
        }else{
            textViewMessageNotFound.setVisibility(View.VISIBLE);
        }
        MessageAdapter messageAdapter = new MessageAdapter(ArrayList<Message> messages);
        recyclerViewMessage.setAdapter(messageAdapter);
    }
}